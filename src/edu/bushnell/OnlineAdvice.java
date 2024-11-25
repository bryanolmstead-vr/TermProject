package edu.bushnell;

import java.awt.Component;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextPane;

public class OnlineAdvice {
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
        titleBox.add(GUI.text("Online Advice", 400, 30, 26, Color.WHITE, "center"));
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

        // create advice type combobox
        Box adviceTypeBox = Box.createHorizontalBox();
        adviceTypeBox.setAlignmentX(Component.LEFT_ALIGNMENT);
        adviceTypeBox.setAlignmentY(Component.TOP_ALIGNMENT);
        JLabel adviceTypeLabel = GUI.text("What is troubling you?", 250, 30, 20, Color.WHITE, "left");
        adviceTypeBox.add(adviceTypeLabel);
        adviceTypeBox.add(Box.createRigidArea(new Dimension(20,0)));
        String[] adviceTypes = {"Anger", "Stress", "Relationship", "Depression"};
        JComboBox<String> adviceType = new JComboBox<>(adviceTypes); 
        GUI.setDimension(adviceType, 200, 30);            
        adviceType.setFont(new Font("Sans-Serif", Font.BOLD, 20));
        adviceType.setAlignmentX(Component.CENTER_ALIGNMENT);     
        adviceTypeBox.add(adviceType);
        entryBox.add(adviceTypeBox);
        entryBox.add(Box.createRigidArea(new Dimension(0,40)));

        // add radio buttons to define severity
        JRadioButton mildButton     = new JRadioButton("Mild");
        JRadioButton moderateButton = new JRadioButton("Moderate");
        JRadioButton severeButton   = new JRadioButton("Severe");
        ButtonGroup  severityGroup  = new ButtonGroup();
        severityGroup.add(mildButton);
        severityGroup.add(moderateButton);
        severityGroup.add(severeButton);
        mildButton.setSelected(true);
        mildButton.setFont(new Font("Sans-Serif", Font.BOLD, 20));
        moderateButton.setFont(new Font("Sans-Serif", Font.BOLD, 20));
        severeButton.setFont(new Font("Sans-Serif", Font.BOLD, 20));
        JLabel severityLabel = GUI.text("How severe is your problem?", 350, 30, 20, Color.WHITE, "left");
        entryBox.add(severityLabel);
        entryBox.add(mildButton);
        entryBox.add(moderateButton);
        entryBox.add(severeButton);
        entryBox.add(Box.createRigidArea(new Dimension(0,40)));

        // create advice button
        JButton adviceButton = GUI.button("Provide Advice", 300, 50, 20);
        adviceButton.setAlignmentX(Component.LEFT_ALIGNMENT);
        entryBox.add(adviceButton);
        entryBox.add(Box.createRigidArea(new Dimension(0,40)));

        // create advice
        JTextPane textPane = new JTextPane();
        textPane.setFont(new Font("Sans-Serif", Font.ITALIC, 20));
        textPane.setAlignmentX(Component.LEFT_ALIGNMENT);
        GUI.setDimension(textPane, 800, 200);
        textPane.setText("");
        entryBox.add(textPane);

        middleBox.add(entryBox);
        panel.add(middleBox);
        panel.setVisible(true);
        
        // advice by topic
        String[] angerAdvice = { "Everyone experiences anger from time to time. Counting to 10 can help you calm down.", 
                                 "Spend time with friends. Go for a walk. Try to think the best of the situation.", 
                                 "Make an appointment with us before you do something you might regret."};
        String[] stressAdvice = { "Get some fresh air. Do something different. Enjoy some time with friends.", 
                                  "Most likely, what is stressing you is temporary. Think about something fun you are " +
                                  "looking forward to after the stressful time is over. Chocolate can be helpful to " +
                                  "improve your mood.", 
                                  "Consider making an appointment with us. We have some good ideas about how to combat stress."};
        String[] relationshipAdvice = { "Nobody is perfect. In any relationship there will be some disappointment.", 
                                        "Think the best of the person you are involved with. Be patient. Forgive.", 
                                        "While there are ups and downs in every relationship, consider making an appointment " +
                                        "with us. We can help you work through this difficult time."};
        String[] depressionAdvice = { "Everybody gets down sometimes. Find a friend to talk to. Take a walk. Enjoy nature.", 
                                      "God is here for you. Take a moment to pray and pour out your heart to Him.", 
                                      "While we all go through ups and downs, perhaps you should consider making an appointment " +
                                      "with us. We can help you get the treatment you need to be yourself again."};

        // advice button listener
        adviceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String adviceTypeStr = String.valueOf(adviceType.getSelectedItem());
                String adviceGiven = "";
                // set serverity: 0=mild, 1=moderate, 2=severe as index into string array
                int severity = 0;
                if (moderateButton.isSelected()) {
                    severity = 1;
                }
                if (severeButton.isSelected()) {
                    severity = 2;
                }

                if (adviceTypeStr == "Anger") {
                    adviceGiven = angerAdvice[severity];
                }
                if (adviceTypeStr == "Stress") {
                    adviceGiven = stressAdvice[severity];
                }
                if (adviceTypeStr == "Relationship") {  
                    adviceGiven = relationshipAdvice[severity];
                }
                if (adviceTypeStr == "Depression") {
                    adviceGiven = depressionAdvice[severity];
                }
                textPane.setText(adviceGiven);
            }
        });

        return panel;   
    }
}

/*
JPanel panel = new JPanel();
panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
panel.setPreferredSize(new Dimension(300, 450));
panel.setMaximumSize(new Dimension(300, 450));
panel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Create an array of strings to display as JLabels
        String[] topic = new String[4];
        topic[0] = "anger";
        topic[1] = "stress";
        topic[2] = "relationship";
        topic[3] = "depression";
        for (int i=0; i<topic.length; i++) {
            JLabel topicLabel = new JLabel(topic[i]);
            topicLabel.setFont(new Font("Sans-Serif", Font.BOLD, 18));
            topicLabel.setForeground(Color.WHITE);
            topicLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            panel.add(topicLabel);
        }

        frame.add(panel); 
        frame.pack(); 
        frame.setVisible(true);
*/
