/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import DAO.ImageDAO;
import Time.Time;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Samuel
 */
public class Book {
    
    private Long id;
    private String name;
    private String genre;
    private String author;
    private String publisher;
    private Integer stock;
    private BackupImage image;
    private ArrayList<BackupImage> Images = new ArrayList<>();
    private Time acquired;
    
    public Book(Long id, String name, String genre, String author, String publisher, String stock, ArrayList<BackupImage> Images, Time acquired) {
        this.id = id;
        this.name = name;
        this.genre = genre;
        this.author = author;
        this.publisher = publisher;
        this.stock = new Integer (stock);
        this.Images = Images;
        this.acquired = acquired;
    }

    public Book() {
        
        this.acquired = new Time();
        this.image = new BackupImage();
        this.author =  "Empty";
        this.genre = "Empty";
        this.name = "Empty";
        this.publisher = "Empty";
        this.stock = 0;
        
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public void setId(int id) {
        this.id = new Long(id);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
    
    public void setStock(int stock) {
        this.stock = stock;
    }

    public BackupImage getImage() {
        return image;
    }

    public void setImage(BackupImage image) {
        
        this.image = image;
    }
    
    public ArrayList<BackupImage> getImages() {
        return Images;
    }

    public void setImages(ArrayList<BackupImage> Images) {
        this.Images = Images;
    }

    public Time getAcquired() {
        return acquired;
    }

    public void setAcquired(Time acquired) {
        this.acquired = acquired;
    }
    
    public void setAcquired(java.sql.Date acquired) {
        this.acquired = new Time(acquired);
    }

    public static ImageFile DefaultBookImage() {
      
        ImageFile image = null;
        
        System.out.println(Book.class.getResource("/View/Images/icons8-no-image-64px.png").getPath());
        
          image = new ImageFile(Book.class.getResource("/View/Images/icons8-no-image-64px.png").getPath());
          
        return image;
    }

    public void setImage(ImageFile imageFile) {
        
        ImageDAO imageDao = new ImageDAO();
        
        List<BackupImage> images = imageDao.searchByName(imageFile.getFile().getName());
        
        if(images.isEmpty() == false){
            
            this.image = images.get(0);
        }else{
            
            this.image.setImageFile(imageFile);
        }
    }
}
