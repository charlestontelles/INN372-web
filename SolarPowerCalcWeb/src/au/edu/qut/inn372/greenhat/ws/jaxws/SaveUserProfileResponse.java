
package au.edu.qut.inn372.greenhat.ws.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "saveUserProfileResponse", namespace = "http://ws.greenhat.inn372.qut.edu.au/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "saveUserProfileResponse", namespace = "http://ws.greenhat.inn372.qut.edu.au/")
public class SaveUserProfileResponse {

    @XmlElement(name = "userProfile", namespace = "")
    private au.edu.qut.inn372.greenhat.bean.UserProfile userProfile;

    /**
     * 
     * @return
     *     returns UserProfile
     */
    public au.edu.qut.inn372.greenhat.bean.UserProfile getUserProfile() {
        return this.userProfile;
    }

    /**
     * 
     * @param userProfile
     *     the value for the userProfile property
     */
    public void setUserProfile(au.edu.qut.inn372.greenhat.bean.UserProfile userProfile) {
        this.userProfile = userProfile;
    }

}
