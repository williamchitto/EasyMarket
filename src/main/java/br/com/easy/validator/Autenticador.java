package br.com.easy.validator;

import java.io.IOException;
import java.util.Date;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.easy.dao.UsuarioAutenticacaoDao;
import br.com.easy.dao.UsuarioDao;
import br.com.easy.dominio.StatusValidacaoAutenticacao;
import br.com.easy.dominio.TipoAutenticacao;
import br.com.easy.exception.NegocioException;
import br.com.easy.mb.AutenticacaoBean;
import br.com.easy.model.Usuario;
import br.com.easy.model.UsuarioAutenticacao;


@WebServlet("/Autenticador")
public class Autenticador extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
   @Inject	
   Usuario usuario;	
   @Inject
   UsuarioAutenticacao usuarioAutenticacao;
   @Inject
   UsuarioDao usuarioDao;
   @Inject
   AutenticacaoBean autenticador;
   @Inject
	UsuarioAutenticacaoDao userAutenticacaoDao;
  
 
    
    public Autenticador() {
        super();
        
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Autenticador executando");
		
		try {
			String codigo=request.getParameter("codigo");
			String tipoAutenticacao = request.getParameter("autenticacao");
			String hash = request.getParameter("chave");
			int id = Integer.valueOf(codigo);
			this.usuario  = usuarioDao.findUserByid(id);
			this.usuarioAutenticacao.setDataEnvio(new Date());
			this.usuarioAutenticacao.setHash(hash);
			this.usuarioAutenticacao.setTipoAutenticacao(Integer.valueOf(tipoAutenticacao));
			this.usuarioAutenticacao.setUsuario(usuario);
			
			if(this.usuarioAutenticacao.getTipoAutenticacao()==TipoAutenticacao.RECUPERACAO.getValor()){
				
				if(this.autenticador.autenticarRecuperacaoSenha(usuarioAutenticacao)){
					
					
					response.sendRedirect("/EasyMarket/autenticar.xhtml");
					
				}
				else{
					
					this.usuarioAutenticacao.setStatusAutenticacao(StatusValidacaoAutenticacao.EXPIRADO.getValor());
					this.userAutenticacaoDao.updateUserAutenticacao(usuarioAutenticacao);
					response.sendRedirect("/EasyMarket/linkExpirado.xhtml");
					
					
				}
				
				
				
			}
			else if(this.usuarioAutenticacao.getTipoAutenticacao()==TipoAutenticacao.LOGIN.getValor()){
				
				
				if(this.autenticador.autenticarLogin(usuarioAutenticacao)){
					
					
					response.sendRedirect("/EasyMarket/loginAutenticado.xhtml");
					
				}
				else{
					
					this.usuarioAutenticacao.setStatusAutenticacao(StatusValidacaoAutenticacao.EXPIRADO.getValor());
					this.userAutenticacaoDao.updateUserAutenticacao(usuarioAutenticacao);
					response.sendRedirect("/EasyMarket/linkExpirado.xhtml");
					
				}
				
			}
			
			
		} catch (NegocioException e) {
			
			
			response.sendRedirect("/EasyMarket/acessoNegado.xhtml");
			
			
		}
		
		
		
	}

}
