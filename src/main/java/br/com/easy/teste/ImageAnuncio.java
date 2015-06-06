package br.com.easy.teste;

import java.io.IOException;
import java.io.OutputStream;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.easy.model.ImagemEmpresa;
import br.com.easy.model.ImagemProduto;
import br.com.easy.service.ImagemEmpresaService;
import br.com.easy.service.ImagemProdutoService;

/**
 * Servlet implementation class ImageAnuncio
 */
@WebServlet("/ImageAnuncio/*")
public class ImageAnuncio extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   @Inject
   ImagemProdutoService service;
	
	
    public ImageAnuncio() {
        super();
       
    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	System.out.println("servlet imagem anuncio executando");
	
	
	String s = request.getPathInfo().substring(1);
	 
    //Recuperando um objeto imagem do banco de dados através do ID passado na URL digitada
    ImagemProduto image = service.buscarImagemProdutoById(Integer.parseInt(s));

    response.setContentType(image.getType()); //Passando o tipo da foto ex: jpg, png, etc.
    OutputStream out = response.getOutputStream();
    out.write(image.getFoto()); // Passando o array de bytes
    out.close();
		
		
	
	}

}
