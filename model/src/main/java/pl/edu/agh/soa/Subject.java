package pl.edu.agh.soa;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


@XmlType(name = "subject")
@XmlAccessorType(XmlAccessType.FIELD)
public class Subject {

    @NotNull
    private String name;

    @NotNull
    @Min(1)
    @Max(30)
    private int ECTS;


    public Subject() {
    }

    public Subject(String name, int ECTS) {
        this.name = name;
        this.ECTS = ECTS;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getECTS() {
        return ECTS;
    }

    public void setECTS(int ECTS) {
        this.ECTS = ECTS;
    }
}


