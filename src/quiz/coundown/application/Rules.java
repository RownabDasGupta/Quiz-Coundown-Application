
package quiz.coundown.application;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class Rules extends JFrame implements ActionListener {
    
    JButton start, back;
    
    static String name;
    int count, score;
    public Rules(String name, int count, int score) {
        this.name = name;
        this.count = count;
        this.score = score;
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        
        JLabel heading = new JLabel("Welcome  \'" + name + "\'  to  Quiz  Time");
        heading.setBounds(50, 40, 1050, 40);
        heading.setFont(new Font("Viner Hand ITC", Font.BOLD, 35));
        heading.setForeground(Color.RED);
        add(heading);
        
        
        JLabel heading2 = new JLabel("Rules: ");
        heading2.setBounds(50, 100, 1050, 40);
        heading2.setFont(new Font("Times New Roman", Font.BOLD, 35));
        heading2.setForeground(Color.BLUE);
        add(heading2);
        
        
        JLabel allRules = new JLabel();
        allRules.setBounds(50, 120, 600, 350);
        allRules.setFont(new Font("Tahoma", Font.PLAIN, 14));
        allRules.setForeground(Color.BLACK);
        allRules.setText(
            "<html>"+ 
                "1. All the questions are MCQ based questions." + "<br><br>" +
                "2. You have to answer all the 10 questions." + "<br><br>" +
                "3. Questions will be asked from Core Java." + "<br><br>" +
                "4. For each questions there will be 15 seconds." + "<br><br>" +
                "5. Click on 'Next' button to submit and move forward." + "<br><br>" +
                "6. Cick 'Next' before time ends, otherwise you will get 0 marks." + "<br><br>" +
                "7. After all questions Quiz will be auto submitted." + "<br><br>" +
                "8. Brace yourself and Good Luck" + "<br><br>" +
            "<html>"
        );
        add(allRules);
        
        
        start = new JButton("Start");
        start.setBounds(50, 460, 140, 40);
        start.setBackground(new Color(30, 144, 254));
        start.setForeground(Color.WHITE);
        start.addActionListener(this);
        add(start);
        
        back = new JButton("Back");
        back.setBounds(220, 460, 140, 40);
        back.setBackground(new Color(30, 144, 254));
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
        
        setSize(1100, 620);
        setLocation(140, 70);
        setVisible(true);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
         if(e.getSource() == start) {
//            String name = tfname.getText();
//            setVisible(false);
//            new Rules(name);
              setVisible(false);
              new Quiz(name, count, score);  
        }
        else if(e.getSource() == back) {
            setVisible(false);
            new Login(0, 0);
        }
    }
    
    public static void main(String args[]) {
        new Rules(name, 0, 0);
    }

    
}
