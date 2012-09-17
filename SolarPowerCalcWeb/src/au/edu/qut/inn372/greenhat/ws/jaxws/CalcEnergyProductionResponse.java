
package au.edu.qut.inn372.greenhat.ws.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "calcEnergyProductionResponse", namespace = "http://ws.greenhat.inn372.qut.edu.au/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "calcEnergyProductionResponse", namespace = "http://ws.greenhat.inn372.qut.edu.au/")
public class CalcEnergyProductionResponse {

    @XmlElement(name = "calculator", namespace = "")
    private au.edu.qut.inn372.greenhat.bean.Calculator calculator;

    /**
     * Get the calculator
     * @return Calculator
     */
    public au.edu.qut.inn372.greenhat.bean.Calculator getCalculator() {
        return this.calculator;
    }

    /**
     * Set the calculator
     * @param calculator value for the calculator property
     */
    public void setCalculator(au.edu.qut.inn372.greenhat.bean.Calculator calculator) {
        this.calculator = calculator;
    }

}
