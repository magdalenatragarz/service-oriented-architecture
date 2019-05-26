package pl.edu.agh.soa;


import javax.persistence.*;

@Entity
@Table(name = "avatar_table")
public class AvatarJPA {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer avatarId;

    @Column(name = "path")
    private String path;

    @Column(name = "base64")
    private String base64;

}
