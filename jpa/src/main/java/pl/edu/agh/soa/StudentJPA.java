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

    public StudentJPA() {
    }

    public Integer getId() {
        return id;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public AvatarJPA getAvatar() {
        return avatar;
    }

    public List<SubjectJPA> getSubjects() {
        return subjects;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setAvatar(AvatarJPA avatar) {
        this.avatar = avatar;
    }

    public void setSubjects(List<SubjectJPA> subjects) {
        this.subjects = subjects;
    }
}
