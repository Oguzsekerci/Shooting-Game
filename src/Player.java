import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;


	public class Player implements Runnable
	{
		public static int x;
		public static int y;
		public static int phealth;
		public static int bx;
		public static int by;
		public static int xDirection;
		public static boolean readyToFire;
		public static boolean shot = false;
		public static Rectangle player;
	    public static Rectangle bullet;
	    
		public Player(int x, int y, int phealth)
		{
			this.x = x;
			this.y = y;
			this.phealth = phealth;
			player = new Rectangle(400, 550, 100, 20);
			
		}		
		
		public static void keyPressed(KeyEvent e)
	    {			
			if(e.getKeyCode() == KeyEvent.VK_LEFT)
	    	{
	    		setXDirection(-1);
	    	}
	    	
	    	if(e.getKeyCode() == KeyEvent.VK_RIGHT)
	    	{
	    		setXDirection(1);
	    	}
	    	
	    	if(e.getKeyCode() == KeyEvent.VK_SPACE)
	    	{
	    		readyToFire = true;
	    		if(readyToFire)
	    		{
	    			bullet = new Rectangle (player.x+45, player.y-20);
	    			by = player.y-20;
	    			bx = player.x+45;
	    			bullet = new Rectangle(bx, by, 3 , 10);
	    			shot = true;
	    		}
	    	}
	    }
		
		public static void keyReleased(KeyEvent e)
	    {			
			if(e.getKeyCode() == KeyEvent.VK_LEFT)
	    	{
	    		setXDirection(0);
	    	}
	    	
	    	if(e.getKeyCode() == KeyEvent.VK_RIGHT)
	    	{
	    		setXDirection(0);
	    	}
	    	
	    	if(e.getKeyCode() == KeyEvent.VK_SPACE)
	    	{
	    		readyToFire = false;
	    
	    		if(bullet.y <= -5)
	    		{
	    			bullet = new Rectangle(0, 0, 0, 0);
	    			shot = false;
	    			readyToFire = true;
	    		}
	    }
	    }
			    		
		public static void shoot()
		{
			if(shot)
			{
				bullet.y-=4;
			}
		}
				
		public static void move()
	    {
	    	player.x+= xDirection;
	    	
	    	if(player.x <= -40)
	    	{
	    		player.x = -40;
	    	}
	    	
	    	if(player.x >= 740)
	    	{
	    		player.x = 740;
	    	}
	    }
		
		public void draw(Graphics g)
	    {
			g.setColor(Color.yellow);
    		g.fillRect(player.x, player.y, player.width, player.height);
    		g.fillRect(player.x+45, player.y-20, 10, 30);
    		
    		if(shot)
    		{
    			g.setColor(Color.RED);
    			g.fillRect(bullet.x+5, bullet.y-10, bullet.width, bullet.height);
    		}
	    }
				
		public static void setXDirection(int direction) 
		{
			xDirection = direction;
		}
		
		public void run() 
		    {
		    	try
		    	{
		    		while(true)
		    		{
		    			move();
		    			shoot();
		    			Thread.sleep(2);
		    		}
		    		
		    	}
		    	catch(Exception e){System.err.println(e.getMessage());}
		    }

		public static int getX() {
			return x;
		}

		public static void setX(int xa) {
			x = xa;
		}

		public static  int getY() {
			return y;
		}

		public static  void setY(int ya) {
			y = ya;
		}

		public static int getPhealth() {
			return phealth;
		}

		public static void setPhealth(int phealtha) {
			phealth = phealtha;
		}

		public static int getBx() {
			return bx;
		}

		public static void setBx(int bxa) {
			bx = bxa;
		}

		public static int getBy() {
			return by;
		}

		public static void setBy(int bya) {
			bya = by;
		}

		public static boolean isReadyToFire() {
			return readyToFire;
		}

		public static void setReadyToFire(boolean readyToFire) {
			Player.readyToFire = readyToFire;
		}

		public  Rectangle getPlayer() {
			return player;
		}

		public  void setPlayer(Rectangle playera) {
			player = playera;
		}

		public  Rectangle getBullet() {
			return bullet;
		}

		public void setBullet(Rectangle bulleta) {
			bullet = bullet;
		}

		public int getXDirection() {
			return xDirection;
		}	 
	}

