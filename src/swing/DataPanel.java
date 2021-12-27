package swing;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import geneticAlgorithm.Data;
import model.Professor;
import model.Subject;

public class DataPanel extends JPanel {
    
    Data data;
    DefaultTableModel tableModel;
    DefaultTableModel tableModelS;
    JTable professorTable;
    JTable subjectTable;

    JPanel panel;
    JPanel buttonPanel;
    JPanel tablePanel;

    JButton addButton;
    JButton addButtonS;
    JButton deleteButton;
    JButton deleteButtonS;
    JButton generate;

    JTextField idText;
    JTextField nameText;
    JTextField titleText;
    JTextField timeText;

    JLabel idLabel;
    JLabel nameLabel;
    JLabel titleLabel;
    JLabel timeLabel;

    JTextField idSText;
    JTextField nameSText;
    JTextField etcsText;
    JTextField programSText;
    JTextField labText;
    JTextField statText;
    JTextField semesterText;

    JLabel idSLabel;
    JLabel nameSLabel;
    JLabel etcsLabel;
    JLabel programLabel;
    JLabel labLabel;
    JLabel statLabel;
    JLabel semesterLabel;

    
    String[] header = {"ID", "Full Name", "Job Title", "StartTime (in Minutes)"};
    String[] headerS = {"ID", "Name", "Etcs", "Program", "RequiresLab", "Status", "Semester"};
    private JButton updatePButton;
    private JButton updateSButton;

    public DataPanel(){
        data = new Data();
        initialise();
    }

    void initialise() {
        this.setBackground(Color.gray);
        this.setLayout(new BorderLayout());

        getTable();
        getTableS();
        textPanel();
        buttonPanel();
        tablePanell();

        JLabel label = new JLabel("Schedule Data", SwingConstants.CENTER);
        label.setFont(new Font("Georgia", Font.BOLD, 20));
        label.setForeground(Color.black);

        this.add(label, BorderLayout.NORTH);
        this.add(tablePanel, BorderLayout.CENTER);
        this.add(panel, BorderLayout.BEFORE_LINE_BEGINS);
        this.add(buttonPanel, BorderLayout.SOUTH);

    }

    void getTable() {
        tableModel = new DefaultTableModel(header, 0);
        professorTable = new JTable(tableModel);
        displayProfessorDetails();
        styleTable(professorTable);
    }

    void getTableS() {
        tableModelS = new DefaultTableModel(headerS, 0);
        subjectTable = new JTable(tableModelS);
        displaySubjectDetails();
        styleTableS(subjectTable);
    }

    void tablePanell() {
        tablePanel = new JPanel();
        //tablePanel.setBackground(Color.yellow);
        tablePanel.setSize(500, 400);
        professorTable.setPreferredScrollableViewportSize(new Dimension(380, 150));
        subjectTable.setPreferredScrollableViewportSize(new Dimension(380, 200));
        JScrollPane scroll= new JScrollPane(professorTable);
        JScrollPane scrollS= new JScrollPane(subjectTable);
        tablePanel.add(scroll);
        tablePanel.add(scrollS);
    }

    public void styleTable(JTable table) {

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        
        professorTable.getColumnModel().getColumn(0).setPreferredWidth(30);
        professorTable.getColumnModel().getColumn(1).setPreferredWidth(70);
        professorTable.getColumnModel().getColumn(2).setPreferredWidth(50);
        professorTable.getColumnModel().getColumn(3).setPreferredWidth(30);

        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        table.setFont(new Font("Georgia", Font.PLAIN, 10));

        for (int i = 0; i < header.length; i++) {
            professorTable.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
    }

    public void styleTableS(JTable table) {

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        
        subjectTable.getColumnModel().getColumn(0).setPreferredWidth(30);
        subjectTable.getColumnModel().getColumn(1).setPreferredWidth(90);
        subjectTable.getColumnModel().getColumn(2).setPreferredWidth(30);
        subjectTable.getColumnModel().getColumn(3).setPreferredWidth(70);
        subjectTable.getColumnModel().getColumn(4).setPreferredWidth(30);
        subjectTable.getColumnModel().getColumn(5).setPreferredWidth(20);
        subjectTable.getColumnModel().getColumn(6).setPreferredWidth(20);

        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        table.setFont(new Font("Georgia", Font.PLAIN, 10));

        for (int i = 0; i < headerS.length; i++) {
            subjectTable.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
    }


    void displayProfessorDetails() {
        tableModel.setRowCount(0);
        for (int i = 0; i < data.professors.size(); i++) {
            Object[] obj = {data.professors.get(i).getID(), data.professors.get(i).getName(), data.professors.get(i).getTitle(), data.professors.get(i).getPreferedStartTime()};
            tableModel.addRow(obj);
        }
    }

    void displaySubjectDetails() {
        for (int i = 0; i < data.subjects.size(); i++) {
            Object[] obj = {data.subjects.get(i).getID(), data.subjects.get(i).getName(), data.subjects.get(i).getEtcs(), data.subjects.get(i).getProgramN(), data.subjects.get(i).isLabRequired(), data.subjects.get(i).getStat(), data.subjects.get(i).getSemester()};
            tableModelS.addRow(obj);
        }
    }


    void buttonPanel() {
        buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.black);

        generate = new JButton("Schedule");
        generate.setPreferredSize(new Dimension(110, 25));
        generate.setFont(new Font("Georgia", Font.BOLD, 10 ));
        generate.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                new ScheduleFrame();
            }
        });

        updatePButton = new JButton("Update Prof. ");
        updatePButton.setPreferredSize(new Dimension(110, 25));
        updatePButton.setFont(new Font("Georgia", Font.BOLD, 10 ));
        updatePButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                data.professors.get(professorTable.getSelectedRow()).professorID = Integer.parseInt(idText.getText());
                data.professors.get(professorTable.getSelectedRow()).name = nameText.getText();
                data.professors.get(professorTable.getSelectedRow()).title = titleText.getText();
                data.professors.get(professorTable.getSelectedRow()).preferedStartTime = Integer.parseInt(timeText.getText());
                displayProfessorDetails();

            }
        });

        updateSButton = new JButton("Update Subj. ");
        updateSButton.setPreferredSize(new Dimension(110, 25));
        updateSButton.setFont(new Font("Georgia", Font.BOLD, 10 ));
        updateSButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                data.subjects.get(subjectTable.getSelectedRow()).subjectID= Integer.parseInt(idSText.getText());
                data.subjects.get(subjectTable.getSelectedRow()).name = nameSText.getText();
                data.subjects.get(subjectTable.getSelectedRow()).etcs = Integer.parseInt(etcsText.getText());
                data.subjects.get(subjectTable.getSelectedRow()).program = programSText.getText();
                data.subjects.get(subjectTable.getSelectedRow()).requiresLab = Boolean.parseBoolean(labText.getText());
                data.subjects.get(subjectTable.getSelectedRow()).stat = statText.getText();
                data.subjects.get(subjectTable.getSelectedRow()).semester = Integer.parseInt(semesterText.getText());
                displaySubjectDetails();

            }
        });
 
 
        buttonPanel.add(updatePButton);
        buttonPanel.add(updateSButton);
        buttonPanel.add(generate);
    }
    


    void textPanel() 
    {
        panel = new JPanel();
        //panel.setBackground(Color.PINK);
        panel.setSize(300,300);
        panel.setLayout(new GridLayout(14, 2));
       // panel.setBorder(new LineBorder(Color.black, 1));

        idLabel =    new JLabel("Professor ID:        ");
        idLabel.setFont(new Font("Georgia", Font.BOLD, 12 ));
        idText = new JTextField();
        idText.setPreferredSize(new Dimension(100, 25));

        nameLabel =  new JLabel("Professor Full Name: ");
        nameLabel.setFont(new Font("Georgia", Font.BOLD, 12 ));
        nameText = new JTextField();
        nameText.setPreferredSize( new Dimension( 100, 25 ) );

        titleLabel = new JLabel("Professor Title:     ");
        titleLabel.setFont(new Font("Georgia", Font.BOLD, 12 ));
        titleText = new JTextField();
        titleText.setPreferredSize( new Dimension( 100, 25 ) );

        timeLabel =  new JLabel("Prefered Start Time: ");
        timeLabel.setFont(new Font("Georgia", Font.BOLD, 12 ));
        timeText = new JTextField();
        timeText.setPreferredSize( new Dimension( 100, 25 ) );


        idSLabel =    new JLabel("Subject ID:        ");
        idSLabel.setFont(new Font("Georgia", Font.BOLD, 12 ));
        idSText = new JTextField();
        idSText.setPreferredSize(new Dimension(100, 25));

        nameSLabel =  new JLabel("Subject Name: ");
        nameSLabel.setFont(new Font("Georgia", Font.BOLD, 12 ));
        nameSText = new JTextField();
        nameSText.setPreferredSize( new Dimension( 100, 25 ) );

        etcsLabel =  new JLabel("Etcs: ");
        etcsLabel.setFont(new Font("Georgia", Font.BOLD, 12 ));
        etcsText = new JTextField();
        etcsText.setPreferredSize( new Dimension( 100, 25 ) );

        programLabel = new JLabel("Program Name:     ");
        programLabel.setFont(new Font("Georgia", Font.BOLD, 12 ));
        programSText = new JTextField();
        programSText.setPreferredSize( new Dimension( 100, 25 ) );

        labLabel =  new JLabel("Lab(True/False): ");
        labLabel.setFont(new Font("Georgia", Font.BOLD, 12 ));
        labText = new JTextField();
        labText.setPreferredSize( new Dimension( 100, 25 ) );

        statLabel =  new JLabel("Status: ");
        statLabel.setFont(new Font("Georgia", Font.BOLD, 12 ));
        statText = new JTextField();
        statText.setPreferredSize( new Dimension( 100, 25 ) );

        semesterLabel =  new JLabel("Semester: ");
        semesterLabel.setFont(new Font("Georgia", Font.BOLD, 12 ));
        semesterText = new JTextField();
        semesterText.setPreferredSize( new Dimension( 100, 25 ) );

        addButton = new JButton(" Add Professor ");
        addButton.setPreferredSize(new Dimension(80, 25));
        addButton.setFont(new Font("Georgia", Font.BOLD, 10 ));
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               int profID = Integer.parseInt(idText.getText());
               String profName = nameText.getText();
               String profTitle = titleText.getText();
               int startTime = Integer.parseInt(timeText.getText());
               data.professors.add(new Professor(profID, profName, profTitle, startTime));
               displayProfessorDetails();
               clearField();
            }
        });

        addButtonS = new JButton(" Add Subject ");
        addButtonS.setPreferredSize(new Dimension(95, 25));
        addButtonS.setFont(new Font("Georgia", Font.BOLD, 10 ));
        addButtonS.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               int subID = Integer.parseInt(idSText.getText());
               String name = nameSText.getText();
               int etcs = Integer.parseInt(etcsText.getText());
               String program = programSText.getText();
               Boolean lab = Boolean.parseBoolean(labText.getText());
               String status = statText.getText();
               int semester = Integer.parseInt(semesterText.getText());
               data.subjects.add(new Subject(subID, name, etcs, program, lab, status, semester));
               displaySubjectDetails();
               clearFieldS();
            }
        });

        deleteButton = new JButton("Delete");
        deleteButton.setPreferredSize(new Dimension(95, 25));
        deleteButton.setFont(new Font("Georgia", Font.BOLD, 10 ));
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                DefaultTableModel dfm = (DefaultTableModel) professorTable.getModel();
                if (professorTable.getSelectedRowCount() == 1) {
                    dfm.removeRow(professorTable.getSelectedRow());
                    professorTable.remove(professorTable.getSelectedRow());
                    JOptionPane.showMessageDialog(null, "Selected row deleted successfully");
                }
                else  if (professorTable.getSelectedRowCount() == 0) {
                    JOptionPane.showMessageDialog(null, "No row is selected");
                }
                else if (professorTable.getSelectedRowCount() != 1) {
                    JOptionPane.showMessageDialog(null, "Select a single row for deletion");
                }


            }
        });

        deleteButtonS = new JButton("Delete");
        deleteButtonS.setPreferredSize(new Dimension(95, 25));
        deleteButtonS.setFont(new Font("Georgia", Font.BOLD, 10 ));
        deleteButtonS.addActionListener(new ActionListener() {
           // int row = professorTable.getSelectedRow();
            @Override
            public void actionPerformed(ActionEvent e) {

                DefaultTableModel dfms = (DefaultTableModel) subjectTable.getModel();
                if (subjectTable.getSelectedRowCount() == 1) {
                    dfms.removeRow(subjectTable.getSelectedRow());
                    subjectTable.remove(subjectTable.getSelectedRow());
                    JOptionPane.showMessageDialog(null, "Selected row deleted successfully");
                }
                else  if (subjectTable.getSelectedRowCount() == 0) {
                    JOptionPane.showMessageDialog(null, "No row is selected");
                }
                else if (subjectTable.getSelectedRowCount() != 1) {
                    JOptionPane.showMessageDialog(null, "Select a single row for deletion");
                }

            }
        });


        panel.add(idLabel);
        panel.add(idText);
        panel.add(nameLabel);
        panel.add(nameText);
        panel.add(titleLabel);
        panel.add(titleText);
        panel.add(timeLabel);
        panel.add(timeText);
        panel.add(addButton);
        panel.add(deleteButton);

        
        panel.add(idSLabel);
        panel.add(idSText);
        panel.add(nameSLabel);
        panel.add(nameSText);
        panel.add(etcsLabel);
        panel.add(etcsText);
        panel.add(programLabel);
        panel.add(programSText);
        panel.add(labLabel);
        panel.add(labText);
        panel.add(statLabel);
        panel.add(statText);
        panel.add(semesterLabel);
        panel.add(semesterText);
        panel.add(addButtonS);
        panel.add(deleteButtonS);

        
    } 


    private void clearField() {
        idText.requestFocus();
        idText.setText("");
        nameText.setText("");
        titleText.setText("");
        timeText.setText("");
    }

    private void clearFieldS() {
        idSText.requestFocus();
        idSText.setText("");
        nameSText.setText("");
        programSText.setText("");
        labText.setText("");
        statText.setText("");
        semesterText.setText("");
    }
}
