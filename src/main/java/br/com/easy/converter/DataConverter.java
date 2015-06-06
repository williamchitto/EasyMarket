package br.com.easy.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("dataConverter")
public class DataConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		
		 Date data = null;
		if(value !=null){
		    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		   
			try {
				data = format.parse(value);
			} catch (ParseException e) {
				System.out.println("Erro ao converter data");
				e.printStackTrace();
			}
			
			
			
		}
		
		

		return data;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		Date data = (java.util.Date)value;
		String dataString = format.format(data);
	
		return dataString;
	}

}
