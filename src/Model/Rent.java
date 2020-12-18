/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Time.Time;
import java.util.Date;

/**
 *
 * @author Samuel
 */
public class Rent {
    
    private Long id;
    private Student student;
    private Book book;
    private User client;
    private Time rentedDate;
    private Time returnDate;
    private boolean returned;
    private Time returnedDate;
    private double penality;
    private String obrservation;

    public Rent(Student student, Book book, User client, Time rented, Time returnDate, Time returnedDate, boolean delivered, double penality, String obrservation) {
        this.student = student;
        this.book = book;
        this.client = client;
        this.rentedDate = rented;
        this.returnDate = returnDate;
        this.returned = delivered;
        this.returnedDate = returnedDate;
        this.penality = penality;
        this.obrservation = obrservation;
    }


    
    public Rent() {
        
        rentedDate = new Time();
        returnDate = new Time();
        returnedDate = new Time();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setId(int id) {
        this.id = new Long (id);
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Time getRentedDate() {
        return rentedDate;
    }

    public void setRentedDate(Time rentedDate) {
        this.rentedDate = rentedDate;
    }
    
    public void setRented(java.sql.Date rented) {
        this.rentedDate = new Time (rented);
    }

    public Time getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Time returnDate) {
        this.returnDate = returnDate;
    }
    
    public void setReturnDate(java.sql.Date returnDate) {
        this.returnDate = new Time(returnDate);
    }

    public boolean isReturned() {
        return returned;
    }

    public void setReturned(boolean returned) {
        this.returned = returned;
    }

    public double getPenality() {
        return penality;
    }

    public void setPenality(double penality) {
        this.penality = penality;
    }

    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }

    public String getObrservation() {
        return obrservation;
    }

    public void setObrservation(String obrservation) {
        this.obrservation = obrservation;
    }

    public Time getReturnedDate() {
        return returnedDate;
    }

    public void setReturnedDate(Time returnedDate) {
        this.returnedDate = returnedDate;
    }
    
     public void setReturnedDate(java.sql.Date returnedDate) {
        this.returnedDate = new Time(returnedDate);
    }
}
