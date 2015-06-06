package br.com.easy.mb;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.Part;

import org.primefaces.event.FileUploadEvent;

import br.com.easy.dominio.TipoOrigemProduto;
import br.com.easy.exception.NegocioException;
import br.com.easy.model.Categoria;
import br.com.easy.model.Empresa;
import br.com.easy.model.ImagemProduto;
import br.com.easy.model.Produto;
import br.com.easy.service.EmpresaService;
import br.com.easy.service.ProdutoService;

@Named
@ViewScoped
public class CadastroProdutoBean extends BasicBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Categoria> categorias;
	  @Inject
    private Empresa empresa;
	@Inject
	private ProdutoService produtoService;
	@Inject
	private Categoria categoria;
	private Part arquivo;
	private List<Categoria> subCategorias;
	@Inject
	private Categoria subcategoria;
	@Inject
	private Produto produto;
	@Inject
	private ImagemProduto imagem;
	@Inject
	private UsuarioLogadoBean usuario;
	@Inject
	EmpresaService empresaService;
	
	boolean isImagevalida = false;

	public void salvar() {
		System.out.println("Metodo salvar produto executando");
		validaImagem();
		this.empresa =this.empresaService.buscarEmpresaById(this.usuario.getUsuario().getEmpresa().getCodigo());
		this.produto.setProdutoEmpresa(this.empresa);
		this.produto.setOrigemProduto(TipoOrigemProduto.SISTEMA.getValor());
		this.produto.setProdutoImagem(imagem);
		this.produto.setCategoria(this.subcategoria);
		this.imagem.setProduto(produto);
		produtoService.salvarProdutoService(produto);
		limparCampos();
		info("Produto cadastrado com sucesso");

	}

	public void handleFileUpload(FileUploadEvent event) {
		preencherImagem(event, imagem);
		isImagevalida = true;
		FacesMessage message = new FacesMessage("Sucesso", event.getFile()
				.getFileName() + " is uploaded.");
		FacesContext.getCurrentInstance().addMessage(null, message);
		
	}

	public void limparCampos() {

		this.produto = new Produto();
		this.imagem = new ImagemProduto();
		this.categoria = new Categoria();
		this.subcategoria = new Categoria();
		this.categorias = this.produtoService.categoriaRaizesService();
		this.subCategorias = new ArrayList<Categoria>();
		this.isImagevalida = false;

	}

	public void preencherImagem(FileUploadEvent event, ImagemProduto imagem) {
		System.out.println("preecher imagem executando");
		try {
			byte[] arqBytes = new byte[(int) event.getFile().getSize()];
			event.getFile().getInputstream().read(arqBytes);
			this.imagem.setType(event.getFile().getContentType());
			this.imagem.setFoto(arqBytes);

		} catch (IOException e) {

			error("Erro ao enviar imagem do produto");
			e.printStackTrace();
		}

	}

	@PostConstruct
	public void iniciar() {

		if (isNotPostback()) {

			this.categorias = produtoService.categoriaRaizesService();

		}

	}

	public void validaImagem() {
		if (!isImagevalida) {

			throw new NegocioException("Logomarca deve ser informada.");

		}

	}

	public void preencherSubcategoria(AjaxBehaviorEvent event) {

		this.subCategorias = produtoService.subcategoriaRaizes(this.categoria);

	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public ProdutoService getProdutoService() {
		return produtoService;
	}

	public void setProdutoService(ProdutoService produtoService) {
		this.produtoService = produtoService;
	}

	public Part getArquivo() {
		return arquivo;
	}

	public void setArquivo(Part arquivo) {
		this.arquivo = arquivo;
	}

	public List<Categoria> getSubCategorias() {
		return subCategorias;
	}

	public void setSubCategorias(List<Categoria> subCategorias) {
		this.subCategorias = subCategorias;
	}

	public Categoria getSubcategoria() {
		return subcategoria;
	}

	public void setSubcategoria(Categoria subcategoria) {
		this.subcategoria = subcategoria;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
		// if (this.produto != null) {
		// this.categoriaPai = this.produto.getCategoria().getCategoriaPai();
		// }
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

	public ImagemProduto getImagem() {
		return imagem;
	}

	public void setImagem(ImagemProduto imagem) {
		this.imagem = imagem;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public UsuarioLogadoBean getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioLogadoBean usuario) {
		this.usuario = usuario;
	}

}
