import javax.swing.JLabel;


public class realDealMain {

	public static int counter=0;
	public static int programRunning=0;
	public static boolean GameOver=false;
	public static void main(String[] args)
	{
	while(true){
		switch (counter) {
		case 0:
			StartPanel.run();
			break;
		case 1:
			if(programRunning!=1)
			Main.run();
			programRunning=1;
			break;
		case 2:
			if( GameOver=true){
			String Score = ""+Enemy.p1Score;
			Main.dbg.drawString("GAME OVER",400,400);
			Main.dbg.drawString(Score,400,500);
			break;
			}
		}
		
	}	
		
}


}