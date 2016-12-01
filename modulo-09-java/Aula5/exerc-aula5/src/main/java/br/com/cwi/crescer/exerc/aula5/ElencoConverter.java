package br.com.cwi.crescer.exerc.aula5;

import br.com.cwi.crescer.exerc.aula5.entity.Elenco;
import br.com.cwi.crescer.exerc.aula5.entity.ElencoBean;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

@ManagedBean
@RequestScoped
public class ElencoConverter implements Converter {
    
    @EJB
    private ElencoBean elencoBean;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String submittedValue) {
        if (submittedValue == null || submittedValue.isEmpty()) {
            return null;
        }

        try {
            return elencoBean.find(Long.valueOf(submittedValue));
        } catch (NumberFormatException e) {
            throw new ConverterException(new FacesMessage(String.format("%s is not a valid Elenco ID", submittedValue)), e);
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object modelValue) {
        if (modelValue == null) {
            return "";
        }

        if (modelValue instanceof Elenco) {
            return String.valueOf(((Elenco) modelValue).getId());
        } else {
            throw new ConverterException(new FacesMessage(String.format("%s is not a valid Elenco", modelValue)));
        }
    }
}
