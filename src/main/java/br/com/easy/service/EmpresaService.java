package br.com.easy.service;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.inject.Inject;

import br.com.easy.dao.EmpresaDao;
import br.com.easy.exception.NegocioException;
import br.com.easy.model.Empresa;
import br.com.easy.model.ImagemEmpresa;

public class EmpresaService extends BasicService implements Serializable {


	private static final long serialVersionUID = 1L;
	
	
	@Inject
	private EmpresaDao dao;
	
	
	
	public void atualizarEmpresaService(Empresa empresa){
		
		dao.updateEmpresa(empresa);
		
		
	}
	

	
	
     public Empresa buscarEmpresaById(int id){
    	 
    	 
		return dao.findEmpresa(id);
    	 
    	 
    	 
     }
     
     
  
	
	public void salvarEmpresaService(Empresa empresa){
		
	  if(validarCnpjUnico(empresa.getCnpj()) && validarEmailUnico(empresa.getUsuario().getEmail()) ){
		      
		       dao.addEmpresa(empresa);
		       
		     
		       
		  
	  }else{
		  
		  throw new NegocioException("Cnpj/Email Já existem no nosso cadastro.");
	
	  }
		
		
	}
	
	
	public void isImagemValidaService(ImagemEmpresa imagem,long tamanho){
		
		if(!isImagemValida(imagem.getType())){
			
			  throw new NegocioException("Arquivo de imagem inválido");
			
		}else if(!isTamanhomaximoPermitido(tamanho)){
			
			
			 throw new NegocioException("Tamanho de arquivo não permitido");
			
		}
		
		
	}
	
	

	
	  public boolean validarCnpjUnico(String cnpj){
		
		Empresa empresa = dao.buscarEmpresaPorCnpj(cnpj);
		if(empresa!=null){
			
			return false;
			
		}
		
		return true;
	
	}
	
	public boolean validarEmailUnico(String email){
	
		Empresa empresa = dao.buscarEmpresaPorEmail(email);
		if(empresa!=null){
			
			return false;
			
		}
		
		return true;
		
	}
	
	public String convertMD5(String senha) {

		MessageDigest mdigest;
		try {
			mdigest = MessageDigest.getInstance("MD5");
			byte[] valorMd5 = mdigest.digest(senha.getBytes("UTF-8"));
			StringBuffer sb = new StringBuffer();
			for (byte b : valorMd5) {

				sb.append(Integer.toHexString((b & 0xFF) | 0x100).substring(1,
						3));

			}
			System.out.println("A senha criptografada é:" + sb.toString());
			return sb.toString();
		} catch (NoSuchAlgorithmException e) {
			System.out.println("Erro de criptografia");
			e.printStackTrace();
			return null;
		} catch (UnsupportedEncodingException e) {
			System.out.println("Erro de criptografia");
			e.printStackTrace();
			return null;
		}

	}
	
	
	
	public EmpresaDao getDao() {
		return dao;
	}


	public void setDao(EmpresaDao dao) {
		this.dao = dao;
	}



	


	

}
