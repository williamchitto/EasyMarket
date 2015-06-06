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
import javax.servlet.http.HttpServletResponse;

import br.com.easy.mb.UsuarioLogadoBean;


@WebFilter(urlPatterns = "/sistema/*")
public class FilterLogin implements Filter {
	
   @Inject	
   UsuarioLogadoBean usuarioLogado;
	
	

  
    public FilterLogin() {
       
    }

	
	public void destroy() {
		
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
	
		System.out.println("....Filtro Login executando....");
		if(!this.usuarioLogado.isLogado()){
			
			// ((HttpServletResponse)response).sendRedirect("/EasyMarket/login.xhtml");
			
		}
		
		
		
		chain.doFilter(request, response);
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
