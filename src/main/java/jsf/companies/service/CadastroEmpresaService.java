package jsf.companies.service;

import java.io.Serializable;

import javax.inject.Inject;

import jsf.companies.model.Empresa;
import jsf.companies.repository.Empresas;
import jsf.companies.util.Transacional;

public class CadastroEmpresaService implements Serializable {

    private static final long serialVersionUID = -6967844832577148851L;

    @Inject
    private Empresas empresas;

    @Transacional
    public void salvar(Empresa empresa) {
	empresas.guardar(empresa);
    }

    @Transacional
    public void remover(Empresa empresa) {
	empresas.remover(empresa);
    }

}
