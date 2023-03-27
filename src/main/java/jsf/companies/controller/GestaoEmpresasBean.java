package jsf.companies.controller;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import jsf.companies.model.Empresa;
import jsf.companies.types.TipoEmpresa;

@Named
@ViewScoped
public class GestaoEmpresasBean implements Serializable {
    private static final long serialVersionUID = 8029120961239526178L;

    private Empresa empresa = new Empresa();

    public Empresa getEmpresa() {
	return empresa;
    }

    public TipoEmpresa[] getTiposEmpresa() {
	return TipoEmpresa.values();
    }

    public void salvar() {
	System.out.println("Razão Social: " + empresa.getRazaoSocial()
		+ " - Nome fantasia: " + empresa.getNomeFantasia()
		+ " - Tipo: " + empresa.getTipo());
    }

}
