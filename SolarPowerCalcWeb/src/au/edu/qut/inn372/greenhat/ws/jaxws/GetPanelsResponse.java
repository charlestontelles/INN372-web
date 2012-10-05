
package au.edu.qut.inn372.greenhat.ws.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "getPanelsResponse", namespace = "http://ws.greenhat.inn372.qut.edu.au/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getPanelsResponse", namespace = "http://ws.greenhat.inn372.qut.edu.au/")
public class GetPanelsResponse {

    @XmlElement(name = "panels", namespace = "", nillable = true)
    private au.edu.qut.inn372.greenhat.bean.Panel[] panels;

    /**
     * 
     * @return
     *     returns Panel[]
     */
    public au.edu.qut.inn372.greenhat.bean.Panel[] getPanels() {
        return this.panels;
    }

    /**
     * 
     * @param panels
     *     the value for the panels property
     */
    public void setPanels(au.edu.qut.inn372.greenhat.bean.Panel[] panels) {
        this.panels = panels;
    }

}
