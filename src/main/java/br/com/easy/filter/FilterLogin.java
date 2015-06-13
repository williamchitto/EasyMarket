package br.com.easy.filter;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.easy.dominio.TipoUser;
import br.com.easy.mb.UsuarioLogadoBean;


@WebFilter(urlPatterns = "/*")
public class FilterLogin implements Filter {
	
   @Inject	
   UsuarioLogadoBean usuarioLogado;
	
	

  
    public FilterLogin() {
       
    }

	
	public void destroy() {
		
	}

	//((HttpServletResponse)response).sendRedirect("/EasyMarket/login.xhtml");
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
	    
		 String requestPath = ((HttpServletRequest)request).getRequestURI().toLowerCase();
		 System.out.println(requestPath);
		
		if(!this.usuarioLogado.isLogado()){
	
			if(requestPath.contains("sistema") || requestPath.contains("admin")){
				
				((HttpServletResponse)response).sendRedirect("/EasyMarket/login.xhtml");
				
				
			}
			
			
		
		
		}
		
		if(this.usuarioLogado.isLogado()){
			
			if(this.usuarioLogado.getUsuario().getTipoUser().equals(TipoUser.COMUM)){
				

				if(requestPath.contains("admin")){
					
					((HttpServletResponse)response).sendRedirect("/EasyMarket/acessoNegado.xhtml");
					
					
				}
				
				
				
			}
			
			
			
		}
		
		
		
		chain.doFilter(request, response);
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
