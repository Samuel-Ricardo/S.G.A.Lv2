/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Samuel
 */
public class Time {

    private Date date;
    private java.sql.Date dateSQL;
    private LocalDate localDate;
    private LocalTime localTime;
    private LocalDateTime localDateTime;
    private java.sql.Time timeSQL;
    private Calendar calendar;
    private GregorianCalendar gregorianCalendar;
    private static final SimpleDateFormat defaultDate = new SimpleDateFormat("dd/MM/yyyy HH:mm");
    private static final SimpleDateFormat HourAndMinute = new SimpleDateFormat("HH:mm");
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public Time(Date date, java.sql.Date dateSql, LocalDate localDate, LocalTime localTime, java.sql.Time timeSQL, Calendar calendar, GregorianCalendar gregorianCalendar) {
        this.date = date;
        this.dateSQL = dateSql;
        this.localDate = localDate;
        this.localTime = localTime;
        this.timeSQL = timeSQL;
        this.calendar = calendar;
        this.gregorianCalendar = gregorianCalendar;
    }

    public Time() {

        this.date = new Date();
        this.dateSQL = dateToSqlDate(date);
        this.localDate = LocalDate.now();
        this.localTime = LocalTime.now();
        this.timeSQL = localTimeToTimeSQL(localTime);
        this.localDateTime = LocalDateTime.now();
        this.gregorianCalendar = new GregorianCalendar();

    }

    public Time(java.sql.Date sqlDate) {

        this.date = SqlDateToDate(sqlDate);
        this.dateSQL = dateToSqlDate(date);
        this.localDate = sqlDate.toLocalDate();
        this.localTime = LocalTime.now();
        this.timeSQL = localTimeToTimeSQL(localTime);
        this.localDateTime = LocalDateTime.now();
        this.gregorianCalendar = new GregorianCalendar();

    }

    public Time(Date date) {

        this.date = date;
        this.dateSQL = dateToSqlDate(date);
        this.localDateTime = dateToLocalDateTime(date);
        this.localDate = dateToLocalDate(date);
        this.localTime = dateToLocalTime(date);
        this.timeSQL = localTimeToTimeSQL(localTime);
        this.gregorianCalendar = new GregorianCalendar();

    }
    
    public Time(String dateString) {

        try {
            
            this.date = Time.defaultDate.parse(dateString);
            this.dateSQL = dateToSqlDate(date);
            this.localDateTime = dateToLocalDateTime(date);
            this.localDate = dateToLocalDate(date);
            this.localTime = dateToLocalTime(date);
            this.timeSQL = localTimeToTimeSQL(localTime);
            this.gregorianCalendar = new GregorianCalendar();
            
        } catch (ParseException ex) {
            Logger.getLogger(Time.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public Time(LocalDateTime dateTime) {
        
        this.localDateTime = dateTime;
        this.localDate = localDateTime.toLocalDate();
        this.localTime = localDateTime.toLocalTime();
        this.timeSQL = localTimeToTimeSQL(localTime);
        this.dateSQL = localDateToDateSQL(localDate);
        System.out.println(dateSQL.getTime()+"FFFFFFFFFFFFFFFF");
        this.date = SqlDateToDate(dateSQL);
        
        this.gregorianCalendar = new GregorianCalendar();
    
    }

    public static Date now(){
        
        return new Date();
    }
    
    public Date SqlDateToDate(java.sql.Date sqlDate) {
        
        System.out.println(sqlDate.getTime()+"PAAAAAAAAAAAAAAAAAAAAAAAAAAaaaaa");
        
        return new Date(sqlDate.getTime());
    }

    public java.sql.Date dateToSqlDate(Date date1) {

        return new java.sql.Date(date1.getTime());
    }
    
    public String getStringFromDate(Date date) {

        String formated = defaultDate.format(date);

        return formated;
    }

    public java.sql.Date getSQLDateFrom(Date date) {

        return dateToSqlDate(date);
    }

    public java.sql.Time getTimeSQL() {
        return timeSQL;
    }

    public void setTimeSQL(java.sql.Time timeSQL) {
        this.timeSQL = timeSQL;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public java.sql.Date getDateSQL() {
        return dateSQL;
    }

    public void setDateSQL(java.sql.Date dateSQL) {
        this.dateSQL = dateSQL;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    public LocalTime getLocalTime() {
        return localTime;
    }

    public void setLocalTime(LocalTime localTime) {
        this.localTime = localTime;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public Calendar getCalendar() {
        return calendar;
    }

    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }

    public GregorianCalendar getGregorianCalendar() {
        return gregorianCalendar;
    }

    public void setGregorianCalendar(GregorianCalendar gregorianCalendar) {
        this.gregorianCalendar = gregorianCalendar;
    }
    
    
    
    
    
    private LocalDate dateToLocalDate(Date date) {

        Date formatedDate = getOnlyDate(date);

        LocalDate local = formatedDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        return local;
    }

    private LocalTime dateToLocalTime(Date date) {

        Date time = getHoursAndMinutes(date);

        LocalTime local = time.toInstant().atZone(ZoneId.systemDefault()).toLocalTime();

        return local;
    }

    public Date getHoursAndMinutes(Date date) {

        String stringTime = Time.HourAndMinute.format(date);
        Date time = null;

        try {

            time = Time.HourAndMinute.parse(stringTime);

        } catch (ParseException ex) {
            Logger.getLogger(Time.class.getName()).log(Level.SEVERE, null, ex);
        }

        return time;
    }

    public Date formatDate(Date date, SimpleDateFormat format) {

        String stringTime = format.format(date);
        Date formated = null;

        try {

            formated = format.parse(stringTime);

        } catch (ParseException ex) {
            Logger.getLogger(Time.class.getName()).log(Level.SEVERE, null, ex);
        }

        return formated;
    }

    public Date getOnlyDate(Date date) {

        String stringTime = Time.dateFormat.format(date);
        Date formatedDate = null;

        try {

            formatedDate = Time.dateFormat.parse(stringTime);

        } catch (ParseException ex) {
            Logger.getLogger(Time.class.getName()).log(Level.SEVERE, null, ex);
        }

        return formatedDate;
    }

    public Date getCompletDate(Date date) {

        String stringTime = Time.defaultDate.format(date);
        Date formatedDate = null;

        try {

            formatedDate = Time.defaultDate.parse(stringTime);

        } catch (ParseException ex) {
            Logger.getLogger(Time.class.getName()).log(Level.SEVERE, null, ex);
        }

        return formatedDate;
    }

    private LocalDateTime dateToLocalDateTime(Date date) {

        Date formatedDate = getCompletDate(date);

        LocalDateTime local = formatedDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();

        return local;
    }

    private java.sql.Time localTimeToTimeSQL(LocalTime localTime) {
    
        return java.sql.Time.valueOf(localTime);
    }

    private java.sql.Date localDateToDateSQL(LocalDate localDate) {
      
        return java.sql.Date.valueOf(localDate);
    }
    
    
    
      public String getOnlyDate() {
          
        return Time.dateFormat.format(date);
    }
      
      public String getOnlyTime() {
          
        return localDateTime.getHour()+" : "+localDateTime.getMinute();
    }

    public static SimpleDateFormat getDefaultDate() {
        return defaultDate;
    }

    public static SimpleDateFormat getHourAndMinute() {
        return HourAndMinute;
    }

    public static SimpleDateFormat getDateFormat() {
        return dateFormat;
    }
      
      
}
