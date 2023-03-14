import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

//import java.time.*;

public class Game_Screen implements ActionListener,MouseListener {

    JFrame frame;
    JPanel North,Center,South,East,West;
    ImageIcon image;
    JLabel TurnLabel,ScoreX,ScoreO;
    JButton s1,s2,s3,s4,s5,s6,s7,s8,s9;
    JButton replay,reset,exit;

    String turn = "x";

    int X_Win_Count = 0;
    int O_Win_Count = 0;

    Game_Screen(){
        
        image = new ImageIcon("Tic.jfif");

        frame = new JFrame();

        frame.setTitle("TicTacToe");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setIconImage(image.getImage());
        frame.getContentPane().setBackground(Color.BLACK);
        frame.setLayout(new BorderLayout());
        frame.setSize(575,575);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        
        
        

        North = new JPanel();

        North.setBackground(Color.BLACK);
        North.setLayout(new  FlowLayout());
        North.setBorder(BorderFactory.createLineBorder(new Color(255,145,43),6));

        South = new JPanel();

        South.setBackground(Color.BLACK);
        South.setLayout(new FlowLayout());
        //South.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        South.setBorder(BorderFactory.createLineBorder(new Color(255,145,43),3));

        East = new JPanel();
        
        East.setBackground(Color.BLACK);
        East.setLayout(new FlowLayout());
        East.setBorder(BorderFactory.createLineBorder(new Color(255,145,43),3));

        West = new JPanel();
        
        West.setBackground(Color.BLACK);
        West.setLayout(new FlowLayout());
        West.setBorder(BorderFactory.createLineBorder(new Color(255,145,43),3));

        Center = new JPanel();
        
        Center.setBackground(Color.BLACK);
        Center.setLayout(new GridLayout(3,3));
        Center.setBorder(BorderFactory.createEmptyBorder(1,1,1,1));

        TurnLabel = new JLabel("Start!");

        TurnLabel.setForeground(new Color(255,145,43));
        TurnLabel.setFont(new Font("MV Boli",Font.BOLD,45));

        ScoreX = new JLabel("X : 0");

        ScoreX.setForeground(new Color(255,145,43));
        ScoreX.setFont(new Font("MV Boli",Font.BOLD,30));

        ScoreO = new JLabel("0 : O");

        ScoreO.setForeground(new Color(255,145,43));
        ScoreO.setFont(new Font("MV Boli",Font.BOLD,30));

        s1 = new JButton();

        s1.setBackground(Color.BLACK);
        s1.setBorder(BorderFactory.createLineBorder(new Color(255,145,43),3));
        s1.setForeground(new Color(255,145,43));
        s1.setFocusable(false);
        s1.setFont(new Font("MV Boli",Font.BOLD,80));

        s2 = new JButton();

        s2.setBackground(Color.BLACK);
        s2.setBorder(BorderFactory.createLineBorder(new Color(255,145,43),3));
        s2.setForeground(new Color(255,145,43));
        s2.setFocusable(false);
        s2.setFont(new Font("MV Boli",Font.BOLD,80));

        s3 = new JButton();

        s3.setBackground(Color.BLACK);
        s3.setBorder(BorderFactory.createLineBorder(new Color(255,145,43),3));
        s3.setForeground(new Color(255,145,43));
        s3.setFocusable(false);
        s3.setFont(new Font("MV Boli",Font.BOLD,80));

        s4 = new JButton();

        s4.setBackground(Color.BLACK);
        s4.setBorder(BorderFactory.createLineBorder(new Color(255,145,43),3));
        s4.setForeground(new Color(255,145,43));
        s4.setFocusable(false);
        s4.setFont(new Font("MV Boli",Font.BOLD,80));
        
        s5 = new JButton();

        s5.setBackground(Color.BLACK);
        s5.setBorder(BorderFactory.createLineBorder(new Color(255,145,43),3));
        s5.setForeground(new Color(255,145,43));
        s5.setFocusable(false);
        s5.setFont(new Font("MV Boli",Font.BOLD,80));

        s6 = new JButton();

        s6.setBackground(Color.BLACK);
        s6.setBorder(BorderFactory.createLineBorder(new Color(255,145,43),3));
        s6.setForeground(new Color(255,145,43));
        s6.setFocusable(false);
        s6.setFont(new Font("MV Boli",Font.BOLD,80));
        
        s7 = new JButton();

         s7.setBackground(Color.BLACK);
        s7.setBorder(BorderFactory.createLineBorder(new Color(255,145,43),3));
        s7.setForeground(new Color(255,145,43));
        s7.setFocusable(false);
        s7.setFont(new Font("MV Boli",Font.BOLD,80));

        s8 = new JButton();

        s8.setBackground(Color.BLACK);
        s8.setBorder(BorderFactory.createLineBorder(new Color(255,145,43),3));
        s8.setForeground(new Color(255,145,43));
        s8.setFocusable(false);
        s8.setFont(new Font("MV Boli",Font.BOLD,80));

        s9 = new JButton();

        s9.setBackground(Color.BLACK);
        s9.setBorder(BorderFactory.createLineBorder(new Color(255,145,43),3));
        s9.setForeground(new Color(255,145,43));
        s9.setFocusable(false);
        s9.setFont(new Font("MV Boli",Font.BOLD,80));

        replay = new JButton("     Replay     ");

        replay.setBackground(Color.BLACK);
        replay.setForeground(new Color(255,145,43));
        replay.setBorder(BorderFactory.createLineBorder(new Color(255,145,43),2));
        replay.setFocusable(false);
        replay.setFont(new Font("MV Boli",Font.BOLD,25));

        reset = new JButton("   Reset   ");

        reset.setBackground(Color.BLACK);
        reset.setForeground(new Color(255,145,43));
        reset.setBorder(BorderFactory.createLineBorder(new Color(255,145,43),2));
        reset.setFocusable(false);
        reset.setFont(new Font("MV Boli",Font.BOLD,25));

        exit = new JButton("    Exit    ");

        exit.setBackground(Color.BLACK);
        exit.setForeground(new Color(255,145,43));
        exit.setBorder(BorderFactory.createLineBorder(new Color(255,145,43),2));
        exit.setFocusable(false);
        exit.setFont(new Font("MV Boli",Font.BOLD,25));

        s1.addMouseListener(this);
        s2.addMouseListener(this);
        s3.addMouseListener(this);
        s4.addMouseListener(this);
        s5.addMouseListener(this);
        s6.addMouseListener(this);
        s7.addMouseListener(this);
        s8.addMouseListener(this);
        s9.addMouseListener(this);

        replay.addMouseListener(this);
        reset.addMouseListener(this);
        exit.addMouseListener(this);

        s1.addActionListener(this);
        s2.addActionListener(this);
        s3.addActionListener(this);
        s4.addActionListener(this);
        s5.addActionListener(this);
        s6.addActionListener(this);
        s7.addActionListener(this);
        s8.addActionListener(this);
        s9.addActionListener(this);

        replay.addActionListener(this);
        reset.addActionListener(this);
        exit.addActionListener(this);

        North.add(TurnLabel);

        Center.add(s1);
        Center.add(s2);
        Center.add(s3);
        Center.add(s4);
        Center.add(s5);
        Center.add(s6);
        Center.add(s7);
        Center.add(s8);
        Center.add(s9);

        West.add(ScoreX);
        East.add(ScoreO);


        South.add(reset);
        South.add(replay);
        South.add(exit);


        frame.add(North,BorderLayout.NORTH);
        frame.add(South,BorderLayout.SOUTH);
        frame.add(East,BorderLayout.EAST);
        frame.add(West,BorderLayout.WEST);
        frame.add(Center,BorderLayout.CENTER);

        frame.setVisible(true);

    }
    public void playSound(String soundName)
 {
   try 
   {
    AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(soundName).getAbsoluteFile( ));
    Clip clip = AudioSystem.getClip( );
    clip.open(audioInputStream);
    clip.start( );
   }
   catch(Exception ex)
   {
     System.out.println("Error with playing sound.");
     ex.printStackTrace( );
   }

 }
  public void XWins() throws InterruptedException{
    if((s1.getText()=="X" && s2.getText()=="X" && s3.getText()=="X")
       ||(s4.getText()=="X" && s5.getText()=="X" && s6.getText()=="X")
       ||(s7.getText()=="X" && s8.getText()=="X" && s9.getText()=="X")
       ||(s1.getText()=="X" && s4.getText()=="X" && s7.getText()=="X")
       ||(s2.getText()=="X" && s5.getText()=="X" && s8.getText()=="X")
       ||(s3.getText()=="X" && s6.getText()=="X" && s9.getText()=="X")
       ||(s1.getText()=="X" && s5.getText()=="X" && s9.getText()=="X")
       ||(s3.getText()=="X" && s5.getText()=="X" && s7.getText()=="X")){
        
        TurnLabel.setText("X Wins!");

        X_Win_Count++;

        ScoreX.setText("X : "+X_Win_Count);
        
        s1.setEnabled(false);
        s2.setEnabled(false);
        s3.setEnabled(false);
        s4.setEnabled(false);
        s5.setEnabled(false);
        s6.setEnabled(false);
        s7.setEnabled(false);
        s8.setEnabled(false);
        s9.setEnabled(false);


        
        
        //frame.dispose();

       

        /**s1.setText("");
        s2.setText("");
        s3.setText("");
        s4.setText("");
        s5.setText("");
        s6.setText("");
        s7.setText("");
        s8.setText("");
        s9.setText("");

        s1.setEnabled(true);
        s2.setEnabled(true);
        s3.setEnabled(true);
        s4.setEnabled(true);
        s5.setEnabled(true);
        s6.setEnabled(true);
        s7.setEnabled(true);
        s8.setEnabled(true);
        s9.setEnabled(true);**/

        //TurnLabel.setText("Start!");

       }
       else{
        if((s1.getText()!="")&&(s2.getText()!="")&&(s3.getText()!="")
          &&(s4.getText()!="")&&(s5.getText()!="")&&(s6.getText()!="")
          &&(s7.getText()!="")&&(s8.getText()!="")&&(s9.getText()!="")){
            TurnLabel.setText("It's A Draw");

        }
       }
      }

  public void OWins() throws InterruptedException{
    if((s1.getText()=="O" && s2.getText()=="O" && s3.getText()=="O")
        ||(s4.getText()=="O" && s5.getText()=="O" && s6.getText()=="O")
        ||(s7.getText()=="O" && s8.getText()=="O" && s9.getText()=="O")
        ||(s1.getText()=="O" && s4.getText()=="O" && s7.getText()=="O")
        ||(s2.getText()=="O" && s5.getText()=="O" && s8.getText()=="O")
        ||(s3.getText()=="O" && s6.getText()=="O" && s9.getText()=="O")
        ||(s1.getText()=="O" && s5.getText()=="O" && s9.getText()=="O")
        ||(s3.getText()=="O" && s5.getText()=="O" && s7.getText()=="O")){
            
            TurnLabel.setText("O Wins!");

            O_Win_Count++;

            ScoreO.setText(O_Win_Count+" : O");

            turn = "x";

            s1.setEnabled(false);
            s2.setEnabled(false);
            s3.setEnabled(false);
            s4.setEnabled(false);
            s5.setEnabled(false);
            s6.setEnabled(false);
            s7.setEnabled(false);
            s8.setEnabled(false);
            s9.setEnabled(false);

            

            
            //frame.dispose();

            
            
    
            
    
            /**s1.setText("");
            s2.setText("");
            s3.setText("");
            s4.setText("");
            s5.setText("");
            s6.setText("");
            s7.setText("");
            s8.setText("");
            s9.setText("");
    
            s1.setEnabled(true);
            s2.setEnabled(true);
            s3.setEnabled(true);
            s4.setEnabled(true);
            s5.setEnabled(true);
            s6.setEnabled(true);
            s7.setEnabled(true);
            s8.setEnabled(true);
            s9.setEnabled(true);**/
    
            //TurnLabel.setText("Start!");
    
    
           }
           else{
            if((s1.getText()!="")&&(s2.getText()!="")&&(s3.getText()!="")
              &&(s4.getText()!="")&&(s5.getText()!="")&&(s6.getText()!="")
              &&(s7.getText()!="")&&(s8.getText()!="")&&(s9.getText()!="")){
                TurnLabel.setText("It's A Draw!");
    
            }
           }
       
    
  }
 

    @Override
    public void actionPerformed(ActionEvent arg0) {
        if(turn == "x"){

          String TurnText = "O's Turn";

        
          if(arg0.getSource()==s1){
            s1.setText("X");
            s1.setEnabled(false);
            s1.setForeground(Color.WHITE);
            
            

            turn = "o";

            TurnLabel.setText(TurnText);

            try {
              XWins();
              OWins();
            } catch (InterruptedException e) {
              e.printStackTrace();
            }

          }

          if(arg0.getSource()==s2){
            s2.setText("X");
            s2.setEnabled(false);
            s2.setForeground(Color.WHITE);

            turn = "o";

            TurnLabel.setText(TurnText);

            try {
              XWins();
              OWins();
            } catch (InterruptedException e) {
              e.printStackTrace();
            }

          }

          if(arg0.getSource()==s3){
            s3.setText("X");
            s3.setEnabled(false);
            s3.setForeground(Color.WHITE);

            turn = "o";

            TurnLabel.setText(TurnText);

            try {
              XWins();
              OWins();
            } catch (InterruptedException e) {
              e.printStackTrace();
            }

          }

          if(arg0.getSource()==s4){
            s4.setText("X");
            s4.setEnabled(false);
            s4.setForeground(Color.WHITE);

            turn = "o";

            TurnLabel.setText(TurnText);

            try {
              XWins();
              OWins();
            } catch (InterruptedException e) {
              e.printStackTrace();
            }

          }

          if(arg0.getSource()==s5){
            s5.setText("X");
            s5.setEnabled(false);
            s5.setForeground(Color.WHITE);

            turn = "o";

            TurnLabel.setText(TurnText);

            try {
              XWins();
              OWins();
            } catch (InterruptedException e) {
              e.printStackTrace();
            }

          }

          if(arg0.getSource()==s6){
            s6.setText("X");
            s6.setEnabled(false);
            s6.setForeground(Color.WHITE);

            turn = "o";

            TurnLabel.setText(TurnText);

            try {
              XWins();
              OWins();
            } catch (InterruptedException e) {
              e.printStackTrace();
            }

          }
          
          if(arg0.getSource()==s7){
            s7.setText("X");
            s7.setEnabled(false);
            s7.setForeground(Color.WHITE);

            turn = "o";

            TurnLabel.setText(TurnText);

            try {
              XWins();
              OWins();
            } catch (InterruptedException e) {
              e.printStackTrace();
            }

          }

          if(arg0.getSource()==s8){
            s8.setText("X");
            s8.setEnabled(false);
            s8.setForeground(Color.WHITE);

            turn = "o";

            TurnLabel.setText(TurnText);
            try {
              XWins();
              OWins();
            } catch (InterruptedException e) {
              e.printStackTrace();
            }

         }

          if(arg0.getSource()==s9){
            s9.setText("X");
            s9.setEnabled(false);
            s9.setForeground(Color.WHITE);

            turn = "o";

            TurnLabel.setText(TurnText);

            try {
              XWins();
              OWins();
            } catch (InterruptedException e) {
              e.printStackTrace();
            }

          }
      }
      else{

        String TurnText = "X's Turn";

        if(arg0.getSource()==s1){
          s1.setText("O");
          s1.setEnabled(false);
          s1.setForeground(Color.WHITE);

          turn = "x";

          TurnLabel.setText(TurnText);

          try {
            XWins();
            OWins();
          } catch (InterruptedException e) {
            e.printStackTrace();
          }

        }

        if(arg0.getSource()==s2){
          s2.setText("O");
          s2.setEnabled(false);
          s2.setForeground(Color.WHITE);

          turn = "x"; 

          TurnLabel.setText(TurnText);

          try {
            XWins();
            OWins();
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }

        if(arg0.getSource()==s3){
          s3.setText("O");
          s3.setEnabled(false);
          s3.setForeground(Color.WHITE);

          turn = "x";

          TurnLabel.setText(TurnText);

          try {
            XWins();
            OWins();
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }

        if(arg0.getSource()==s4){
          s4.setText("O");
          s4.setEnabled(false);
          s4.setForeground(Color.WHITE);

          turn = "x";

          TurnLabel.setText(TurnText);

          try {
            XWins();
            OWins();
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }

        if(arg0.getSource()==s5){
          s5.setText("O");
          s5.setEnabled(false);
          s5.setForeground(Color.WHITE);

          turn = "x";

          TurnLabel.setText(TurnText);

          try {
            XWins();
            OWins();
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }

        if(arg0.getSource()==s6){
          s6.setText("O");
          s6.setEnabled(false);
          s6.setForeground(Color.WHITE);

          turn = "x";

          TurnLabel.setText(TurnText);

          try {
            XWins();
            OWins();
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
        
        if(arg0.getSource()==s7){
          s7.setText("O");
          s7.setEnabled(false);
          s7.setForeground(Color.WHITE);

          turn = "x";
          
          TurnLabel.setText(TurnText);

          try {
            XWins();
            OWins();
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }

        if(arg0.getSource()==s8){
          s8.setText("O");
          s8.setEnabled(false);
          s8.setForeground(Color.WHITE);

          turn = "x";

          TurnLabel.setText(TurnText);

          try {
            XWins();
            OWins();
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
       }

        if(arg0.getSource()==s9){
          s9.setText("O");
          s9.setEnabled(false);
          s9.setForeground(Color.WHITE);

          turn = "x";

          TurnLabel.setText(TurnText);

          try {
            XWins();
            OWins();
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
        
      }
      if(arg0.getSource()==reset){

        TurnLabel.setText("Start!");

          s1.setText("");
          s2.setText("");
          s3.setText("");
          s4.setText("");
          s5.setText("");
          s6.setText("");
          s7.setText("");
          s8.setText("");
          s9.setText("");
  
          s1.setEnabled(true);
          s2.setEnabled(true);
          s3.setEnabled(true);
          s4.setEnabled(true);
          s5.setEnabled(true);
          s6.setEnabled(true);
          s7.setEnabled(true);
          s8.setEnabled(true);
          s9.setEnabled(true);

          ScoreX.setText("X : 0");
          ScoreO.setText("0 : O");


      }

      if(arg0.getSource()==replay){

        TurnLabel.setText("Start!");

          s1.setText("");
          s2.setText("");
          s3.setText("");
          s4.setText("");
          s5.setText("");
          s6.setText("");
          s7.setText("");
          s8.setText("");
          s9.setText("");
  
          s1.setEnabled(true);
          s2.setEnabled(true);
          s3.setEnabled(true);
          s4.setEnabled(true);
          s5.setEnabled(true);
          s6.setEnabled(true);
          s7.setEnabled(true);
          s8.setEnabled(true);
          s9.setEnabled(true);


      }
      
      if(arg0.getSource()==exit){
        frame.dispose();
        new Start_Screen();
      }

        
    }
    @Override
    public void mouseClicked(MouseEvent e) {
      
      
    }
    @Override
    public void mouseEntered(MouseEvent e) {
      if(e.getSource() == s1){
        s1.setBackground(new Color(198,218,255));
      }
      if(e.getSource() == s2){
        s2.setBackground(new Color(198,218,255));
      }
      if(e.getSource() == s3){
        s3.setBackground(new Color(198,218,255));
      }
      if(e.getSource() == s4){
        s4.setBackground(new Color(198,218,255));
      }
      if(e.getSource() == s5){
        s5.setBackground(new Color(198,218,255));
      }
      if(e.getSource() == s6){
        s6.setBackground(new Color(198,218,255));
      }
      if(e.getSource() == s7){
        s7.setBackground(new Color(198,218,255));
      }
      if(e.getSource() == s8){
        s8.setBackground(new Color(198,218,255));
      }
      if(e.getSource() == s9){
        s9.setBackground(new Color(198,218,255));
      }

      if(e.getSource() == replay){
        replay.setBackground(new Color(255,145,43));
        replay.setForeground(Color.BLACK);
        replay.setFont(new Font("MV Boli",Font.BOLD,25));
        playSound("zapsplat_multimedia_button_click_004_78081.wav");   
      }
      if(e.getSource() == reset){
        reset.setBackground(new Color(255,145,43));
        reset.setForeground(Color.BLACK);
        reset.setFont(new Font("MV Boli",Font.BOLD,25));   
        playSound("zapsplat_multimedia_button_click_004_78081.wav");
      }
      if(e.getSource() == exit){
        exit.setBackground(new Color(255,145,43));
        exit.setForeground(Color.BLACK);
        exit.setFont(new Font("MV Boli",Font.BOLD,25));   
        playSound("zapsplat_multimedia_button_click_004_78081.wav");
      }

      
      
      
    }
    @Override
    public void mouseExited(MouseEvent e) {
      if(e.getSource() == s1){
        s1.setBackground(Color.BLACK);
      }
      if(e.getSource() == s2){
        s2.setBackground(Color.BLACK);
      }
      if(e.getSource() == s3){
        s3.setBackground(Color.BLACK);
      }
      if(e.getSource() == s4){
        s4.setBackground(Color.BLACK);
      }
      if(e.getSource() == s5){
        s5.setBackground(Color.BLACK);
      }
      if(e.getSource() == s6){
        s6.setBackground(Color.BLACK);
      }
      if(e.getSource() == s7){
        s7.setBackground(Color.BLACK);
      }
      if(e.getSource() == s8){
        s8.setBackground(Color.BLACK);
      }
      if(e.getSource() == s9){
        s9.setBackground(Color.BLACK);
      }

      if(e.getSource() == replay){
        replay.setBackground(Color.BLACK);
        replay.setForeground(new Color(255,145,43));
        //replay.setFont(new Font("MV Boli",Font.BOLD,20));
        //playSound("zapsplat_multimedia_button_click_004_78081.wav");   
      }
      if(e.getSource() == reset){
        reset.setBackground(Color.BLACK);
        reset.setForeground(new Color(255,145,43)); 
        //reset.setFont(new Font("MV Boli",Font.BOLD,20));  
        //playSound("zapsplat_multimedia_button_click_004_78081.wav");
      }
      if(e.getSource() == exit){
        exit.setBackground(Color.BLACK);
        exit.setForeground(new Color(255,145,43));
        //exit.setFont(new Font("MV Boli",Font.BOLD,20));   
        //playSound("zapsplat_multimedia_button_click_004_78081.wav");
      }
      
    }
    @Override
    public void mousePressed(MouseEvent e) {
      
      
    }
    @Override
    public void mouseReleased(MouseEvent e) {
      
      
    }
    
}