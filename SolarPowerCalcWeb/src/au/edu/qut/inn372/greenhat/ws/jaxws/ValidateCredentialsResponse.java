
package au.edu.qut.inn372.greenhat.ws.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "validateCredentialsResponse", namespace = "http://ws.greenhat.inn372.qut.edu.au/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "validateCredentialsResponse", namespace = "http://ws.greenhat.inn372.qut.edu.au/")
public class ValidateCredentialsResponse {

    @XmlElement(name = "result", namespace = "")
    private au.edu.qut.inn372.greenhat.bean.UserProfile result;

    /**
     * 
     * @return
     *     returns UserProfile
     */
    public au.edu.qut.inn372.greenhat.bean.UserProfile getResult() {
        return this.result;
    }

    /**
     * 
     * @param result
     *     the value for the result property
     */
    public void setResult(au.edu.qut.inn372.greenhat.bean.UserProfile result) {
        this.result = result;
    }

}
