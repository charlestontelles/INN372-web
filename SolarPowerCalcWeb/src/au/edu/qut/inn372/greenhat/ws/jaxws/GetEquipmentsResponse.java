
package au.edu.qut.inn372.greenhat.ws.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "getEquipmentsResponse", namespace = "http://ws.greenhat.inn372.qut.edu.au/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getEquipmentsResponse", namespace = "http://ws.greenhat.inn372.qut.edu.au/")
public class GetEquipmentsResponse {

    @XmlElement(name = "equipments", namespace = "", nillable = true)
    private au.edu.qut.inn372.greenhat.bean.Equipment[] equipments;

    /**
     * 
     * @return
     *     returns Equipment[]
     */
    public au.edu.qut.inn372.greenhat.bean.Equipment[] getEquipments() {
        return this.equipments;
    }

    /**
     * 
     * @param equipments
     *     the value for the equipments property
     */
    public void setEquipments(au.edu.qut.inn372.greenhat.bean.Equipment[] equipments) {
        this.equipments = equipments;
    }

}
