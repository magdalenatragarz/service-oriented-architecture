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

    public Integer getAvatarId() {
        return avatarId;
    }

    public String getPath() {
        return path;
    }

    public String getBase64() {
        return base64;
    }

    public AvatarJPA() {
    }

    public void setAvatarId(Integer avatarId) {
        this.avatarId = avatarId;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setBase64(String base64) {
        this.base64 = base64;
    }
}
