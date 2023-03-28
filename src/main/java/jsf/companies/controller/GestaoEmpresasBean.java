package jsf.companies.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import jsf.companies.model.Empresa;
import jsf.companies.repository.Empresas;

@Named
@ViewScoped
public class GestaoEmpresasBean implements Serializable {
    private static final long serialVersionUID = 8029120961239526178L;

    private List<Empresa> listaEmpresas;
    
    @Inject
    private Empresas empresas;

    public void todasEmpresas() {
	listaEmpresas =  empresas.todas();
    }
    
    
    public List<Empresa> getListaEmpresas() {
	return listaEmpresas;
    }
}
