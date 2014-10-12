import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Main extends JFrame
{	
	static Thread enemy;
	static Thread enemy2;
	static Thread enemy3;
	
 	static Thread player;
	
	Image dbImage;
	static Graphics dbg;

	static Random rndx = new Random();
	
	static int rndxx = rndx.nextInt(600)+50;
	static int rndxx2 = rndx.nextInt(600)+50;
	static int rndxx3 = rndx.nextInt(600)+50;
	
	static Enemy en = new Enemy(rndxx,0,1);
	static Enemy en2 = new Enemy(rndxx2,0,1);
	static Enemy en3 = new Enemy(rndxx3,0,1);
	
	int GWIDTH = 800;
	int GHEIGHT = 600;
 
	static Main m = new Main();
	
	Dimension screenSize = new Dimension(GWIDTH, GHEIGHT);
	

	
	public Main()
	{
		this.setTitle("Java Shooting Game");
        this.setSize(screenSize);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setBackground(Color.black);
        this.addKeyListener(new AL());
	}
	
	public static void run(){
		enemy = new Thread(en);
		enemy2 = new Thread(en2);
		enemy3 = new Thread(en3);
		
     	player = new Thread(en.p1);     	
     	
     	enemy.start();
     	enemy2.start();
     	enemy3.start();
    	player.start();    	

	}
	 
	public static void stop(){
	   	enemy. interrupt();
     	enemy2. interrupt();
     	enemy3. interrupt();
    	player. interrupt();    	
	}
	
	
	
	public void paint(Graphics g)
	{
		dbImage = createImage(getWidth(), getHeight());
    	dbg = dbImage.getGraphics();
    	draw(dbg);
    	g.drawImage(dbImage, 0, 0, this);
    	
	}
	
	 public void draw(Graphics g)
	    {
	    	en.draw(g);
	    	en2.draw(g);	
	    	en3.draw(g);
	    	en.p1.draw(g);    
	    	
	    	g.setColor(Color.red);
	    	g.drawString("Score: "+en.p1Score, 150,50);
	    	
	    	g.setColor(Color.blue);
	    	g.drawString("Enemy Health: " +en.health, 150,60);
	    	
	    	g.setColor(Color.green);
	    	g.drawString("Player Health: " +en.p1.phealth,150,70);
	    	repaint();
	    	
	    }
	
	public class AL extends KeyAdapter 
    {
        
        public void keyPressed(KeyEvent e)
        {        	
            en.p1.keyPressed(e);
            en2.p1.keyPressed(e);
            en3.p1.keyPressed(e);
        }
       
        public void keyReleased(KeyEvent e)
        {        	
            en.p1.keyReleased(e);
            en2.p1.keyPressed(e);
            en3.p1.keyPressed(e);
        }
    }
}

