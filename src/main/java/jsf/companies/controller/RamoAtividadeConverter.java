package jsf.companies.controller;

import java.util.List;
import java.util.Objects;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import jsf.companies.model.RamoAtividade;

//@FacesConverter(forClass = RamoAtividade.class)

public class RamoAtividadeConverter implements Converter<Object> {

    private List<RamoAtividade> listRamoAtividades;

    public RamoAtividadeConverter(
	    List<RamoAtividade> listRamoAtividades) {
	this.listRamoAtividades = Objects
		.requireNonNull(listRamoAtividades);
    }

    @Override
    public Object getAsObject(FacesContext context,
	    UIComponent component, String value) {
	if (value == null) {
	    return null;
	}

	Long id = Long.valueOf(value);

	for (RamoAtividade ramoAtividade : listRamoAtividades) {
	    if (id.equals(ramoAtividade.getId())) {
		return ramoAtividade;
	    }
	}
	return null;
    }

    @Override
    public String getAsString(FacesContext context,
	    UIComponent component, Object value) {
	if (value == null) {
	    return null;
	}
	RamoAtividade ramoAtividade = (RamoAtividade) value;

	return ramoAtividade.getId().toString();
    }

}
