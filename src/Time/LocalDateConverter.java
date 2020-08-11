/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities.Time;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import javafx.util.converter.LocalDateStringConverter;
/**
 *
 * @author Samuel
 */
public class LocalDateConverter {
    
    private final LocalDateStringConverter stringConverter = new LocalDateStringConverter();
    private final DateTimeFormatter DEFAULT_FORMAT = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private final DateTimeFormatter SHORT_FORMAT = DateTimeFormatter.ofPattern("dd/MM");
    
    
    // LocalDate
    
    public LocalDate toLocalDate(String string){
        
      return LocalDate.parse(string, DEFAULT_FORMAT);
    }
    
    public LocalDate fromDate(Date date) {

        LocalDate local = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        return local;
    }
    
    //SQL
    
    public java.sql.Date toSQLDate(LocalDate localDate) {
      
        return java.sql.Date.valueOf(localDate);
    }

    // String
    
    public String defaultFormat(LocalDate localDate) {
       
        return DEFAULT_FORMAT.format(localDate);
    }

    public String shortFormat(LocalDate localDate) {
      
        return SHORT_FORMAT.format(localDate);
    }
}
