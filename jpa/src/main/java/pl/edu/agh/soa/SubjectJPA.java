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

}
