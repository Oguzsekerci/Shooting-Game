import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Random;

import javax.swing.JLabel;
import javax.swing.JOptionPane;


public class Enemy implements Runnable 
{
	public int x;
	public int y;
	
	public int yDirection;
	public int health;
	public static int p1Score;
	
	public static Player p1;
	public Rectangle enemy;
		
	public Enemy(int x, int y, int health)
	{
		p1 = new Player(290, 15, 10);
		p1Score = 0;
		this.x = x;
		this.y = y;
		this.health = health;
		
	
		enemy = new Rectangle(this.x, this.y,100 , 100);	
	}
		
	

	public void setYDirection(int direction) {
		yDirection = direction;
	}
	

	public void draw(Graphics g)
	{
		Random rand = new Random();
		float red = rand.nextFloat();
		float green = rand.nextFloat();
		float blue = rand.nextFloat();
		Color randomColor = new Color(red, green, blue);
		
		g.setColor(randomColor);
		g.fillRect(enemy.x, enemy.y, enemy.width, enemy.height);
	}
	
	public void collision()
	{
		//vurulursa olacaklar
		if(Player.readyToFire == true && enemy.intersects(p1.bullet))
		{
			Random rnd4shot = new Random();
			int rndx = rnd4shot.nextInt(600)+50;
			health--;
			p1.bullet= new Rectangle(0, 0, 0, 0);;
			Player.readyToFire=true;
			
			if(health<0){
			enemy.setLocation(rndx, 0);
			p1Score+=100;
			int number=(p1Score/1000);
			health=number+1;
			
			}
		}
		
	}
	
	Random rnd = new Random();		
	int rndx = rnd.nextInt(600)+50;	
	
	public void move()
	{
		//etkisiz otomatik olarak hareket ederken
		enemy.y+=yDirection;

		Random rnd = new Random();		
		int rndx = rnd.nextInt(600)+50;
		
		if(enemy.y <= 20)
		{
			setYDirection(1);
			
		}
		
		if(enemy.y >= 590)
		{
			p1.phealth--;
			enemy.setLocation(rndx, 0);
	    	if (p1.getPhealth()==0)
	    	{
	    		realDealMain.GameOver=true;
	    		realDealMain.counter++;
	    		
	    		BufferedReader reader;
	    		BufferedWriter writer;
				try {				
					
					writer = new BufferedWriter(new FileWriter("output.txt"));						
					reader = new BufferedReader(new FileReader("output.txt"));		
						String infos=reader.readLine();
						if(infos!=null){
						String[] NSH=infos.split(" ");
						if(Integer.parseInt(NSH[2])<p1Score){
							writer.write(StartPanel.NameSurname+" "+p1Score);
							}
						}
						if(infos==null){
								writer.write(StartPanel.NameSurname+" "+p1Score);
							}	
						

						writer.close();
				}		
				 catch (Exception e2) 
				 {
					 JOptionPane.showMessageDialog(StartPanel.jpStartScreen,"Information couldnt save Please try again.");
				 }			
	    		
	    		
	    		Main.stop();	
	    	}
			
		}		

		collision();
	
	
}
	
	 public void run()
	    {
	        try
	        {
	           while(true)
	           {
	        	   move();
	        	   Thread.sleep(10);
	           }
	        }
	        catch(Exception e){System.err.println(e.getMessage());}
	    }

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getP1Score() {
		return p1Score;
	}

	public void setP1Score(int score) {
		p1Score = score;
	}

	public Player getP1() {
		return p1;
	}

	public void setP1(Player p1) {
		this.p1 = p1;
	}

	public Rectangle getEnemy() {
		return enemy;
	}

	public void setEnemy(Rectangle enemy) {
		this.enemy = enemy;
	}


	public int getYDirection() {
		return yDirection;
	}
	 
}


