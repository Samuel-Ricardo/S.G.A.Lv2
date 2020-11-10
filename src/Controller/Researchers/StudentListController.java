/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Researchers;

import Controller.Helper.StudentListHelper;
import DAO.StudentDAO;
import Model.Book;
import Model.ImageFile;
import Model.Student;
import Services.Dialoger;
import Time.Time;
import View.Researchers.ListOfStudents;
import View.Researchers.ListOfStudents;
import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
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
public class StudentListController {

    private final ListOfStudents view;
    private final StudentDAO studentDao;
    private final StudentListHelper helper;
    private Book updateBook;

    public StudentListController(ListOfStudents view) {
        this.view = view;
        this.studentDao = new StudentDAO();
        this.helper = new StudentListHelper(view);
    }

    public void start() {

        view.getjPanelStudentList().setLayout(new BoxLayout(view.getjPanelStudentList(), BoxLayout.LINE_AXIS));

        startSearchBar();

        loadAllBooks();

        hideUpdateFilds();

        setUpdateFildsListeners();

        view.getjTabbedPaneDetails().addMouseListener(new MouseListener() {
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

        view.getjPanelStudentList().removeAll();

        helper.setBookOnList(books, Box.createHorizontalBox());

    }

    public void loadDetails() {

        helper.loadBookDetails();
        updateBook = view.getSelectedBookPane().getBook();
    }

    private void deepSearch() {

        loadBooks((ArrayList<Student>) studentDao.deepSearch(view.getjTextFieldSearch().getText()));

    }

    public void fastSearch() {

        loadBooks((ArrayList<Student>) studentDao.fastSearch(view.getjTextFieldSearch().getText()));
    }

    public void hideUpdateFilds() {

        view.getjTextFieldName().setVisible(false);
        view.getjTextFieldCourse().setVisible(false);
        view.getjTextFieldEmail().setVisible(false);
        view.getjTextFieldLogin().setVisible(false);
        view.getjTextFieldPassword().setVisible(false);
        view.getjTextFieldRegistration().setVisible(false);
        view.getjFormattedTextFieldCEP().setVisible(false);
        view.getjFormattedTextFieldPhone().setVisible(false);
        view.getjComboBoxAddress().setVisible(false);
        view.getjComboBoxGrade().setVisible(false);
        view.getjComboBoxModule().setVisible(false);
        view.getjComboBoxSchool().setVisible(false);
        view.getjComboBoxShift().setVisible(false);

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
        view.getjLabelAddress().setVisible(true);
        view.getjLabelCEP().setVisible(true);
        view.getjLabelCourse().setVisible(true);
        view.getjLabelEmail().setVisible(true);
        view.getjLabelGrade().setVisible(true);
        view.getjLabelLogin().setVisible(true);
        view.getjLabelModule().setVisible(true);
        view.getjLabelPassword().setVisible(true);
        view.getjLabelPhone().setVisible(true);
        view.getjLabelRegistration().setVisible(true);
        view.getjLabelSchool().setVisible(true);
        view.getjLabelShift().setVisible(true);
            
    }

    public void update() {

        updateBook.setName(view.getjLabelName().getText());
        updateBook.setAuthor(view.getjLabelAuthor().getText());
        updateBook.setGenre(view.getjLabelGenre().getText());
        updateBook.setPublisher(view.getjLabelPublisher().getText());
        updateBook.setStock(Integer.parseInt(view.getjLabelStock().getText()));
        updateBook.setAcquired(new Time(view.getjLabelAcquiredDate().getText()));

        //       if(updateBook.equals(view.getSelectedBookPane().getBook()) == false){
        if (studentDao.update(updateBook)) {

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
        loadBooks((ArrayList<Book>) studentDao.selectAll());
    }

    public void delete() {

        Book book = ListOfStudents.getSelectedBookPane().getBook();

        if (Dialoger.confirm(view, " Voce realmente deseja deletar o livro " + book.getName() + " ?"
                + "\n"
                + "\n Os dados nao poderao ser recuperados")) {

            studentDao.delet(book);

            loadAllBooks();
        }
    }
}
