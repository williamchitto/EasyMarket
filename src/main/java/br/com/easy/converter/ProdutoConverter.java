package br.com.easy.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import br.com.easy.dao.ProdutoDao;
import br.com.easy.model.Produto;

@FacesConverter("produtoConverter")
public class ProdutoConverter implements Converter {
	
	@Inject
	private ProdutoDao dao;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		Produto produto = null;
		if(value!=null){
			
			int id = Integer.valueOf(value);
			produto = dao.findProduto(id);
			return produto;
			
		}
		
	
		return produto;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		if(value !=null){
			
			Produto produto = (Produto) value;
			String codigo = String.valueOf(produto.getCodigo());
			return codigo;
			
		}
		
	
		return "";
	}

	public ProdutoDao getDao() {
		return dao;
	}

	public void setDao(ProdutoDao dao) {
		this.dao = dao;
	}

}
