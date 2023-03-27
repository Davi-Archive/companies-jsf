package jsf.companies.controller;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class GestaoEmpresasBean implements Serializable {
    private static final long serialVersionUID = 8029120961239526178L;

    private static Integer NUMERO = 0;

    public GestaoEmpresasBean() {
	NUMERO++;
    }

    public Integer getNumero() {
	return NUMERO;
    }

    public void setNumero(Integer numero) {
	GestaoEmpresasBean.NUMERO = numero;
    }

}
