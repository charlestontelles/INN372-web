
package au.edu.qut.inn372.greenhat.ws.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "getSunLightHoursResponse", namespace = "http://ws.greenhat.inn372.qut.edu.au/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getSunLightHoursResponse", namespace = "http://ws.greenhat.inn372.qut.edu.au/")
public class GetSunLightHoursResponse {

    @XmlElement(name = "sunLightHours", namespace = "")
    private double sunLightHours;

    /**
     * 
     * @return
     *     returns double
     */
    public double getSunLightHours() {
        return this.sunLightHours;
    }

    /**
     * 
     * @param sunLightHours
     *     the value for the sunLightHours property
     */
    public void setSunLightHours(double sunLightHours) {
        this.sunLightHours = sunLightHours;
    }

}
