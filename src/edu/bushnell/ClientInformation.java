package edu.bushnell;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.plaf.metal.MetalCheckBoxIcon;

public class ClientInformation {
    public static JPanel makeGUI() {
        // create panel
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // set background color
        String bushnellBlueHashCode = "#011E40";
        Color bushnellBlue = Color.decode(bushnellBlueHashCode);
        panel.setBackground(bushnellBlue); 

        // create title
        panel.add(Box.createRigidArea(new Dimension(0,20)));
        Box titleBox = Box.createVerticalBox();
        titleBox.setAlignmentX(Component.CENTER_ALIGNMENT);
        titleBox.setAlignmentY(Component.TOP_ALIGNMENT);
        titleBox.add(GUI.text("Client Information", 400, 30, 26, Color.WHITE, "center"));
        titleBox.add(Box.createRigidArea(new Dimension(0,50)));
        panel.add(titleBox);

        // create middle box for entries
        Box middleBox = Box.createHorizontalBox();
        middleBox.setMaximumSize(new Dimension(1000, 450));
        middleBox.setAlignmentX(Component.CENTER_ALIGNMENT);
        middleBox.setAlignmentY(Component.TOP_ALIGNMENT);
        Box entryBox = Box.createVerticalBox();
        entryBox.setAlignmentX(Component.LEFT_ALIGNMENT);
        entryBox.setAlignmentY(Component.TOP_ALIGNMENT);

        // date of birth field
        Box birthFormatBox = Box.createHorizontalBox();
        birthFormatBox.setAlignmentX(Component.LEFT_ALIGNMENT);
        birthFormatBox.setAlignmentY(Component.TOP_ALIGNMENT);
        JLabel dateFormatLabel = GUI.text("MM/DD/YYYY", 200, 30, 20, Color.WHITE, "left");
        birthFormatBox.add(Box.createRigidArea(new Dimension(220,0)));
        birthFormatBox.add(dateFormatLabel);
        entryBox.add(birthFormatBox);
        Box birthBox = Box.createHorizontalBox();
        birthBox.setAlignmentX(Component.LEFT_ALIGNMENT);
        birthBox.setAlignmentY(Component.TOP_ALIGNMENT);
        JLabel birthDateLabel = GUI.text("Date of Birth:", 200, 30, 20, Color.WHITE, "left");
        birthBox.add(birthDateLabel);
        birthBox.add(Box.createRigidArea(new Dimension(20,0)));
        JTextField birthDate = GUI.textField(15, 200, 30, 26);      
        birthBox.add(birthDate);
        entryBox.add(birthBox);
        entryBox.add(Box.createRigidArea(new Dimension(0,20)));

        // name fields
        Box nameBox = Box.createHorizontalBox();
        nameBox.setAlignmentX(Component.LEFT_ALIGNMENT);
        nameBox.setAlignmentY(Component.TOP_ALIGNMENT);
        JLabel firstNameLabel = GUI.text("First", 200, 30, 20, Color.WHITE, "left");
        JLabel lastNameLabel  = GUI.text("Last",  200, 30, 20, Color.WHITE, "left");
        nameBox.add(Box.createRigidArea(new Dimension(220,0)));
        nameBox.add(firstNameLabel);
        nameBox.add(Box.createRigidArea(new Dimension(20,0)));
        nameBox.add(lastNameLabel);
        entryBox.add(nameBox);
        Box firstLastNameBox = Box.createHorizontalBox();
        firstLastNameBox.setAlignmentX(Component.LEFT_ALIGNMENT);
        firstLastNameBox.setAlignmentY(Component.TOP_ALIGNMENT);
        JLabel nameLabel = GUI.text("Name:", 200, 30, 20, Color.WHITE, "left");
        firstLastNameBox.add(nameLabel);
        firstLastNameBox.add(Box.createRigidArea(new Dimension(20,0)));
        JTextField firstName = GUI.textField(15, 200, 30, 26);
        firstLastNameBox.add(firstName);
        firstLastNameBox.add(Box.createRigidArea(new Dimension(20,0)));
        JTextField lastName = GUI.textField(15, 200, 30, 26);
        firstLastNameBox.add(lastName);
        entryBox.add(firstLastNameBox);
        entryBox.add(Box.createRigidArea(new Dimension(0,20)));

        // create phone number
        Box phoneBox = Box.createHorizontalBox();
        phoneBox.setAlignmentX(Component.LEFT_ALIGNMENT);
        phoneBox.setAlignmentY(Component.TOP_ALIGNMENT);
        JLabel phoneNumberLabel = GUI.text("Phone Number:", 200, 30, 20, Color.WHITE, "left");
        phoneBox.add(phoneNumberLabel);
        phoneBox.add(Box.createRigidArea(new Dimension(20,0)));
        JTextField phoneNumber = GUI.textField(15, 200, 30, 26);      
        phoneBox.add(phoneNumber);
        entryBox.add(phoneBox);
        entryBox.add(Box.createRigidArea(new Dimension(0,20)));

        // create patient type combobox
        Box patientBox = Box.createHorizontalBox();
        patientBox.setAlignmentX(Component.LEFT_ALIGNMENT);
        patientBox.setAlignmentY(Component.TOP_ALIGNMENT);
        JLabel patientTypeLabel = GUI.text("Patient Type:", 200, 30, 20, Color.WHITE, "left");
        patientBox.add(patientTypeLabel);
        patientBox.add(Box.createRigidArea(new Dimension(20,0)));
        String[] patientTypes = {"Student", "Faculty", "Community"};
        JComboBox<String> patientType = new JComboBox<>(patientTypes); 
        GUI.setDimension(patientType, 200, 30);            
        patientType.setFont(new Font("Sans-Serif", Font.BOLD, 20));
        patientType.setAlignmentX(Component.CENTER_ALIGNMENT);     
        patientBox.add(patientType);
        entryBox.add(patientBox);
        entryBox.add(Box.createRigidArea(new Dimension(0,40)));

        // create fine print
        Box finePrintBox = Box.createVerticalBox();
        finePrintBox.setAlignmentX(Component.LEFT_ALIGNMENT);
        finePrintBox.setAlignmentY(Component.TOP_ALIGNMENT);
        finePrintBox.add(GUI.text("Bushnell Counseling Center Terms of Treatment", 
            600, 30, 20, Color.WHITE, "left"));
        finePrintBox.add(GUI.text("The Bushnell Counseling Center provides services to Students, Faculty, and the Community.", 
            600, 15, 12, Color.WHITE, "left"));
        finePrintBox.add(GUI.text("The patient accepts responsibility for evaluating any advice provided by this Center.", 
            600, 15, 12, Color.WHITE, "left"));
        finePrintBox.add(GUI.text("While the Bushnell Counseling Center respects all faiths, the patient understands", 
            600, 15, 12, Color.WHITE, "left"));
        finePrintBox.add(GUI.text("that the Bushnell Counseling Center adopts a Christian worldview for treatment.", 
            600, 15, 12, Color.WHITE, "left"));
        entryBox.add(finePrintBox);
        entryBox.add(Box.createRigidArea(new Dimension(0,20)));

        // create consent checkbox
        Box consentBox = Box.createHorizontalBox();
        consentBox.setAlignmentX(Component.LEFT_ALIGNMENT);
        consentBox.setAlignmentY(Component.TOP_ALIGNMENT);
        JCheckBox consentCheckBox = new JCheckBox("");
        consentCheckBox.setIcon(new MetalCheckBoxIcon() {
            protected int getControlSize() { return 20; }
        });
        consentBox.add(consentCheckBox);
        consentBox.add(Box.createRigidArea(new Dimension(20,0)));
        JLabel consentLabel = GUI.text("Check to consent to Bushnell Counseling Center Terms of Treatment", 
            700, 30, 20, Color.WHITE, "left");
        consentBox.add(consentLabel);
        entryBox.add(consentBox);
        middleBox.add(entryBox);
        panel.add(middleBox);

        // create action buttons
        Box actionBox = Box.createHorizontalBox();
        actionBox.setMaximumSize(new Dimension(1000, 200));
        actionBox.setAlignmentX(Component.CENTER_ALIGNMENT);
        actionBox.setAlignmentY(Component.TOP_ALIGNMENT);  
        JButton submitButton = GUI.button("Submit", 300, 50, 20);
        JButton clearButton = GUI.button("Clear", 300, 50, 20);      
        actionBox.add(submitButton);
        actionBox.add(Box.createRigidArea(new Dimension(50,0)));
        actionBox.add(clearButton);
        panel.add(actionBox);

        panel.setVisible(true);   
        
        // date of birth listener
        birthDate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // get raw text, eliminate everything but digits, forward slash, format to "##/##/####"
                String rawText = birthDate.getText();
                String filteredText = rawText.replaceAll("[^0-9/]","");
                String[] parts = filteredText.split("/");
                int month = 0;
                int day = 0;
                int year = 0;
                if (parts.length < 3) {
                    // full date not given - leave as zeros
                } else {
                    month = Integer.parseInt(parts[0]);
                    day   = Integer.parseInt(parts[1]);
                    year  = Integer.parseInt(parts[2]);
                }
                if (year < 100) {
                    // assume just last 2 digits were given
                    // if 2 digits are after current year, assume 19XX
                    // otherwise assume 20XX
                    if (year <= 24) {
                        year = year + 2000;
                    } else {
                        year = year + 1900;
                    }
                }
                String birthDateFormatted = String.format("%02d", month) + "/" + String.format("%02d", day) + 
                    "/" + String.format("%04d", year);
                birthDate.setText(birthDateFormatted);
                if (birthDate.getText().length() > 0) {
                    birthDate.setBackground(Color.WHITE);
                }
            }
        });

        // first name listener
        firstName.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // get raw text, eliminate all but letters
                String rawText = firstName.getText();
                String filteredText = rawText.replaceAll("[^a-z,A-Z]","");
                firstName.setText(filteredText);
                if (firstName.getText().length() > 0) {
                    firstName.setBackground(Color.WHITE);
                }
            }
        });

        // last name listener
        lastName.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // get raw text, eliminate all but letters
                String rawText = lastName.getText();
                String filteredText = rawText.replaceAll("[^a-z,A-Z]","");
                lastName.setText(filteredText);
                if (lastName.getText().length() > 0) {
                    lastName.setBackground(Color.WHITE);
                }
            }
        });

        // phone number listener
        phoneNumber.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // get raw text, eliminate everything but digits, add leading zeros to 10 digits, format to "(###) ###-####"
                String rawText = phoneNumber.getText();
                String digitsText = rawText.replaceAll("[^0-9]","");
                long   digitsVal;
                if (digitsText.length() == 0) {
                    digitsVal = 0;
                } else {
                    digitsVal  = Long.parseLong(digitsText);
                }
                if (digitsVal < 10000000L) {
                    digitsVal += 5410000000L;
                }
                String zeroPad = String.format("%010d", digitsVal);
                String phoneFormatted = "(" + zeroPad.substring(0,3) + ") " + zeroPad.substring(3,6) + "-" + zeroPad.substring(6,10);
                phoneNumber.setText(phoneFormatted);
                if (phoneNumber.getText().length() > 0) {
                    phoneNumber.setBackground(Color.WHITE);
                }
            }
        });

        // consent checkbox listener
        consentCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (consentCheckBox.isSelected() == true) {
                    consentCheckBox.setBackground(Color.WHITE);
                }
            }
        });

        // submit button listener
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // check to see if all fields are entered correctly
                if (birthDate.getText().length() == 0) {
                    birthDate.setBackground(Color.YELLOW);
                }
                if (firstName.getText().length() == 0) {
                    firstName.setBackground(Color.YELLOW);
                }
                if (lastName.getText().length() == 0) {
                    lastName.setBackground(Color.YELLOW);
                }
                if (phoneNumber.getText().length() == 0) {
                    phoneNumber.setBackground(Color.YELLOW);
                }
                if (consentCheckBox.isSelected() == false) {
                    consentCheckBox.setBackground(Color.YELLOW);
                }
            }
        });

        // clear button listener
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // clear all fields
                birthDate.setText("");
                firstName.setText("");
                lastName.setText("");
                phoneNumber.setText("");
                patientType.setSelectedIndex(0);
                consentCheckBox.setSelected(false);
            }
        });

        return panel;      
    }
}
