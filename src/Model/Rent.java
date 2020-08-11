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
    private Time rented;
    private Time returnDate;
    private boolean returned;
    private double penality;
    private String obrservation;

    public Rent(Student student, Book book, User client, Time rented, Time returnDate, boolean delivered, double penality, String obrservation) {
        this.student = student;
        this.book = book;
        this.client = client;
        this.rented = rented;
        this.returnDate = returnDate;
        this.returned = delivered;
        this.penality = penality;
        this.obrservation = obrservation;
    }


    
    public Rent() {
        
        rented = new Time();
        returnDate = new Time();
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

    public Time getRented() {
        return rented;
    }

    public void setRented(Time rented) {
        this.rented = rented;
    }
    
    public void setRented(java.sql.Date rented) {
        this.rented = new Time (rented);
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
    
    
    
}
