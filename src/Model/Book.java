/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Time.Time;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;

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
    private ArrayList<ImageFile> Image;
    private Time acquired;

    public Book(Long id, String name, String genre, String author, String publisher, String stock, ArrayList<ImageFile> Image, Time acquired) {
        this.id = id;
        this.name = name;
        this.genre = genre;
        this.author = author;
        this.publisher = publisher;
        this.stock = new Integer (stock);
        this.Image = Image;
        this.acquired = acquired;
    }

    public Book() {
        
        this.acquired = new Time();
        
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

    public ArrayList<ImageFile> getImage() {
        return Image;
    }

    public void setImage(ArrayList<ImageFile> Image) {
        this.Image = Image;
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
}
