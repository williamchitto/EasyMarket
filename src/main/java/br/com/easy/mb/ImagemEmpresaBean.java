package br.com.easy.mb;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.Part;

import br.com.easy.model.ImagemEmpresa;
import br.com.easy.service.ImagemEmpresaService;

@ViewScoped
@Named
public class ImagemEmpresaBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Part arquivo;
	@Inject
	private ImagemEmpresaService service;
	@Inject
	private ImagemEmpresa imagem;
	
	public void carregarImagem() throws IOException{
		
	
    

	}
	
	

	public Part getArquivo() {
		return arquivo;
	}

	public void setArquivo(Part arquivo) {
		this.arquivo = arquivo;
	}



	public ImagemEmpresaService getService() {
		return service;
	}



	public void setService(ImagemEmpresaService service) {
		this.service = service;
	}



	public ImagemEmpresa getImagem() {
		return imagem;
	}



	public void setImagem(ImagemEmpresa imagem) {
		this.imagem = imagem;
	}
	
	

}
