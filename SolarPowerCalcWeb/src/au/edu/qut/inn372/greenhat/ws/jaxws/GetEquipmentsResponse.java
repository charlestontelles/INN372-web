
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
     * Get the list of equipment
     * @return Equipment[]
     */
    public au.edu.qut.inn372.greenhat.bean.Equipment[] getEquipments() {
        return this.equipments;
    }

    /**
     * Set the list of equipment
     * @param equipments value for the equipments property
     */
    public void setEquipments(au.edu.qut.inn372.greenhat.bean.Equipment[] equipments) {
        this.equipments = equipments;
    }

}
