package pl.edu.agh.soa;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "student_table")
public class StudentJPA {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "studentId")
    private Integer studentId;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @JoinColumn(name = "avatarId", unique = true)
    @OneToOne(cascade = CascadeType.ALL)
    private AvatarJPA avatar;

    @JoinColumn(name = "subjectId", unique = true)
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SubjectJPA> subjects = new ArrayList<>();

}
