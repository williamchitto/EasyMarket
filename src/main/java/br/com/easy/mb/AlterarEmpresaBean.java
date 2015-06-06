package br.com.easy.mb;

import java.io.IOException;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.FileUploadEvent;

import br.com.easy.model.Empresa;
import br.com.easy.model.Endereco;
import br.com.easy.model.EnderecoWare;
import br.com.easy.model.ImagemEmpresa;
import br.com.easy.service.EmpresaService;
import br.com.easy.webservicecep.DevWareCEPService;

@Named
@ViewScoped
public class AlterarEmpresaBean extends BasicBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Empresa empresa;
	@Inject
	EnderecoWare enderecoWare;
	@Inject
	DevWareCEPService enderecoWebService;
	@Inject
	UsuarioLogadoBean usuarioLogado;
	@Inject
	EmpresaService empresaService;
	

	@PostConstruct
	public void init() {

		this.empresa = this.empresaService.buscarEmpresaById(this.usuarioLogado
				.getUsuario().getEmpresa().getCodigo());

	}
	
	
	public void alterar(){
		
		System.out.println("Metodo alterar empresa executando");
	    	empresaService.atualizarEmpresaService(this.empresa);	
			info("Empresa alterada com sucesso");
	

	}
	
	public void handleFileUpload(FileUploadEvent event) {
		preencherImagem(event,this.empresa.getImagemEmpresa());
		FacesMessage message = new FacesMessage("Imagem enviada com sucesso", event.getFile().getFileName() + " is uploaded.");
		FacesContext.getCurrentInstance().addMessage(null, message);
	}
	
	
	public void preencherImagem(FileUploadEvent event, ImagemEmpresa imagem) {
		System.out.println("preecher imagem executando");
		try {
			byte[] arqBytes = new byte[(int) event.getFile().getSize()];
			event.getFile().getInputstream().read(arqBytes);
			imagem.setType(event.getFile().getContentType());
			imagem.setFoto(arqBytes);

		} catch (IOException e) {

			error("Erro ao enviar imagem da empresa");
			e.printStackTrace();
		}

	}
	
	


	public void enderecoWebService(){
		
	this.enderecoWare = this.enderecoWebService.consultarCEP(this.empresa.getEndereco().getCep());
	if(!this.enderecoWare.getResultado_txt().equalsIgnoreCase("sucesso")){
		this.empresa.setEndereco(new Endereco());
		error("CEP informado inválido");
		return;
		
	}
	
	this.empresa.getEndereco().setBairro(this.enderecoWare.getBairro());
	this.empresa.getEndereco().setCidade(this.enderecoWare.getCidade());
	this.empresa.getEndereco().setLogradouro(this.enderecoWare.getLogradouro());
	this.empresa.getEndereco().setUf(this.enderecoWare.getUf());
	System.out.println("Endereco retornado");
	  	
	
	}
	
	

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}





}
