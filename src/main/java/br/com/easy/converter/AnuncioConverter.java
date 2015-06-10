package br.com.easy.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import br.com.easy.model.Anuncio;
import br.com.easy.service.AnuncioService;

@FacesConverter("anuncioConverter")
public class AnuncioConverter  implements Converter{
    
	@Inject
	AnuncioService service;
	
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		 System.out.println("Converter anuncio");
		Anuncio anuncio = null;
		if(value!=null){
		
			int id = Integer.valueOf(value);
			anuncio = service.buscarAnuncioServiceById(id);
	
		}
		
		
		
		return anuncio;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		if (value != null) {

			int codigo = ((Anuncio) value).getCodigo();
			String s = String.valueOf(codigo);

			return s;

		}

		return "";
		
		
		
	}

}
