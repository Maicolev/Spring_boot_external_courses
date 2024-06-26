package beans.backing;

import beans.model.Candidate;
import beans.services.NeighborhoodService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIInput;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import javax.inject.Inject;
import javax.inject.Named;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@Named
@RequestScoped
public class Vacantfrm {

    @Inject
    private Candidate candidate;

    private boolean commentSent;

    @Inject
    private NeighborhoodService neighborhoodService;

    Logger log = LogManager.getRootLogger();

    public void setCandidate(Candidate candidate){
        this.candidate = candidate;
    }

    //public Candidate getCandidate(){
      //  return candidate;
    //}

    public String send(){
        if(this.candidate.getName().equals("Karol")){
            if(this.candidate.getLastName().equals("Trujillo")){
                String msg = "Thanks, but Karol Trujillo is already working with us";
                FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg);
                FacesContext facesContext = FacesContext.getCurrentInstance();
                String componentId = null; // this is a global message
                facesContext.addMessage(componentId, facesMessage);
                return "index";
            }
            log.info("Into success case");
            return "success";
        }
        else {
            log.info("Into error case");
            return "error";
        }
    }

    public String changeLanguage(){
        try {
            // Ruta al archivo faces-config.xml
            String rutaArchivo = "/WEB-INF/faces-config.xml";


            // Crear un lector XML
            SAXReader reader = new SAXReader();
            Document document = reader.read(new File(rutaArchivo));

            // Obtener el elemento <default-locale> y establecer el nuevo valor
            Element defaultLocaleElement = document.getRootElement()
                    .element("locale-config")
                    .element("default-locale");
            defaultLocaleElement.setText("es");

            // Escribir los cambios de vuelta al archivo
            XMLWriter writer = new XMLWriter(new FileWriter(rutaArchivo));
            writer.write(document);
            writer.close();
        } catch (DocumentException | IOException e) {
            e.printStackTrace();
            // Manejo de errores
        }
        return "index";
    }

    public void postalCodeListener (ValueChangeEvent valueChangeEvent){
        FacesContext facesContext = FacesContext.getCurrentInstance();
        UIViewRoot uiviewRoot = facesContext.getViewRoot();
        int newPostalCode = (int) valueChangeEvent.getNewValue();

        //if (66 == (newPostalCode)){
        UIInput neighborhoodInputText = (UIInput) uiviewRoot.findComponent("vacantForm:neighborhoodId");
        int newNeighborhoodId = this.neighborhoodService.getNeighborhoodIdByPC(newPostalCode);
        neighborhoodInputText.setValue(newNeighborhoodId);
        neighborhoodInputText.setSubmittedValue(newNeighborhoodId);

        UIInput cityInputText = (UIInput) uiviewRoot.findComponent("vacantForm:city");
        String newCity = "San Francisco";
        cityInputText.setValue(newCity);
        cityInputText.setSubmittedValue(newCity);

        facesContext.renderResponse();
        //}
    }

    public boolean isCommentSent() {
        return commentSent;
    }

    public void setCommentSent(boolean commentSent) {
        this.commentSent = commentSent;
    }

    public void modifyStatusCommentary(ActionEvent actionEvent){
        this.commentSent = !this.commentSent;
    }

    public Candidate getCandidate() {
        return candidate;
    }

    public NeighborhoodService getNeighborhoodService() {
        return neighborhoodService;
    }

    public void setNeighborhoodService(NeighborhoodService neighborhoodService) {
        this.neighborhoodService = neighborhoodService;
    }
}
