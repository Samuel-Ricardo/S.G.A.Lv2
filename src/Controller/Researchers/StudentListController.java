/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Researchers;


import Controller.Helper.Researcher.StudentListHelper;
import DAO.StudentDAO;
import Model.Student;
import Model.ImageFile;
import Model.Student;
import Services.Dialoger;
import Time.Time;
import View.Researchers.ListOfStudents;
import View.Researchers.ListOfStudents;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;
import javax.swing.text.JTextComponent;

/**
 *
 * @author Samuel
 */
public class StudentListController {

    private final ListOfStudents view;
    private final StudentDAO studentDao;
    private final StudentListHelper helper;
    private Student updateStudent;

    public StudentListController(ListOfStudents view) {
        this.view = view;
        this.studentDao = new StudentDAO();
        this.helper = new StudentListHelper(view);
    }

    public void start() {

        view.getjPanelStudentList().setLayout(new BoxLayout(view.getjPanelStudentList(), BoxLayout.LINE_AXIS));

        startSearchBar();

        loadAllStudents();

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

    public void loadStudents(ArrayList<Student> books) {

        view.getjPanelStudentList().removeAll();

        helper.setStudentOnList(books, Box.createHorizontalBox());

    }

    public void loadDetails() {

        helper.loadStudentDetails();
        updateStudent = view.getSelectedStudentPane().getStudent();
    }

    private void deepSearch() {

        loadStudents((ArrayList<Student>) studentDao.deepSearch(view.getjTextFieldSearch().getText()));

    }

    public void fastSearch() {

        loadStudents((ArrayList<Student>) studentDao.fastSearch(view.getjTextFieldSearch().getText()));
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
        view.getjButtonUpdate().setEnabled(false);
        
        showLabels();
    }

    private void setUpdateFildsListeners() {

        showOnClick(view.getjLabelName(), view.getjTextFieldName());
        showOnClick(view.getjLabelAddress(), view.getjComboBoxAddress());
        showOnClick(view.getjLabelCEP(), view.getjFormattedTextFieldCEP());
        showOnClick(view.getjLabelCourse(), view.getjTextFieldCourse());
        showOnClick(view.getjLabelEmail(), view.getjTextFieldEmail());
        showOnClick(view.getjLabelGrade(), view.getjComboBoxGrade());
        showOnClick(view.getjLabelLogin(), view.getjTextFieldLogin());
        showOnClick(view.getjLabelModule(), view.getjComboBoxModule());
        showOnClick(view.getjLabelPassword(), view.getjTextFieldPassword());
        showOnClick(view.getjLabelPhone(), view.getjFormattedTextFieldPhone());
        showOnClick(view.getjLabelRegistration(), view.getjTextFieldRegistration());
        showOnClick(view.getjLabelSchool(), view.getjComboBoxSchool());
        showOnClick(view.getjLabelShift(), view.getjComboBoxShift());
        
        saveOnPressEnter(view.getjLabelName(), view.getjTextFieldName());
        saveOnPressEnter(view.getjLabelCEP(), view.getjFormattedTextFieldCEP());
        saveOnPressEnter(view.getjLabelCourse(), view.getjTextFieldCourse());
        saveOnPressEnter(view.getjLabelEmail(), view.getjTextFieldEmail());
        saveOnPressEnter(view.getjLabelLogin(), view.getjTextFieldLogin());
        saveOnPressEnter(view.getjLabelPassword(), view.getjTextFieldPassword());
        saveOnPressEnter(view.getjLabelPhone(), view.getjFormattedTextFieldPhone());
        saveOnPressEnter(view.getjLabelRegistration(), view.getjTextFieldRegistration());


        saveOnChange(view.getjLabelAddress(), view.getjComboBoxAddress());
        saveOnChange(view.getjLabelGrade(), view.getjComboBoxGrade());
        saveOnChange(view.getjLabelModule(), view.getjComboBoxModule());
        saveOnChange(view.getjLabelSchool(), view.getjComboBoxSchool());
        saveOnChange(view.getjLabelShift(), view.getjComboBoxShift());
       

    }

    public void saveOnChange(JLabel label, JComboBox comboBox ) {
        
        comboBox.addMouseListener(new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e) {
                
                label.setText(comboBox.getModel().getSelectedItem()+"");
                hideUpdateFilds();
                view.getjButtonUpdate().setEnabled(true);
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

    private void saveOnPressEnter(JLabel label, JTextComponent text) {

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
        
        updateStudent.setName(view.getjLabelName().getText());
        updateStudent.setAddress(view.getjLabelAddress().getText());
        updateStudent.setCEP(view.getjLabelCEP().getText());
        updateStudent.setCourse(view.getjLabelCourse().getText());
        updateStudent.setEmail(view.getjLabelEmail().getText());
        updateStudent.setGrade(view.getjLabelGrade().getText());
        updateStudent.setLogin(view.getjLabelLogin().getText());
        updateStudent.setModule(view.getjLabelModule().getText());
        updateStudent.setPassword(view.getjLabelPassword().getText());
        updateStudent.setPhone(view.getjLabelPhone().getText());
        updateStudent.setRegistration(view.getjLabelRegistration().getText());
        updateStudent.setSchool(view.getjLabelSchool().getText());
        updateStudent.setShift(view.getjLabelShift().getText());
        

        if (studentDao.update(updateStudent)) {

            Dialoger.message(view, " Os dados do Aluno " + updateStudent.getName() + " foram atualizado com sucesso"
                    + "\n"
                    + "\n Atualize a Pagina");
        }

        loadAllStudents();
    }

    public void loadAllStudents() {
        loadStudents((ArrayList<Student>) studentDao.selectAll());
    }

    public void delete() {

        Student student = ListOfStudents.getSelectedStudentPane().getStudent();

        if (Dialoger.confirm(view, " Voce realmente deseja deletar o Aluno " + student.getName() + " ?"
                + "\n"
                + "\n Os dados nao poderao ser recuperados")) {

            studentDao.delet(student);

            loadAllStudents();
        }
    }
}
