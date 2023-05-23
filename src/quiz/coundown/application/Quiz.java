
package quiz.coundown.application;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;


public class Quiz extends JFrame implements ActionListener {
    
    String questions[][] = new String[10][5];
    String answers[][] = new String[10][2];
    String userAnswers[][] = new String[10][1];
    
    JLabel quesNo, ques;
    JRadioButton option1, option2, option3, option4;
    ButtonGroup groupOptions;
    JButton next, lifeLine, submit;
            
    public static int timer = 15;
    public static int ans_given = 0;
    public static int count = 0;
    public static int score = 0;
    
    static String name;
    public Quiz(String name, int count, int score) {
        this.name = name;
        this.count = count;
        this.score = score;
        
        setBounds(90, 20, 1150, 690);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        ImageIcon imageIconObj = new ImageIcon(ClassLoader.getSystemResource("icons/quiz.jpg"));
        JLabel image = new JLabel(imageIconObj);
        image.setBounds(0, 0, 1150, 320);
        add(image);
        
        quesNo = new JLabel();
        quesNo.setBounds(50, 355, 50, 30);
        quesNo.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        add(quesNo);
        
        ques = new JLabel();
        ques.setBounds(75, 355, 1000, 30);
        ques.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        add(ques);
        
        //Find below the Questions Array for 10 MCQ questions
        questions[0][0] = "Which is used to find and fix bugs in the Java programs.?";
        questions[0][1] = "JVM";
        questions[0][2] = "JDB";
        questions[0][3] = "JDK";
        questions[0][4] = "JRE";

        questions[1][0] = "What is the return type of the hashCode() method in the Object class?";
        questions[1][1] = "int";
        questions[1][2] = "Object";
        questions[1][3] = "long";
        questions[1][4] = "void";

        questions[2][0] = "Which package contains the Random class?";
        questions[2][1] = "java.util package";
        questions[2][2] = "java.lang package";
        questions[2][3] = "java.awt package";
        questions[2][4] = "java.io package";

        questions[3][0] = "An interface with no fields or methods is known as?";
        questions[3][1] = "Runnable Interface";
        questions[3][2] = "Abstract Interface";
        questions[3][3] = "Marker Interface";
        questions[3][4] = "CharSequence Interface";

        questions[4][0] = "In which memory a String is stored, when we create a string using new operator?";
        questions[4][1] = "Stack";
        questions[4][2] = "String memory";
        questions[4][3] = "Random storage space";
        questions[4][4] = "Heap memory";

        questions[5][0] = "Which of the following is a marker interface?";
        questions[5][1] = "Runnable interface";
        questions[5][2] = "Remote interface";
        questions[5][3] = "Readable interface";
        questions[5][4] = "Result interface";

        questions[6][0] = "Which keyword is used for accessing the features of a package?";
        questions[6][1] = "import";
        questions[6][2] = "package";
        questions[6][3] = "extends";
        questions[6][4] = "export";

        questions[7][0] = "In java, jar stands for?";
        questions[7][1] = "Java Archive Runner";
        questions[7][2] = "Java Archive";
        questions[7][3] = "Java Application Resource";
        questions[7][4] = "Java Application Runner";

        questions[8][0] = "Which of the following is a mutable class in java?";
        questions[8][1] = "java.lang.StringBuilder";
        questions[8][2] = "java.lang.Short";
        questions[8][3] = "java.lang.Byte";
        questions[8][4] = "java.lang.String";

        questions[9][0] = "Which of the following option leads to the portability and security of Java?";
        questions[9][1] = "Bytecode is executed by JVM";
        questions[9][2] = "The applet makes the Java code secure and portable";
        questions[9][3] = "Use of exception handling";
        questions[9][4] = "Dynamic binding between objects";

        
        //Find below the Answers Array of the above Questions	
        answers[0][1] = "JDB";
        answers[1][1] = "int";
        answers[2][1] = "java.util package";
        answers[3][1] = "Marker Interface";
        answers[4][1] = "Heap memory";
        answers[5][1] = "Remote interface";
        answers[6][1] = "import";
        answers[7][1] = "Java Archive";
        answers[8][1] = "java.lang.StringBuilder";
        answers[9][1] = "Bytecode is executed by JVM";
        
        
        option1 = new JRadioButton();
        option1.setBounds(70,420,850,30);
        option1.setBackground(Color.WHITE);
        option1.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(option1);   
        
        option2 = new JRadioButton();
        option2.setBounds(70,460,850,30);
        option2.setBackground(Color.WHITE);
        option2.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(option2);   
        
        option3 = new JRadioButton();
        option3.setBounds(70,500,850,30);
        option3.setBackground(Color.WHITE);
        option3.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(option3);   
        
        option4 = new JRadioButton();
        option4.setBounds(70,540,850,30);
        option4.setBackground(Color.WHITE);
        option4.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(option4);   
       
        groupOptions = new ButtonGroup();
        groupOptions.add(option1);
        groupOptions.add(option2);
        groupOptions.add(option3);
        groupOptions.add(option4);
        
        
        next = new JButton("Next");
        next.setBounds(920, 410, 170, 36);
        next.setBackground(new Color(30, 144, 255));
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Tahoma", Font.PLAIN, 21));
        next.addActionListener(this);
        add(next);
        
        lifeLine = new JButton("50-50 Lifeline");
        lifeLine.setBounds(920, 460, 170, 36);
        lifeLine.setBackground(new Color(30, 144, 255));
        lifeLine.setForeground(Color.WHITE);
        lifeLine.setFont(new Font("Tahoma", Font.PLAIN, 21));
        lifeLine.addActionListener(this);
        add(lifeLine);
        
        submit = new JButton("Submit");
        submit.setBounds(920, 510, 170, 36);
        submit.setBackground(new Color(30, 144, 255));
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Tahoma", Font.PLAIN, 21));
        submit.setEnabled(false);
        submit.addActionListener(this);
        add(submit);
        
        start(count);
        
        setVisible(true);
    }
    
    
    public void paint(Graphics g) {
        super.paint(g);
        String time = "Time Left: " + timer + " seconds"; //15 seconds
        
        g.setColor(Color.RED);
        g.setFont(new Font("Tahoma", Font.PLAIN, 21));
        
        if (timer > 0) {
            g.drawString(time, 920, 400);
        }
        else {
            g.drawString("Time's up!!!", 920, 400);
        }
        
        timer--;    //14
        
        try {
            Thread.sleep(1000);
            repaint();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        
        if(ans_given == 1) {
            ans_given = 0;
            timer = 15;
        }
        else if(timer < 0) {
            timer = 15;
            
            if(count == 0) {
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            
            if(count == 9) {    //submit case
                if(groupOptions.getSelection() == null) {
                    userAnswers[count][0] = ""; 
                }
                else {
                    userAnswers[count][0] = groupOptions.getSelection().getActionCommand();
                }
                
                for(int i = 0; i < userAnswers.length; i++) {
                    if(userAnswers[i][0].equals(answers[i][1]))
                        score += 10;
                }
                 
                setVisible(false);
                
                //call Score
                new Score(name, score);
            }
            else {      //next case
            
                option1.setEnabled(true);
                option2.setEnabled(true);
                option3.setEnabled(true);
                option4.setEnabled(true);

                if(groupOptions.getSelection() == null) {
                    userAnswers[count][0] = ""; 
                }
                else {
                    userAnswers[count][0] = groupOptions.getSelection().getActionCommand();
                }

                count++;    //from 0 -> 1 
                start(count);
            }
        }
            
    }
    
    public void start(int count) {
        quesNo.setText("" + (count + 1) + ". ");
        ques.setText(questions[count][0]);
        option1.setText(questions[count][1]);
        option1.setActionCommand(questions[count][1]);
        
        option2.setText(questions[count][2]);
        option2.setActionCommand(questions[count][2]);
        
        option3.setText(questions[count][3]);
        option3.setActionCommand(questions[count][3]);
        
        option4.setText(questions[count][4]);
        option4.setActionCommand(questions[count][4]);
        
        groupOptions.clearSelection();
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == next) {
            repaint();
            option1.setEnabled(true);
            option2.setEnabled(true);
            option3.setEnabled(true);
            option4.setEnabled(true);
            
            
            ans_given = 1;      //assume that if user click on 'Next' button means he submit his choice of ans
            if(groupOptions.getSelection() == null) {
                userAnswers[count][0] = ""; 
            }
            else {
                userAnswers[count][0] = groupOptions.getSelection().getActionCommand();
            }
            
            //at last question we have to disable 'Next' button and enable 'Submit' button
            if(count == 8) {    //8th index means 9th question
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            count++;
            start(count);
        }
        else if(e.getSource() == lifeLine) {
            if(count == 2 || count == 4 || count == 6 || count == 8 || count == 9) {
                option2.setEnabled(false);
                option3.setEnabled(false);
            }
            else {
                option1.setEnabled(false);
                option4.setEnabled(false);
            }
            lifeLine.setEnabled(false);
        }
        else {  //'submit' button
            ans_given = 1;
            if(groupOptions.getSelection() == null) {
                    userAnswers[count][0] = ""; 
                }
                else {
                    userAnswers[count][0] = groupOptions.getSelection().getActionCommand();
                }
                
                for(int i = 0; i < userAnswers.length; i++) {
                    if(userAnswers[i][0].equals(answers[i][1]))
                        score += 10;
                }
                 
                setVisible(false);
                
                //call Score
                new Score(name, score);
            
        }
    }
    
    
    public static void main(String args[]) {
        new Quiz(name, 0, 0);
    }

   
}
