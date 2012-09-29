
package au.edu.qut.inn372.greenhat.ws.jaxws;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "getCalculationsResponse", namespace = "http://ws.greenhat.inn372.qut.edu.au/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getCalculationsResponse", namespace = "http://ws.greenhat.inn372.qut.edu.au/")
public class GetCalculationsResponse {

    @XmlElement(name = "calculators", namespace = "")
    private List<au.edu.qut.inn372.greenhat.bean.Calculator> calculators;

    /**
     * 
     * @return
     *     returns List<Calculator>
     */
    public List<au.edu.qut.inn372.greenhat.bean.Calculator> getCalculators() {
        return this.calculators;
    }

    /**
     * 
     * @param calculators
     *     the value for the calculators property
     */
    public void setCalculators(List<au.edu.qut.inn372.greenhat.bean.Calculator> calculators) {
        this.calculators = calculators;
    }

}
