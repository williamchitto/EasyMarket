package br.com.easy.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import br.com.easy.dao.UsuarioDao;
import br.com.easy.model.Usuario;

@FacesConverter("usuarioConverter")
public class UsuarioConverter implements Converter {

	@Inject
	UsuarioDao dao;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {

		Usuario user = new Usuario();
		if (value != null) {

			int id = Integer.valueOf(value);
			user = dao.findUserByid(id);

			return user;

		}

		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		if (value != null) {

			Usuario user = (Usuario) value;
			String codigo = String.valueOf(user.getCodigo());
			return codigo;

		}

		return "";

	}

}
