package br.com.easy.mb;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.FileUploadEvent;

import br.com.easy.dominio.StatusValidacaoAutenticacao;
import br.com.easy.dominio.TipoAutenticacao;
import br.com.easy.dominio.TipoUser;
import br.com.easy.exception.NegocioException;
import br.com.easy.model.Empresa;
import br.com.easy.model.Endereco;
import br.com.easy.model.EnderecoWare;
import br.com.easy.model.ImagemEmpresa;
import br.com.easy.model.Usuario;
import br.com.easy.model.UsuarioAutenticacao;
import br.com.easy.service.EmpresaService;
import br.com.easy.service.UsuarioAutenticacaoService;
import br.com.easy.webservicecep.DevWareCEPService;

@Named
@ViewScoped
public class CadastroEmpresaBean extends BasicBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Empresa empresa;
	@Inject
	private Endereco endereco;
	private String senha;
	private String confirmSenha;
	@Inject
	private ImagemEmpresa imagem;
	@Inject
	private EmpresaService service;
	@Inject
	private Usuario user;
	@Inject
	EnderecoWare enderecoWare;
	@Inject
	DevWareCEPService enderecoWebService;
	@Inject
	UsuarioAutenticacao userAutenticacao;
	@Inject
	UsuarioAutenticacaoService userAutenticacaoService;
	@Inject
	EnviarSenhaEmailBean email;
	boolean isImagemValida = false;

	/*
	 * Metodo que valida e salva uma empresa na base de dados
	 */
	public void Salvar() {
           validarImagem();
		if (comparePassWord()) {
			preencherendereco();
			preencherUser();
			preencherEmpresa();
			service.salvarEmpresaService(empresa);
			userAutenticacaoService.salvarUserAutenticacaoService(this.userAutenticacao);
			this.email.enviarEmailValidacao(userAutenticacao);
			limparCampos();
			info("Acesse o email informado para confirmar sua conta");

		} else {

			error("As senhas informadas são diferentes.");

		}

	}
	
	public void handleFileUpload(FileUploadEvent event) {
		preencherImagem(event,this.imagem);
		isImagemValida = true;
		FacesMessage message = new FacesMessage("Imagem enviada com sucesso", event.getFile().getFileName() + " is uploaded.");
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	public void preencherEmpresa() {

		this.empresa.setEndereco(this.endereco);
		this.empresa.setImagemEmpresa(imagem);
		this.empresa.setUsuario(this.user);
	

	}

	public void isCnpjUnico() {

		System.out.println("verificando cnpj");

		if (this.empresa.getCnpj() != null) {

			if (!service.validarCnpjUnico(this.empresa.getCnpj())) {

				error("CNPJ já existe");
			}
		}

	}

	public void isEmailUnico() {

		System.out.println("verificando email");
		if (this.user.getEmail() != null) {

			if (!service.validarEmailUnico(this.user.getEmail())) {

				error("Email já existe");

			}

		}

	}

	public void preencherendereco() {

		this.endereco.setEmpresa(empresa);

	}

	public void preencherUser() {
        this.user.setTipoUser(TipoUser.COMUM);
		this.user.setSenha(service.convertMD5(senha.toUpperCase()));
		this.user.setEmpresa(this.empresa);
		this.user
				.setUsuarioAutenticado(StatusValidacaoAutenticacao.NAO_VALIDADO
						.getValor());
		this.userAutenticacao
				.setStatusAutenticacao(StatusValidacaoAutenticacao.NAO_VALIDADO
						.getValor());
		this.userAutenticacao.setTipoAutenticacao(TipoAutenticacao.LOGIN
				.getValor());
		this.userAutenticacao.setUsuario(user);
		this.user.getUserAutenticacoes().add(userAutenticacao);
		this.email.getUsuarioService().preecherDadosHash(userAutenticacao);

	}

	public void preencherEnderecoWebService() {

		System.out.println("preeencher endereco web service executando");
		this.enderecoWare = this.enderecoWebService.consultarCEP(this.endereco
				.getCep());
		if (!this.enderecoWare.getResultado_txt().equalsIgnoreCase("sucesso")) {
			this.endereco = new Endereco();
			error("CEP informado não foi encontrado");
			return;

		}
		this.endereco = new Endereco();
		this.endereco.setCep(this.enderecoWare.getCep());
		this.endereco.setBairro(this.enderecoWare.getBairro());
		this.endereco.setCidade(enderecoWare.getCidade());
		this.endereco.setLogradouro(this.enderecoWare.getLogradouro());
		this.endereco.setUf(this.enderecoWare.getUf());
		System.out.println("Endereco retornado");

	}

	public boolean comparePassWord() {

		if (this.senha.equals(this.confirmSenha)) {

			return true;

		}

		return false;

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

	public void limparCampos() {
		this.empresa = new Empresa();
		this.endereco = new Endereco();
		this.imagem = new ImagemEmpresa();
		this.user = new Usuario();
		this.isImagemValida = false;

	}
	
	
	public void validarImagem(){
	
		 if(!isImagemValida){
			 
			 throw new NegocioException("Logomarca da empresa deve ser informada.");
			 
		 }
		
		
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getConfirmSenha() {
		return confirmSenha;
	}

	public void setConfirmSenha(String confirmSenha) {
		this.confirmSenha = confirmSenha;
	}

	public ImagemEmpresa getImagem() {
		return imagem;
	}

	public void setImagem(ImagemEmpresa imagem) {
		this.imagem = imagem;
	}

	public EmpresaService getService() {
		return service;
	}

	public void setService(EmpresaService service) {
		this.service = service;
	}

	public Usuario getUser() {
		return user;
	}

	public void setUser(Usuario user) {
		this.user = user;
	}

	

}
