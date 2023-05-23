
package quiz.coundown.application;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class Score extends JFrame implements ActionListener {
    
    static String name;;
    public Score(String name, int score) {
//        this.name = name;
        
        setBounds(170, 130, 1000, 550);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        ImageIcon imageIconObj = new ImageIcon(ClassLoader.getSystemResource("icons/score.png"));
        Image iamgeScoreObj = imageIconObj.getImage().getScaledInstance(300, 250, Image.SCALE_DEFAULT);
        ImageIcon imageIconObj2 = new ImageIcon(iamgeScoreObj);
        JLabel image = new JLabel(imageIconObj2);
        image.setBounds(0, 170, 450,400);
        add(image);
        
        JLabel heading = new JLabel("Thank You  \'" + name + "\'  for playing Quiz Time!!!");
        heading.setBounds(50, 50, 900, 40);
        heading.setFont(new Font("Tohama", Font.BOLD, 30));
        heading.setForeground(Color.BLUE);
        add(heading);
        
        JLabel userScore = new JLabel("Your Score is - " + score);
        userScore.setBounds(480, 250, 400, 45);
        userScore.setFont(new Font("Tahoma", Font.BOLD, 35));
        userScore.setForeground(Color.RED);
        add(userScore);
        
        JButton submit = new JButton("Play Again");
        submit.setBounds(538, 350, 160, 40);
        submit.setBackground(new Color(30, 144, 255));
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Tahoma", Font.BOLD, 22));
//        submit.setEnabled(false);
        submit.addActionListener(this);
        add(submit);
        
       
        setVisible(true);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new Login(0, 0);
    }
    
    
    public static void main(String args[]) {
        new Score(name, 0);
    }

}
