package br.com.easy.service;

import java.io.Serializable;

import javax.inject.Inject;

import br.com.easy.dao.ImagemEmpresaDao;
import br.com.easy.model.ImagemEmpresa;

public class ImagemEmpresaService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	ImagemEmpresaDao dao;
	
	
     public void addImagemEmpresaService(ImagemEmpresa imagemEmpresa){
    	 
      	dao.addImagemEmpresa(imagemEmpresa);
      	
    	 
     }
     
     public ImagemEmpresa findImagemEmpresaService(int id){
		return dao.findImagemEmpresa(id);
    	 
    	 

     }
	
	
	

}
