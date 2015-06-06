package br.com.easy.mb;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.easy.dominio.StatusAnuncio;
import br.com.easy.model.Anuncio;
import br.com.easy.model.Empresa;
import br.com.easy.model.Produto;
import br.com.easy.service.AnuncioService;
import br.com.easy.service.EmpresaService;
import br.com.easy.service.ProdutoService;

@Named
@ViewScoped
public class CadastrarAnuncioBean extends BasicBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Anuncio anuncio;
	@Inject
	AnuncioService anuncioService;
	@Inject
	private ProdutoService produtoService;
	@Inject
	private Produto produtoSelecionado;
	@Inject
	private Empresa empresa;
	@Inject
	private EmpresaService empresaService;
	@Inject
	private UsuarioLogadoBean usuarioLogado;

	public void salvar() {
   
	System.out.println("metodo salvar anuncio executando");
	this.empresa = empresaService.buscarEmpresaById(this.usuarioLogado.getUsuario().getEmpresa().getCodigo());
	this.anuncio.setEmpresa(this.empresa);
    this.anuncio.setDataAnuncio(new Date()); 
    this.anuncio.setStatusAnuncio(StatusAnuncio.ATIVO.getValor());
	this.anuncio.setProduto(this.produtoSelecionado);
	anuncioService.salvaAnuncioService(this.anuncio);
	anuncioService.atualizarNumeroAnuncios(this.anuncio);
	limparCampos();
	info("Anuncio cadastrado com sucesso");
	
	}
	
	
	public void limparCampos(){
		
		this.anuncio = new Anuncio();
		this.empresa = new Empresa();
		this.produtoSelecionado = new Produto();
		
		
	}

	public List<Produto> listProdutoByNome(String valor) {

		System.out.println("Executando auto complete");
		Produto produto = new Produto();

		if (valor != null) {
            produto.setNome(valor);
            produto.setProdutoEmpresa(this.usuarioLogado.getUsuario().getEmpresa());
			return produtoService.ProdutoServiceBynome(produto);

		}

		return null;

	}

	public Anuncio getAnuncio() {
		return anuncio;
	}

	public void setAnuncio(Anuncio anuncio) {
		this.anuncio = anuncio;
	}

	public ProdutoService getProdutoService() {
		return produtoService;
	}

	public void setProdutoService(ProdutoService produtoService) {
		this.produtoService = produtoService;
	}

	public Produto getProdutoSelecionado() {
		return produtoSelecionado;
	}

	public void setProdutoSelecionado(Produto produtoSelecionado) {
		this.produtoSelecionado = produtoSelecionado;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public EmpresaService getEmpresaService() {
		return empresaService;
	}

	public void setEmpresaService(EmpresaService empresaService) {
		this.empresaService = empresaService;
	}

	public UsuarioLogadoBean getUsuarioLogado() {
		return usuarioLogado;
	}

	public void setUsuarioLogado(UsuarioLogadoBean usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}

}
