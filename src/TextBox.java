import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class TextBox {
	Vector2 Position;
	Vector2 Size;
	String Text;
	
	Thread animateThread;
	ArrayList<String> animateQueue = new ArrayList<String>();
	int animateCounter = 0;

<<<<<<< HEAD
	int dashCounter = 0;
=======
	boolean animating;
>>>>>>> origin/master
	
	public TextBox(Vector2 pos, Vector2  size){
		Position = pos;
		Size = size;
		Text = "";
<<<<<<< HEAD
		
		animateThread = new Thread(){
			public void run(){
				while (this != null){
					if (animateQueue.size() > 0){
						if (animateCounter < animateQueue.get(0).length()){
							animateCounter++;
							Text = animateQueue.get(0).substring(0, animateCounter);
							dashCounter = 20;
						} else {
							dashCounter++;
						}
						GameWindow.gameWindow.gamePanel.repaint();
					}
					try {
						Thread.sleep(15);
					} catch (InterruptedException e) { }
=======
	}
	
	public void AnimateText(final String text){
		if (animateThread == null) {
			animateThread = new Thread(){
				public void run(){
					while (this != null){
						if (animateQueue.size() > 0){
							animating = true;
							if (animateCounter < animateQueue.get(0).length()){
								animateCounter++;
								Text = animateQueue.get(0).substring(0, animateCounter);
								GameWindow.gameWindow.gamePanel.repaint();
							} 
							while (animateCounter == animateQueue.get(0).length()) {
								animating = false;
								Text += "_";
								try {
									Thread.sleep(500);
								} catch (InterruptedException e) { }
								GameWindow.gameWindow.gamePanel.repaint();
								Text = animateQueue.get(0).substring(0, animateCounter);
								try {
									Thread.sleep(500);
								} catch (InterruptedException e) { }
								GameWindow.gameWindow.gamePanel.repaint();
							}
						}
						try {
							Thread.sleep(15);
						} catch (InterruptedException e) { }
					}
>>>>>>> origin/master
				}
			};
			animateThread.start();
		}
		animateQueue.add(text);
	
	}
	
	public void AnimateText(final String text){
		animateQueue.add(text);
	}
	
	public void EnterToContinue(KeyEvent k) {
		if (animateQueue.size() > 1){
			animateQueue.remove(0);
			animateCounter = 0;
		}
	}
	
	public void ClickToContinue(MouseEvent k) {
<<<<<<< HEAD
		if (animateQueue.size() > 1){
=======
		if (animateQueue.size() > 0){
>>>>>>> origin/master
			animateQueue.remove(0);
			animateCounter = 0;
		}
	}
	
	public void Draw(Graphics2D g2d){
		g2d.setColor(Color.black);
		g2d.fillRect((int)Position.x, (int)Position.y, (int)Size.x, (int)Size.y);
		g2d.setColor(Color.green); // TODO replace with bg
		g2d.drawRect((int)Position.x, (int)Position.y, (int)Size.x, (int)Size.y);

		g2d.setFont(new Font("consolas", Font.PLAIN, 18));
		g2d.setColor(Color.green);
		g2d.drawString(Text + ((dashCounter / 20) % 2 == 0 ? "__" : ""), (int)Position.x + 15, (int)Position.y + 30);
	}
}
