package br.com.easy.admin;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.FileUploadEvent;

import br.com.easy.dominio.TipoOrigemProduto;
import br.com.easy.exception.NegocioException;
import br.com.easy.mb.BasicBean;
import br.com.easy.mb.CadastroProdutoBean;
import br.com.easy.model.ImagemProduto;
import br.com.easy.model.Produto;
import br.com.easy.service.ProdutoService;

@Named
@ViewScoped
public class CadastroProdutoAdminBean extends BasicBean  implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private ImagemProduto imagem;
	@Inject
	private Produto produto;
	@Inject
	private ProdutoService produtoService;
	@Inject
	CadastroProdutoBean produtoBean;
	boolean isImageValida= false;
	
	
       
	public void salvarProduto(){
	     validarImage();
	     this.produto.setOrigemProduto(TipoOrigemProduto.SISTEMA_ADMIM.getValor());
		this.produto.setCategoria(this.produtoBean.getSubcategoria());
		this.produto.setProdutoImagem(imagem);
		this.imagem.setProduto(produto);
		produtoService.salvarProdutoService(produto);
		limparCampos();
		info("Produto cadastrado com sucesso.");
				
	}
	

	public void handleFileUpload(FileUploadEvent event) {
	    
		preencherImagem(event, imagem);
		isImageValida = true;
        FacesMessage message = new FacesMessage("Sucesso", event.getFile().getFileName() + " is uploaded.");
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
	
	
	public void validarImage(){
		
		if(!isImageValida){
			
			throw new NegocioException("Imagem deve ser enviada.");
			
		}
		
	}
	
	public void limparCampos(){
		
		this.produto = new Produto();
		this.imagem = new ImagemProduto();
		this.produtoBean.limparCampos();
		this.isImageValida= false;
		
		
	}
	
	
	
	public void preencherImagem(FileUploadEvent event,ImagemProduto imagem){
		 
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



	public ImagemProduto getImagem() {
		return imagem;
	}



	public void setImagem(ImagemProduto imagem) {
		this.imagem = imagem;
	}



	public Produto getProduto() {
		return produto;
	}



	public void setProduto(Produto produto) {
		this.produto = produto;
	}



	public ProdutoService getProdutoService() {
		return produtoService;
	}



	public void setProdutoService(ProdutoService produtoService) {
		this.produtoService = produtoService;
	}
		
}
