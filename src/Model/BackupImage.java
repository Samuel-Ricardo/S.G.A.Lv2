/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;


/**
 *
 * @author Samuel
 */
public class BackupImage{
    
    private Integer id;
    private ImageFile imageFile;

    public BackupImage(Integer id, ImageFile image) {
        this.id = id;
        this.imageFile = image;

    }

    public BackupImage() {
        imageFile = new ImageFile("");
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ImageFile getImageFile() {
        return imageFile;
    }

    public void setImageFile(ImageFile imageFile) {
        this.imageFile = imageFile;
    }    
    
}
