package br.com.easy.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.com.easy.dao.AnuncioDao;
import br.com.easy.model.Anuncio;

public class AnuncioService extends BasicService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private AnuncioDao anuncioDao;
	@Inject
	private Anuncio anuncio;
	
	
	
	public void salvaAnuncioService(Anuncio anuncio){
		
	    this.anuncioDao.addAnuncio(anuncio);	
		
		
	}
	
	public Anuncio  buscarAnuncioServiceById(int id){
		return anuncioDao.findAnuncio(id);
	
	}
	
	public void addVisualizacaoAnuncio(Anuncio anuncio){
		
		
		anuncioDao.addLikeAnuncio(anuncio);
		
	}
	
	
	public List<Anuncio>listarAnuncioVisualizacaoService(){
		
		return this.anuncioDao.listAnunciosVisualizacao();
	
	}
	
	
	public List<Anuncio>listarAnuncioRecentesService(){
		return this.anuncioDao.listAnunciosRecentes();
		
		
		
	}
	
	public void atualizarNumeroAnuncios(Anuncio anuncio){
		
		
		anuncioDao.alterarNumeroAnuncios(anuncio);
		
	}
	
	public List<Anuncio>listAllAnunciosService(){
		return anuncioDao.anuncios();
		
		
		
	}
	
	

	public AnuncioDao getAnuncioDao() {
		return anuncioDao;
	}

	public void setAnuncioDao(AnuncioDao anuncioDao) {
		this.anuncioDao = anuncioDao;
	}





	public Anuncio getAnuncio() {
		return anuncio;
	}





	public void setAnuncio(Anuncio anuncio) {
		this.anuncio = anuncio;
	}

	
	
	
	
	

}
