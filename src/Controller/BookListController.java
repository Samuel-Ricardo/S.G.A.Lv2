/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Controller.Helper.BookListHelper;
import DAO.BookDAO;
import Model.Book;
import Model.ImageFile;
import View.ListOfBooks;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.Box;
import javax.swing.BoxLayout;

/**
 *
 * @author Samuel
 */
public class BookListController {
    
    private final ListOfBooks view;
    private final BookDAO bookDao;
    private final BookListHelper helper;

    public BookListController(ListOfBooks view) {
        this.view = view;
        this.bookDao = new BookDAO();
        this.helper = new BookListHelper(view);
    }

    public void start() {
    
        view.getjPanelBookList().setLayout(new BoxLayout(view.getjPanelBookList(),BoxLayout.LINE_AXIS));
        
        startSearchBar();
        
        loadBooks((ArrayList<Book>) bookDao.selectAll());
        
        hideUpdateFilds();
    }

    public void startSearchBar() {
        view.getjLabelSearchIcon().setSize(55, 42);
        
        ImageFile.resizeImage(view.getjLabelSearchIcon(),"/View/Images/icons8-search-bar-60.png");
        
        view.getjLabelSearchIcon().addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
              
                deepSearch();
                
            }

            @Override
            public void mousePressed(MouseEvent e) {
            
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            
                deepSearch();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
           
            }

            @Override
            public void mouseExited(MouseEvent e) {
           
            }
        });
    }

    public void loadBooks(ArrayList<Book> books) {
        
        view.getjPanelBookList().removeAll();
        
        helper.setBookOnList(books,Box.createHorizontalBox());
        
    }

    public void loadDetails() {
        
        helper.loadBookDetails();
    }
    
    private void deepSearch() {
    
        //view.getjPanelBookList().removeAll();
        
        loadBooks((ArrayList<Book>) bookDao.deepSearch(view.getjTextFieldSearch().getText()));
        
    }

    public void fastSearch() {
       
        //view.getjPanelBookList().removeAll();
        
        loadBooks((ArrayList<Book>) bookDao.fastSearch(view.getjTextFieldSearch().getText()));
    }

    private void hideUpdateFilds() {
      
        view.getjTextFieldName().setVisible(false);
        view.getjTextFieldAuthor().setVisible(false);
        view.getjTextFieldGenre().setVisible(false);
        view.getjTextFieldPublisher().setVisible(false);
        view.getjFormattedTextFieldDate().setVisible(false);
        view.getjSpinnerStock().setVisible(false);
    }
}
