package br.com.easy.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class CharacterEncodingFilter
 */
@WebFilter(urlPatterns = "/*")
public class CharacterEncodingFilter implements Filter {

	 public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
		      throws ServletException, IOException {
		  
		        request.setCharacterEncoding("UTF-8");
		        
		        response.setCharacterEncoding("UTF-8");
		        
		      
		        
		        
		        chain.doFilter(request, response);
		        
		        
		        
		    }

		    @Override
		    public void init(FilterConfig filterConfig) throws ServletException {
		    }

		    @Override
		    public void destroy() {
		    }

}
