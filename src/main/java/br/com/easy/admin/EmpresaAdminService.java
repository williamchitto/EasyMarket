package br.com.easy.admin;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.joda.time.DateTime;

import br.com.easy.dao.EmpresaDao;
import br.com.easy.dao.PlanoEmpresaDao;
import br.com.easy.exception.NegocioException;
import br.com.easy.model.Empresa;
import br.com.easy.model.PlanoEmpresa;
import br.com.easy.model.Planos;
import br.com.easy.service.BasicService;

public class EmpresaAdminService extends BasicService implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject
	EmpresaDao empresaDao;
	@Inject
	PlanoEmpresaDao planoEmpresaDao;
	
   
	 public Empresa buscarEmpresaByCnpj(String cnpj){
		 
		 Empresa empresa = empresaDao.buscarEmpresaPorCnpj(cnpj);
		 if(empresa==null){
			 
			 throw new NegocioException("Empresa informada não existe no nosso cadastro.");
			 
		 }
		 
		return empresa;
		 
	 }
	 
	   public PlanoEmpresa buscarPlanoEmpresaServiceByempresa(Empresa empresa){
		return this.planoEmpresaDao.buscarPlanoByEmpresaValido(empresa);
		    
	   }
	   
	   
	   public List<Planos>listPlanosService(){
		return this.planoEmpresaDao.listplanos();
		   
		   
	   }
	   
	   public void salvarPlanoEmpresaService(PlanoEmpresa planoEmpresa){
		   
		   planoEmpresaDao.salvar(planoEmpresa);
		   
	   }
	   
	   
	   public Planos findServiceByid(int id){
		return planoEmpresaDao.findPlanoByid(id);
		   
		   
		   
	   }
	   
	   
	   public  Date  calcularDatafim(Date dataInicio){
			DateTime data = new DateTime();
			DateTime dataMaisDias = data.plusDays(365);
			Calendar calendar = Calendar.getInstance();
			calendar.setTimeInMillis(dataMaisDias.getMillis());
			return calendar.getTime();
			
		   
	   }
	   
	  
	
}
