package pl.edu.agh.soa;

import javax.xml.bind.annotation.*;


@XmlType
@XmlAccessorType(XmlAccessType.FIELD)
public class Subject {
    public String name;
    public Integer ECTS;

    public Subject(String name, Integer ECTS) {
        this.name = name;
        this.ECTS = ECTS;
    }

    public String getName() {
        return name;
    }

    public int getECTS() {
        return ECTS;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setECTS(Integer ECTS) {
        this.ECTS = ECTS;
    }
}
