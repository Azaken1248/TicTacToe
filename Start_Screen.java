import javax.swing.JFrame;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

public class Start_Screen implements ActionListener,MouseListener{

    JFrame frame;
    ImageIcon image;
    JPanel center,north;
    JButton Start,Exit;
    JLabel Welcome;


    Start_Screen(){

        image = new ImageIcon("Tic.jfif");

        frame = new JFrame();

        frame.setTitle("TicTacToe");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setIconImage(image.getImage());
        frame.getContentPane().setBackground(Color.BLACK);
        frame.setLayout(new BorderLayout());
        frame.setSize(550,550);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        center = new JPanel();
        center.setBackground(Color.BLACK);
        center.setLayout(new GridLayout(2,1));
        center.setBorder(BorderFactory.createLineBorder(new Color(255,145,43),3));

        north = new JPanel();
        north.setBackground(Color.BLACK);
        north.setBorder(BorderFactory.createLineBorder(new Color(255,145,43),3));
        
        Welcome = new JLabel("Welcome To TicTacToe!");
        Welcome.setBackground(Color.BLACK);
        Welcome.setForeground(new Color(255,145,43));
        Welcome.setFont(new Font("MV Boli",Font.BOLD,40));
        Welcome.setFocusable(false);
        

        Start = new JButton("Start");

        Start.setPreferredSize(new Dimension(100,400));
        Start.setBackground(Color.BLACK);
        Start.setForeground(new Color(255,145,43));
        Start.setFont(new Font("MV Boli",Font.PLAIN,75));
        Start.setBorder(null);
        Start.setFocusable(false);

        Exit = new JButton("Exit");

        Exit.setPreferredSize(new Dimension(100,400));
        Exit.setBackground(Color.BLACK);
        Exit.setForeground(new Color(255,145,43));
        Exit.setBorder(null);
        Exit.setFont(new Font("MV Boli",Font.PLAIN,75));
        Exit.setFocusable(false);

        Start.addMouseListener(this);
        Exit.addMouseListener(this);

        Start.addActionListener(this);
        Exit.addActionListener(this);

        north.add(Welcome);

        center.add(Start);
        center.add(Exit);

        frame.add(center,BorderLayout.CENTER);
        frame.add(north,BorderLayout.NORTH);

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

    @Override
    public void actionPerformed(ActionEvent args) {
        
        if(args.getSource()==Start){
            new Game_Screen();
            frame.dispose();
            
        }
        if(args.getSource()==Exit){
            System.exit(0);
        }
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == Start){
            Start.setBackground(Color.BLACK);
            Start.setForeground(new Color(255,145,43));
            
            
        }
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if(e.getSource()==Start){
            Start.setBackground(new Color(255,145,43));
            Start.setForeground(Color.BLACK);
            Start.setFont(new Font("MV Boli",Font.BOLD,95));
            
            playSound("zapsplat_multimedia_button_click_004_78081.wav");

        }
        if(e.getSource()==Exit){
            Exit.setBackground(new Color(255,145,43));
            Exit.setForeground(Color.BLACK);
            Exit.setFont(new Font("MV Boli",Font.BOLD,95));

            playSound("zapsplat_multimedia_button_click_004_78081.wav");
        }
        
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if(e.getSource()==Start){
            Start.setBackground(Color.BLACK);
            Start.setForeground(new Color(255,145,43));
            Start.setFont(new Font("MV Boli",Font.PLAIN,75));
        }
        if(e.getSource()==Exit){
            Exit.setBackground(Color.BLACK);
            Exit.setForeground(new Color(255,145,43));
            Exit.setFont(new Font("MV Boli",Font.PLAIN,75));
        }
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getSource() == Start){
            Start.setBackground(Color.BLACK);
            Start.setForeground(new Color(255,145,43));
;
        }
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if(e.getSource() == Start){
            Start.setPreferredSize(new Dimension(100,400));
            Start.setBackground(Color.BLACK);
            Start.setForeground(new Color(255,145,43));
            Start.setFont(new Font("MV Boli",Font.BOLD,75));
            Start.setBorder(null);
            Start.setFocusable(false);
        }
        
    }
    
}
