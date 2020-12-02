/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Helper.Researcher;

import Model.Book;
import Model.ImageFile;
import Services.FileManager;
import View.Components.BookPane;
import View.Researchers.ListOfBooks;
import java.util.ArrayList;
import javax.swing.Box;
import javax.swing.JLabel;

/**
 *
 * @author Samuel
 */
public class BookListHelper {

    private final ListOfBooks view;

    public BookListHelper(ListOfBooks view) {
        this.view = view;
    }

    public void setBookOnList(ArrayList<Book> books, Box box) {

        for (Book book : books) {
            
            BookPane pane = new BookPane(book, view);

            pane.getInsets().set(10, 10, 10, 10);

            box.add(pane);

            // view.getjPanelBookList().add(pane);
            //view.getjPanelBookList().add(Box.createHorizontalBox().add(pane));

            System.out.println(pane.getController().getBook().getAuthor() + "   " + view.getjPanelBookList().getWidth());
        }
        view.getjPanelBookList().add(box);
        
        
        view.getjPanelBookList().updateUI();
    }

    public void loadBookDetails() {

        Book book = ListOfBooks.getSelectedBookPane().getBook();

        view.getjLabelAuthor().setText(book.getAuthor());
        view.getjLabelAcquiredDate().setText(book.getAcquired().getOnlyDate());
        view.getjLabelGenre().setText(book.getGenre());
        view.getjLabelName().setText(book.getName());
        view.getjLabelPublisher().setText(book.getPublisher());
        view.getjLabelStock().setText(book.getStock() + "");

        loadBookImage(book);
    }

    public void loadBookImage(Book book) {

        view.getjLabelImageBook().setText("");

        if (book.getImage().getImageFile().getFile().exists()) {

            view.getjLabelImageBook().setIcon(book.getImage().getImageFile().getImageSwing());

            ImageFile.resizeImageByPath(view.getjLabelImageBook(), book.getImage().getImageFile().getFile().getAbsolutePath());

        } else {

            ImageFile.resizeImage(view.getjLabelImageBook(), FileManager.NO_IMAGE);
        }
    }

}
