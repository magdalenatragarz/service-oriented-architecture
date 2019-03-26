
package pl.edu.agh.soa;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for addSubject complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="addSubject"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="studentId" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="subjectName" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="ects" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "addSubject", propOrder = {
    "studentId",
    "subjectName",
    "ects"
})
public class AddSubject {

    protected int studentId;
    @XmlElement(required = true)
    protected String subjectName;
    protected int ects;

    /**
     * Gets the value of the studentId property.
     * 
     */
    public int getStudentId() {
        return studentId;
    }

    /**
     * Sets the value of the studentId property.
     * 
     */
    public void setStudentId(int value) {
        this.studentId = value;
    }

    /**
     * Gets the value of the subjectName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubjectName() {
        return subjectName;
    }

    /**
     * Sets the value of the subjectName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubjectName(String value) {
        this.subjectName = value;
    }

    /**
     * Gets the value of the ects property.
     * 
     */
    public int getEcts() {
        return ects;
    }

    /**
     * Sets the value of the ects property.
     * 
     */
    public void setEcts(int value) {
        this.ects = value;
    }

}
