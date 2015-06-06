package br.com.easy.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import br.com.easy.mb.CategoriaBean;
import br.com.easy.model.Categoria;

@FacesConverter("categoriaConverter")
public class CategoriaConverter implements Converter {
	
	@Inject
	private CategoriaBean bean;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {

		Categoria retorno = null;
		if (value != null) {
			System.out.println(value);
			int id = Integer.valueOf(value);
			retorno = bean.buscarCategoriaByCodigo(id);
			

		}

		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {

		if (value != null) {

			int codigo = ((Categoria) value).getCodigo();
			String s = String.valueOf(codigo);

			return s;

		}

		return "";
	}

	public CategoriaBean getBean() {
		return bean;
	}

	public void setBean(CategoriaBean bean) {
		this.bean = bean;
	}

}
