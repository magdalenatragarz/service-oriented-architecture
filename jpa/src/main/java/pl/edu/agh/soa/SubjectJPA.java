package pl.edu.agh.soa;


import javax.persistence.*;

@Entity
@Table(name = "subject_table")
public class SubjectJPA {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer subjectId;

    @Column(name = "ects")
    private Integer ects;

    @Column(name = "name")
    private String name;

    public SubjectJPA() {
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    public void setEcts(Integer ects) {
        this.ects = ects;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSubjectId() {
        return subjectId;
    }

    public Integer getEcts() {
        return ects;
    }

    public String getName() {
        return name;
    }
}
