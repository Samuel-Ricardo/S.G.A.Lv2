/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Components;

import Model.Book;
import Model.ImageFile;
import View.Components.BookPane;
import View.Researchers.ListOfBooks;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JLabel;

/**
 *
 * @author Samuel
 */
public class BookPaneController {
    
    private final BookPane view;
    private final Book book;
    private final ListOfBooks father;
    private MouseListener MouseSelectListener;

    public BookPaneController(BookPane view, Book book, ListOfBooks father) {
     
        this.view = view;
        this.book = book;
        this.father = father;
        
        this.MouseSelectListener = new MouseListener() {
            
            @Override
            public void mouseClicked(MouseEvent e) {
             
                ListOfBooks.setSelectedBookPane(view);
                father.getController().loadDetails();
            }

            @Override
            public void mousePressed(MouseEvent e) {
           
            }

            @Override
            public void mouseReleased(MouseEvent e) {
              
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            
            }

            @Override
            public void mouseExited(MouseEvent e) {
            
            }
        };
    }

    public void start() {
     
            view.getjLabelName().setText(book.getName());
            view.getjLabelStock().setText(book.getStock().toString());
            view.getjLabelGenre().setText(book.getGenre());
            resizeImageLabe(view.getjLabelImage());
            
            if(book.getImage() != null){
                
                if(book.getImage().getImageFile().getFile().exists()){
                    
                    setImage();
                    
                }else{
                    setEmptyImage();
                }
            }else{
                setEmptyImage();
            }
            
            
            view.setMaximumSize(new Dimension(196, 270));
            System.out.println("paod                   equeio");
            
            selectListener();
    }

    public void setImage() {
        
        ImageFile.resizeImageByPath(view.getjLabelImage(), book.getImage().getImageFile().getFile().getAbsolutePath());
    }
    
    public void setEmptyImage() {
        
        ImageFile.resizeImage(view.getjLabelImage(), "/View/Images/icons8-no-image-64px.png");
    }

    private void resizeImageLabe(JLabel label) {
    
        label.setSize(172, 160);
    }

    public BookPane getView() {
        return view;
    }

    public Book getBook() {
        return book;
    }

    private void selectListener() {
    
        view.addMouseListener(MouseSelectListener);
        
         for(Component comp: view.getComponents()){
             
             comp.addMouseListener(MouseSelectListener);
         }
    }
}
