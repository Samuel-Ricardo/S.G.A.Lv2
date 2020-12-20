/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Researchers;

import Controller.Helper.Researcher.BookListHelper;
import Controller.MainMenuController;
import Controller.Rent.RentController;
import DAO.BookDAO;
import Model.Book;
import Model.ImageFile;
import Model.User;
import Services.Dialoger;
import Time.Time;
import View.MainMenu;
import View.Researchers.ListOfBooks;
import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyVetoException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.text.JTextComponent;

/**
 *
 * @author Samuel
 */
public class BookListController {

    private final ListOfBooks view;
    private final BookDAO bookDao;
    private final BookListHelper helper;
    private Book updateBook;

    public BookListController(ListOfBooks view) {
        this.view = view;
        this.bookDao = new BookDAO();
        this.helper = new BookListHelper(view);
    }

    public void start() {

        view.getjPanelBookList().setLayout(new BoxLayout(view.getjPanelBookList(), BoxLayout.LINE_AXIS));

        startSearchBar();

        loadAllBooks();

        hideUpdateFilds();

        setUpdateFildsListeners();

        view.getjPanelBookDetails().addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

                hideUpdateFilds();
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
        });
    }

    public void startSearchBar() {
        view.getjLabelSearchIcon().setSize(55, 42);

        ImageFile.resizeImage(view.getjLabelSearchIcon(), "/View/Images/icons8-search-bar-60.png");

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

        helper.setBookOnList(books, Box.createHorizontalBox());

    }

    public void loadDetails() {

        helper.loadBookDetails();
        updateBook = view.getSelectedBookPane().getBook();
    }

    private void deepSearch() {

        //view.getjPanelBookList().removeAll();
        loadBooks((ArrayList<Book>) bookDao.deepSearch(view.getjTextFieldSearch().getText()));

    }

    public void fastSearch() {

        //view.getjPanelBookList().removeAll();
        loadBooks((ArrayList<Book>) bookDao.fastSearch(view.getjTextFieldSearch().getText()));
    }

    public void hideUpdateFilds() {

        view.getjTextFieldName().setVisible(false);
        view.getjTextFieldAuthor().setVisible(false);
        view.getjTextFieldGenre().setVisible(false);
        view.getjTextFieldPublisher().setVisible(false);
        view.getjFormattedTextFieldDate().setVisible(false);
        view.getjSpinnerStock().setVisible(false);

        showLabels();
    }

    private void setUpdateFildsListeners() {

        showOnClick(view.getjLabelName(), view.getjTextFieldName());
        showOnClick(view.getjLabelAuthor(), view.getjTextFieldAuthor());
        showOnClick(view.getjLabelGenre(), view.getjTextFieldGenre());
        showOnClick(view.getjLabelPublisher(), view.getjTextFieldPublisher());
        showOnClick(view.getjLabelAcquiredDate(), view.getjFormattedTextFieldDate());
        showOnClick(view.getjLabelStock(), view.getjSpinnerStock());

        saveOnPressEnter(view.getjTextFieldName(), view.getjLabelName());
        saveOnPressEnter(view.getjTextFieldAuthor(), view.getjLabelAuthor());
        saveOnPressEnter(view.getjTextFieldGenre(), view.getjLabelGenre());
        saveOnPressEnter(view.getjTextFieldPublisher(), view.getjLabelPublisher());
        saveOnPressEnter(view.getjFormattedTextFieldDate(), view.getjLabelAcquiredDate());

        view.getjSpinnerStock().getModel().addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {

                view.getjLabelStock().setText("" + (int) view.getjSpinnerStock().getValue());
                hideUpdateFilds();
                view.getjButtonUpdate().setEnabled(true);
            }
        });

    }

    private void showOnClick(Component clicked, Component show) {

        clicked.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {

                clicked.setVisible(false);
                show.setVisible(true);
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
        });
    }

    private void saveOnPressEnter(JTextComponent text, JLabel label) {

        text.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {

                if (e.getKeyCode() == KeyEvent.VK_ENTER) {

                    label.setText(text.getText());
                    hideUpdateFilds();
                    view.getjButtonUpdate().setEnabled(true);
                }
            }
        });
    }

    private void showLabels() {

        view.getjLabelName().setVisible(true);
        view.getjLabelAuthor().setVisible(true);
        view.getjLabelGenre().setVisible(true);
        view.getjLabelPublisher().setVisible(true);
        view.getjLabelAcquiredDate().setVisible(true);
        view.getjLabelStock().setVisible(true);
    }

    public void update() {

        updateBook.setName(view.getjLabelName().getText());
        updateBook.setAuthor(view.getjLabelAuthor().getText());
        updateBook.setGenre(view.getjLabelGenre().getText());
        updateBook.setPublisher(view.getjLabelPublisher().getText());
        updateBook.setStock(Integer.parseInt(view.getjLabelStock().getText()));
        updateBook.setAcquired(new Time(view.getjLabelAcquiredDate().getText()));

        //       if(updateBook.equals(view.getSelectedBookPane().getBook()) == false){
        if (bookDao.update(updateBook)) {

            Dialoger.message(view, " Os dados do livro " + updateBook.getName() + " foram atualizado com sucesso"
                    + "\n"
                    + "\n Atualize a Pagina");
        }
//        }else{
//            
//            Dialoguer.message(view, "Nao foi realizada nenhuma modificaçao, atualizaçao nao nescessária");
//        }

        loadAllBooks();
    }

    public void loadAllBooks() {
        loadBooks((ArrayList<Book>) bookDao.selectAll());
    }

    public void delete() {

        Book book = ListOfBooks.getSelectedBookPane().getBook();

        if (Dialoger.confirm(view, " Voce realmente deseja deletar o livro " + book.getName() + " ?"
                + "\n"
                + "\n Os dados nao poderao ser recuperados")) {

            bookDao.delet(book);

            loadAllBooks();
        }
    }

    public void rentBook() {
    
        if(MainMenuController.RENT_WINDOW != null){
            if(MainMenuController.RENT_WINDOW.isClosed() == false){
                
                RentController.loadBook(ListOfBooks.getSelectedBookPane().getBook(), view);
                
                try {
                    view.setClosed(true);
                } catch (PropertyVetoException ex) {
                    Logger.getLogger(BookListController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else{
            
            MainMenuController.OpenRent(ListOfBooks.getSelectedBookPane().getBook(), new User());
           }
        }else{
            
            MainMenuController.OpenRent(ListOfBooks.getSelectedBookPane().getBook(), new User());
        }
        
    }
}
