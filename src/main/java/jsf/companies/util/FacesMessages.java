package jsf.companies.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class FacesMessages {

    private void add(String msg, FacesMessage.Severity severity) {
	FacesMessage facesMessage = new FacesMessage();
	facesMessage.setSeverity(severity);

	FacesContext.getCurrentInstance().addMessage(null,
		facesMessage);
    }

    public void info(String msg) {
	add(msg, FacesMessage.SEVERITY_INFO);
    }
}
