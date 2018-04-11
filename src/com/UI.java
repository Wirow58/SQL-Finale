package com;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.*;

public class UI extends JFrame implements WindowListener {
    private Connection conn = null;
    private Statement stmt = null;
    String serverName = "192.168.0.17";
    String mydatabase = "uganda";
    String url = "jdbc:mysql://" + serverName + "/" + mydatabase;

    String username = "JAVA";
    String password = "papanurgle";
    private boolean running = true;


    UI() {
        JPanel mainPanel = new JPanel();
        mainPanel.setPreferredSize(new Dimension(600, 400));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        mainPanel.setLayout(new FlowLayout());
        this.getContentPane().add(mainPanel);
        addWindowListener(this);


        JButton testButton = new JButton("Test Select");
        testButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String sql = "SELECT Name, Surname, ModelName FROM uganda.weaponview";
                try {
                    ResultSet rs = stmt.executeQuery(sql);

                    while (rs.next()) {
                        //Retrieve by column name
                        String name = rs.getString("Name");
                        String surname = rs.getString("Surname");
                        String modelName = rs.getString("ModelName");

                        //Display values
                        System.out.print("Name: " + name);
                        System.out.print(", Surname: " + surname);
                        System.out.println(", Model Name: " + modelName);
                    }
                    rs.close();
                } catch (SQLException se) {
                    System.out.println("Select failure ...");
                    se.printStackTrace();
                }
            }

        });
        mainPanel.add(testButton);



        JLabel idDelete = new JLabel( "ID:" );
        JLabel tableDelete = new JLabel( "Table:" );
        JTextField idDeleteTextField = new JTextField();
        String[] tableDeleteNamesStrings = { "Person","Equipment" };

        JComboBox tableDeleteList = new JComboBox(tableDeleteNamesStrings);
        JButton okDeleteButton = new JButton("OK");
        okDeleteButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                System.out.println("OK, Delete");
                String id = idDeleteTextField.getText();
                String table = (String)tableDeleteList.getSelectedItem();
                String tableNameToDelete;
                switch (table) {
                    case "Person":
                        tableNameToDelete = "uganda.person";
                    case "Equipment":
                        tableNameToDelete = "uganda.equipment";
                }
                //DatabaseLibrary.DeleteRecord(conn,stmt,tableNameToDelete,Integer.parseInt(id));
            }

        });

        JPanel deletePanel = new JPanel();
        deletePanel.setBorder(BorderFactory.createTitledBorder("Delete record"));
        deletePanel.setPreferredSize(new Dimension(300, 120));
        GroupLayout deleteLayout = new GroupLayout(deletePanel);
        deleteLayout.setAutoCreateGaps(true);
        deleteLayout.setAutoCreateContainerGaps(true);
        GroupLayout.SequentialGroup deleteHGroup = deleteLayout.createSequentialGroup();
        deleteHGroup.addGroup(deleteLayout.createParallelGroup().
                addComponent(idDelete).addComponent(tableDelete).addComponent(okDeleteButton));
        deleteHGroup.addGroup(deleteLayout.createParallelGroup().
                addComponent(idDeleteTextField).addComponent(tableDeleteList));
        deleteLayout.setHorizontalGroup(deleteHGroup);

        GroupLayout.SequentialGroup deleteVGroup = deleteLayout.createSequentialGroup();
        deleteVGroup.addGroup(deleteLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).
                addComponent(idDelete).addComponent(idDeleteTextField));
        deleteVGroup.addGroup(deleteLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).
                addComponent(tableDelete).addComponent(tableDeleteList));
        deleteVGroup.addGroup(deleteLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).
                addComponent(okDeleteButton));
        deleteLayout.setVerticalGroup(deleteVGroup);
        deletePanel.setLayout(deleteLayout);
        mainPanel.add(deletePanel);








        JLabel tableAddLabel = new JLabel( "Table name:" );
        JLabel firstAddLabel = new JLabel( "Kills:" );
        JLabel secondAddLabel = new JLabel( "Rank:" );
        JLabel thirdAddLabel = new JLabel( "Supervising Unit ID:" );
        JLabel fourthAddLabel = new JLabel( "Supervising Soldier ID:" );
        JTextField firstAddTextField = new JTextField();
        JTextField secondAddTextField = new JTextField();
        JTextField thirdAddTextField = new JTextField();
        JTextField fourthAddTextField = new JTextField();
        String[] tableNamesStrings = {"uganda.soldier", "uganda.person","uganda.medic", "uganda.marksman", "uganda.tanker", "uganda.engineer",
                "uganda.weapon", "uganda.equipment", "uganda.vehicle", "uganda.commander", "uganda.`organisation unit`"};

        JComboBox tableNamesAddList = new JComboBox(tableNamesStrings);
        tableNamesAddList.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String value = (String)tableNamesAddList.getSelectedItem();
                firstAddTextField.setText("");
                secondAddTextField.setText("");
                thirdAddTextField.setText("");
                fourthAddTextField.setText("");
                System.out.println(value);
                switch (value) {
                    case "uganda.person":
                        firstAddLabel.setText("Name: ");secondAddLabel.setText("Surname: ");
                        thirdAddLabel.setText("Height: ");fourthAddLabel.setText("Weight: ");
                        firstAddLabel.setVisible(true);firstAddTextField.setVisible(true);
                        secondAddLabel.setVisible(true);secondAddTextField.setVisible(true);
                        thirdAddLabel.setVisible(true);thirdAddTextField.setVisible(true);
                        fourthAddLabel.setVisible(true);fourthAddTextField.setVisible(true);

                        break;
                    case "uganda.soldier":
                        firstAddLabel.setText("Kills: ");secondAddLabel.setText("Rank: ");
                        thirdAddLabel.setText("SupervisingUnit_ID: ");fourthAddLabel.setText("SupervisingSoldier_ID: ");
                        firstAddLabel.setVisible(true);firstAddTextField.setVisible(true);
                        secondAddLabel.setVisible(true);secondAddTextField.setVisible(true);
                        thirdAddLabel.setVisible(true);thirdAddTextField.setVisible(true);
                        fourthAddLabel.setVisible(true);fourthAddTextField.setVisible(true);

                        break;
                    case "uganda.medic":
                        firstAddLabel.setText("Revives: ");
                        firstAddLabel.setVisible(true);firstAddTextField.setVisible(true);
                        secondAddLabel.setVisible(false);secondAddTextField.setVisible(false);
                        thirdAddLabel.setVisible(false);thirdAddTextField.setVisible(false);
                        fourthAddLabel.setVisible(false);fourthAddTextField.setVisible(false);
                        break;
                    case "uganda.engineer":
                        firstAddLabel.setText("Favourite energy drink: ");secondAddLabel.setText("Engineer Type: ");
                        firstAddLabel.setVisible(true);firstAddTextField.setVisible(true);
                        secondAddLabel.setVisible(true);secondAddTextField.setVisible(true);
                        thirdAddLabel.setVisible(false);thirdAddTextField.setVisible(false);
                        fourthAddLabel.setVisible(false);fourthAddTextField.setVisible(false);
                        break;
                    case "uganda.tanker":
                        firstAddLabel.setText("Position: ");
                        firstAddLabel.setVisible(true);firstAddTextField.setVisible(true);
                        secondAddLabel.setVisible(false);secondAddTextField.setVisible(false);
                        thirdAddLabel.setVisible(false);thirdAddTextField.setVisible(false);
                        fourthAddLabel.setVisible(false);fourthAddTextField.setVisible(false);
                        break;
                    case "uganda.marksman":
                        firstAddLabel.setText("HeadshotPercent: ");
                        firstAddLabel.setVisible(true);firstAddTextField.setVisible(true);
                        secondAddLabel.setVisible(false);secondAddTextField.setVisible(false);
                        thirdAddLabel.setVisible(false);thirdAddTextField.setVisible(false);
                        fourthAddLabel.setVisible(false);fourthAddTextField.setVisible(false);
                        break;
                    case "uganda.equipment":
                        firstAddLabel.setText("Type: ");secondAddLabel.setText("ProductionDate: ");
                        thirdAddLabel.setText("Owner_ID: ");
                        firstAddLabel.setVisible(true);firstAddTextField.setVisible(true);
                        secondAddLabel.setVisible(true);secondAddTextField.setVisible(true);
                        thirdAddLabel.setVisible(true);thirdAddTextField.setVisible(true);
                        fourthAddLabel.setVisible(false);fourthAddTextField.setVisible(false);
                        break;
                    case "uganda.vehicle":
                        firstAddLabel.setText("Type of fuel: ");secondAddLabel.setText("Number of seats: ");
                        thirdAddLabel.setText("ModelName: ");
                        firstAddLabel.setVisible(true);firstAddTextField.setVisible(true);
                        secondAddLabel.setVisible(true);secondAddTextField.setVisible(true);
                        thirdAddLabel.setVisible(true);thirdAddTextField.setVisible(true);
                        fourthAddLabel.setVisible(false);fourthAddTextField.setVisible(false);
                        break;
                    case "uganda.weapon":
                        firstAddLabel.setText("Caliber: ");secondAddLabel.setText("Magazine Capacity: ");
                        thirdAddLabel.setText("Model Name: ");
                        firstAddLabel.setVisible(true);firstAddTextField.setVisible(true);
                        secondAddLabel.setVisible(true);secondAddTextField.setVisible(true);
                        thirdAddLabel.setVisible(true);thirdAddTextField.setVisible(true);
                        fourthAddLabel.setVisible(false);fourthAddTextField.setVisible(false);
                        break;
                    case "uganda.commander":
                        firstAddLabel.setText("Supervised Unit ID: ");
                        firstAddLabel.setVisible(true);firstAddTextField.setVisible(true);
                        secondAddLabel.setVisible(false);secondAddTextField.setVisible(false);
                        thirdAddLabel.setVisible(false);thirdAddTextField.setVisible(false);
                        fourthAddLabel.setVisible(false);fourthAddTextField.setVisible(false);
                        break;
                    case "uganda.`organisation unit`":
                        firstAddLabel.setText("Name: ");secondAddLabel.setText("Type: ");
                        thirdAddLabel.setText("Supervisor ID: ");
                        firstAddLabel.setVisible(true);firstAddTextField.setVisible(true);
                        secondAddLabel.setVisible(true);secondAddTextField.setVisible(true);
                        thirdAddLabel.setVisible(true);thirdAddTextField.setVisible(true);
                        fourthAddLabel.setVisible(false);fourthAddTextField.setVisible(false);
                        break;
                }
            }

        });

        JButton okAddButton = new JButton("OK");
        okAddButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                //DatabaseLibrary.DeleteRecord(conn,stmt,(String)tableDeleteList.getSelectedItem(),Integer.parseInt(idDeleteTextField.getText()));
                System.out.println("OK, Add");
                String value = (String)tableNamesAddList.getSelectedItem();
                System.out.println(value);
            }

        });

        JPanel addPanel = new JPanel();
        addPanel.setBorder(BorderFactory.createTitledBorder("Add record"));
        addPanel.setPreferredSize(new Dimension(350, 200));
        GroupLayout addLayout = new GroupLayout(addPanel);
        addLayout.setAutoCreateGaps(true);
        addLayout.setAutoCreateContainerGaps(true);

        GroupLayout.SequentialGroup addHGroup = addLayout.createSequentialGroup();
        addHGroup.addGroup(addLayout.createParallelGroup().
                addComponent(tableAddLabel).addComponent(firstAddLabel).addComponent(secondAddLabel).addComponent(thirdAddLabel).addComponent(fourthAddLabel).addComponent(okAddButton));
        addHGroup.addGroup(addLayout.createParallelGroup().
                addComponent(tableNamesAddList).addComponent(firstAddTextField).addComponent(secondAddTextField).addComponent(thirdAddTextField).addComponent(fourthAddTextField));
        addLayout.setHorizontalGroup(addHGroup);

        GroupLayout.SequentialGroup addVGroup = addLayout.createSequentialGroup();
        addVGroup.addGroup(addLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).
                addComponent(tableAddLabel).addComponent(tableNamesAddList));
        addVGroup.addGroup(addLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).
                addComponent(firstAddLabel).addComponent(firstAddTextField));
        addVGroup.addGroup(addLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).
                addComponent(secondAddLabel).addComponent(secondAddTextField));
        addVGroup.addGroup(addLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).
                addComponent(thirdAddLabel).addComponent(thirdAddTextField));
        addVGroup.addGroup(addLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).
                addComponent(fourthAddLabel).addComponent(fourthAddTextField));
        addVGroup.addGroup(addLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).
                addComponent(okAddButton));


        addLayout.setVerticalGroup(addVGroup);
        addPanel.setLayout(addLayout);
        mainPanel.add(addPanel);

        this.setTitle("Uganda Client App");
        this.pack();

        try {
            conn = DriverManager.getConnection(url, username, password);
            stmt = conn.createStatement();
        } catch (SQLException se) {
            dispose();
            System.exit(0);

            try {
                if (stmt != null)
                    stmt.close();
                if (conn != null)
                    conn.close();
            } catch (SQLException see) {

            }
        }
    }
    public void windowClosing(WindowEvent e) {
        running = false;
        System.out.println("Switching running");
    }

    public void windowOpened(WindowEvent e) {}
    public void windowActivated(WindowEvent e) {}
    public void windowIconified(WindowEvent e) {}
    public void windowDeiconified(WindowEvent e) {}
    public void windowDeactivated(WindowEvent e) {}
    public void windowClosed(WindowEvent e) {}

    public boolean getrunning(){
        return running;
    }

}
