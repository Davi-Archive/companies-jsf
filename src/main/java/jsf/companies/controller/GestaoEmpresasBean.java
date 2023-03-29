package jsf.companies.controller;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import jsf.companies.model.Empresa;
import jsf.companies.repository.Empresas;

@Named
@RequestScoped
public class GestaoEmpresasBean implements Serializable {
    private static final long serialVersionUID = 8029120961239526178L;

    @Inject
    private Empresas empresas;

    private List<Empresa> listaEmpresas;

    private String termoPesquisa;

    public void pesquisarComTermo() {
	System.out.println("chamando pesquisar: " + termoPesquisa);
	listaEmpresas = empresas.pesquisarRazaoSocial(termoPesquisa);
    }

    public void todasEmpresas() {
	listaEmpresas = empresas.todas();
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
}
