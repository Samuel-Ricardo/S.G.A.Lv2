/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities.Time;

import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 *
 * @author Samuel
 */
public class LocalTimeConverter {
    
    private final DateTimeFormatter DEFAULT_FORMAT = DateTimeFormatter.ofPattern("hh : mm :ss");
    private final DateTimeFormatter SHORT_FORMAT = DateTimeFormatter.ofPattern("hh : mm");
    
    
    // LocalTime
    
    public LocalTime toLocalTime(String string){
        
      return LocalTime.parse(string, DEFAULT_FORMAT);
    }

    public LocalTime fromDate(Date date) {

        LocalTime local = date.toInstant().atZone(ZoneId.systemDefault()).toLocalTime();

        return local;
    }
    
    // SQL
    
    public java.sql.Time toSQLTime(LocalTime localTime) {
    
        return java.sql.Time.valueOf(localTime);
    }
    
    // Strings
    
    public String shortFormat(LocalTime localTime) {
    
     // return localTime.getHour()+" : "+localTime.getMinute();
     
      return SHORT_FORMAT.format(localTime);
    }
}
