package pl.edu.agh.soa;

import javax.xml.bind.annotation.*;


@XmlType(name="subject")
@XmlAccessorType(XmlAccessType.FIELD)
public class Subject {

    public Integer subjectId;
    public String name;
    public Integer ECTS;

    public Subject(Integer subjectId, String name, Integer ECTS) {
        this.name = name;
        this.ECTS = ECTS;
        this.subjectId = subjectId;
    }

    public String getName() {
        return name;
    }

    public int getECTS() {
        return ECTS;
    }

    public Integer getSubjectId() {
        return subjectId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setECTS(Integer ECTS) {
        this.ECTS = ECTS;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

}

