package br.com.easy.validator;

import javax.inject.Inject;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import br.com.easy.model.EnderecoWare;
import br.com.easy.webservicecep.DevWareCEPService;

public class ValidaCep implements ConstraintValidator<CEPVALIDO,String> {
     
	 @Inject
     DevWareCEPService servico;
	
	
	@Override
	public void initialize(CEPVALIDO arg0) {
		
		
	}



	@Override
	public boolean isValid(String valor,
			ConstraintValidatorContext context) {
		
		if(valor!=null && !valor.isEmpty()){
		
		EnderecoWare endereco = servico.consultarCEP(valor);
		if( endereco.getResultado_txt().equalsIgnoreCase("sucesso")){
			
			
			return true;
			
		}
			
			
		  return false;
			
		}
		
		
		
		return false;
	}

}
