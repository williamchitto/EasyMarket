package br.com.easy.admin;

import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.Size;

import br.com.easy.dominio.StatusPlanoAnuncio;
import br.com.easy.mb.BasicBean;
import br.com.easy.model.Empresa;
import br.com.easy.model.PlanoEmpresa;
import br.com.easy.model.Planos;

@Named
@ConversationScoped
public class PlanoEmpresaBean extends BasicBean implements Serializable {

	private static final long serialVersionUID = 1L;
	@Inject
	private Conversation conversation;
	@Inject
	EmpresaAdminService service;
	@Inject
	private Empresa empresa;
	// @CNPJ
	// @NotNull(message="CNPJ não pode ser nulo")
	@Size(min = 14, message = "CNPJ inválido")
	private String cnpj;
	@Inject
	private PlanoEmpresa planoEmpresa;
	@Inject
	private PlanoEmpresa planoEmpresaSelecionado;
	@SuppressWarnings("unused")
	private List<Planos> planos = new ArrayList<Planos>();
	@Inject
	private Planos plano;
	private Date dataInicio;
	private Date dataFim;
	private boolean planoAtivo = true;

	@PostConstruct
	public void init() {
		System.out.println("init");
		beginConversation();

	}
	
	
	public String retornarBuscaEmpresa(){
		
		 endConversation();
		
		return "buscaEmpresa?faces-redirect=true";
		
		
		
	}

	public String buscarEmpresa() {

		System.out.println("buscar empresa");
		this.empresa = service.buscarEmpresaByCnpj(cnpj);
		this.planoEmpresa = service.buscarPlanoEmpresaServiceByempresa(this.empresa);
		this.planoAtivo = this.planoEmpresa!=null?false:true;
		System.out.println("sucesso ao executar");
		return "exibir";

	}

	public String incluirPlano() throws ParseException {

		this.dataInicio = new Date();
		this.dataFim = new Date(service.calcularDatafim(dataInicio).getTime());
		return "confirmar";

	}

	public void salvar() {
		System.out.println("salvar executando");
		System.out.println(this.plano.getCodigo());
        this.planoEmpresaSelecionado.setDatafim(new Date(this.dataFim.getTime()));
        System.out.println("passou pela data");
        this.planoEmpresaSelecionado.setDataInicio(new Date(this.dataInicio.getTime()));
		this.planoEmpresaSelecionado.setEmpresa(empresa);
		this.planoEmpresaSelecionado.setStatus(StatusPlanoAnuncio.ATIVADO.getValor());
		 this.planoEmpresaSelecionado.setPlano(this.service.findServiceByid(this.plano.getCodigo()));
		this.service.salvarPlanoEmpresaService(planoEmpresaSelecionado);
		this.planoAtivo = false;
		info("Plano contratado com sucesso.");
		endConversation();
	

	}

	public void beginConversation() {
		if (this.conversation.isTransient()) {

			this.conversation.begin();
			this.conversation.setTimeout(900000L);// 15 minutos
		}

	}

	public void endConversation() {
		if (!this.conversation.isTransient()) {

			this.conversation.end();

		}

	}

	public Conversation getConversation() {
		return conversation;
	}

	public void setConversation(Conversation conversation) {
		this.conversation = conversation;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public PlanoEmpresa getPlanoEmpresa() {
		return planoEmpresa;
	}

	public void setPlanoEmpresa(PlanoEmpresa planoEmpresa) {
		this.planoEmpresa = planoEmpresa;
	}

	public List<Planos> getPlanos() {
		return this.service.listPlanosService();
	}

	public void setPlanos(List<Planos> planos) {
		this.planos = planos;
	}

	public Planos getPlano() {
		return plano;
	}

	public void setPlano(Planos plano) {
		this.plano = plano;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	public boolean isPlanoAtivo() {
		return planoAtivo;
	}

	public void setPlanoAtivo(boolean planoAtivo) {
		this.planoAtivo = planoAtivo;
	}

	public PlanoEmpresa getPlanoEmpresaSelecionado() {
		return planoEmpresaSelecionado;
	}

	public void setPlanoEmpresaSelecionado(PlanoEmpresa planoEmpresaSelecionado) {
		this.planoEmpresaSelecionado = planoEmpresaSelecionado;
	}

}
