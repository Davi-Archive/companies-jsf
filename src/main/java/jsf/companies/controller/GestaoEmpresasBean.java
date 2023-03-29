package jsf.companies.controller;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.context.PrimeRequestContext;

import jsf.companies.model.Empresa;
import jsf.companies.model.RamoAtividade;
import jsf.companies.repository.Empresas;
import jsf.companies.repository.RamoAtividades;
import jsf.companies.service.CadastroEmpresaService;
import jsf.companies.types.TipoEmpresa;
import jsf.companies.util.FacesMessages;

@Named
@RequestScoped
public class GestaoEmpresasBean implements Serializable {
    private static final long serialVersionUID = 8029120961239526178L;

    @Inject
    private Empresas empresas;

    @Inject
    private FacesMessages messages;

    @Inject
    private RamoAtividades ramoAtividades;

    @Inject
    private CadastroEmpresaService cadastroEmpresaService;

    private List<Empresa> listaEmpresas;

    private String termoPesquisa;

    private Converter<Object> ramoAtividadeConverter;

    private Empresa empresa;

    public void prepararNovaEmpresa() {
	empresa = new Empresa();
    }

    public void salvar() {
	System.out.println("SALVAR");
	cadastroEmpresaService.salvar(empresa);

	if (jaHouvePesquisa()) {
	    pesquisarComTermo();
	}

	messages.info("Empresa cadastrada com sucesso!");

	// PrimeRequestContext.getCurrentInstance()
	// .update(Arrays.asList("frm:empresasDataTable"));
    }

    public void pesquisarComTermo() {
	listaEmpresas = empresas.pesquisarRazaoSocial(termoPesquisa);
	System.out.println("chamando pesquisar: " + termoPesquisa);

	if (listaEmpresas.isEmpty()) {
	    messages.info("Sua consulta não retornou registros.");
	}
    }

    public void todasEmpresas() {
	listaEmpresas = empresas.todas();
    }

    public List<RamoAtividade> completarRamoAtividade(String termo) {
	List<RamoAtividade> listaRamoAtividades = ramoAtividades
		.pesquisar(termo);

	ramoAtividadeConverter = new RamoAtividadeConverter(
		listaRamoAtividades);

	return listaRamoAtividades;
    }

    private boolean jaHouvePesquisa() {
	return termoPesquisa != null && !"".equals(termoPesquisa);
    }

    public TipoEmpresa[] getTipoEmpresas() {
	return TipoEmpresa.values();
    }

    public List<Empresa> getListaEmpresas() {
	return listaEmpresas;
    }

    public String getTermoPesquisa() {
	return termoPesquisa;
    }

    public void setTermoPesquisa(String termoPesquisa) {
	this.termoPesquisa = termoPesquisa;
    }

    public Converter<Object> getRamoAtividadeConverter() {
	return ramoAtividadeConverter;
    }

    public Empresa getEmpresa() {
	return empresa;
    }

    public void setEmpresa(Empresa empresa) {
	this.empresa = empresa;
    }

    public boolean isEmpresaSelecionada() {
	return empresa != null && empresa.getId() != null;
    }
}
