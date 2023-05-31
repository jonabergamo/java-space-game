import java.awt.Graphics;
import java.util.Random;

import javax.swing.ImageIcon;

public class Particles extends spaceShip{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public int speed = 0;
	private ImageIcon img;
	public int timer = 0;
	
	public double xa,  ya;
	public double dx, dy;

	public Particles(int x, int y, int width, int height) {
		super(x,y,width,height);
		xa=x;
		ya=y;
		this.img = new ImageIcon(this.getClass().getResource("/sounds/explosion.png"));
		Random r = new Random();
		this.dx = r.nextGaussian();
		this.dy = r.nextGaussian();
		speed = 8;
	}
	
	public void update() {
		xa+=dx*speed;
		ya+=dy*speed;
		
		timer++;
	}
	public void render(Graphics g) {
		this.draw(g, (int)xa, (int)ya, width, height);
	}
	
	public void draw(Graphics g, int posX, int posY, int width, int height) {
		g.drawImage(img.getImage(), posX, posY, width, height,null);
	}

	public int getSpeed() {
		return speed;
	}

	public ImageIcon getImg() {
		return img;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public void setImg(ImageIcon img) {
		this.img = img;
	}

	
	
}
