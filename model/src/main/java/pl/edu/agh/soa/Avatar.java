package pl.edu.agh.soa;

import javax.validation.constraints.NotNull;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.Serializable;
import java.util.Base64;


public class Avatar  {

    @NotNull
    private String path;
    private String base64;

    public Avatar() {}

    public Avatar(String path) {
        this.path = path;
    }

    public void setBase64(String base64) {
        this.base64 = base64;
    }

    public String getBase64() {
        return base64;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public boolean encode(){
        File file = new File(path);
        try (FileInputStream imageInFile = new FileInputStream(file)) {
            byte[] imageData = new byte[(int) file.length()];
            imageInFile.read(imageData);
            base64 = Base64.getEncoder().encodeToString(imageData);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public byte[] decode(){
        return Base64.getDecoder().decode(base64);
    }

    public boolean save(){
        String destinationPath = System.getProperty("user.home")+"/student_out.jpg";
        try(FileOutputStream imageOutFile = new FileOutputStream(destinationPath)) {
            imageOutFile.write(decode());
            return true;
        }catch(Exception e){
            return false;
        }
    }

    @Override
    public String toString() {
        return "Avatar{" +
                "path='" + path + '\'' +
                ", base64='" + base64 + '\'' +
                '}';
    }
}
