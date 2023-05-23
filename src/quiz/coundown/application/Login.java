package quiz.coundown.application;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Login extends JFrame implements ActionListener {
    
    JButton rules, back;
    JTextField tfname;
    
    int count, score;
    public Login(int count, int score) {
        this.count = 0;
        this.score = 0;
        
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        ImageIcon imageIconObj = new ImageIcon(ClassLoader.getSystemResource("icons/login.jpeg"));
        JLabel image = new JLabel(imageIconObj);
        image.setBounds(0, 0, 500, 525);
        add(image);
        
        JLabel heading = new JLabel("Quiz  Time");
        heading.setBounds(640, 80, 300, 55);
        heading.setFont(new Font("Viner Hand ITC", Font.BOLD, 50));
        heading.setForeground(Color.BLUE);
        add(heading);
        
        JLabel name = new JLabel("Enter Your Name");
        name.setBounds(690, 170, 175, 20);
        name.setFont(new Font("Mongolian Baiti", Font.BOLD, 22));
        name.setForeground(Color.BLUE);
        add(name);
        
        tfname = new JTextField();
        tfname.setBounds(630, 200, 300, 30);
        tfname.setFont(new Font("Times New Roman", Font.BOLD, 22));
        add(tfname);
        
        rules = new JButton("Next");        //or "Rules"
        rules.setBounds(630, 260, 110, 35);
        rules.setBackground(new Color(30, 144, 254));
        rules.setForeground(Color.WHITE);
        rules.addActionListener(this);
        add(rules);
        
        back = new JButton("Back");
        back.setBounds(817, 260, 110, 35);
        back.setBackground(new Color(30, 144, 254));
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
        
        
        setSize(1100, 500);
        setLocation(170, 150);
        setVisible(true);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == rules) {
            String name = tfname.getText();
            setVisible(false);
            if(!name.isEmpty())
                new Rules(name, 0, 0);
            else
                new Rules("Guest User", 0, 0);
        }
        else if(e.getSource() == back) {
            setVisible(false);
        }
    }
    
    
    public static void main(String args[]) {
        new Login(0, 0); 
    }

    
}
