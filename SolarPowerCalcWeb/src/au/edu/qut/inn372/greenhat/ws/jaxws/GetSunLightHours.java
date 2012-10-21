
package au.edu.qut.inn372.greenhat.ws.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "getSunLightHours", namespace = "http://ws.greenhat.inn372.qut.edu.au/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getSunLightHours", namespace = "http://ws.greenhat.inn372.qut.edu.au/", propOrder = {
    "latitude",
    "longitude"
})
public class GetSunLightHours {

    @XmlElement(name = "latitude", namespace = "")
    private double latitude;
    @XmlElement(name = "longitude", namespace = "")
    private double longitude;

    /**
     * 
     * @return
     *     returns double
     */
    public double getLatitude() {
        return this.latitude;
    }

    /**
     * 
     * @param latitude
     *     the value for the latitude property
     */
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    /**
     * 
     * @return
     *     returns double
     */
    public double getLongitude() {
        return this.longitude;
    }

    /**
     * 
     * @param longitude
     *     the value for the longitude property
     */
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

}
