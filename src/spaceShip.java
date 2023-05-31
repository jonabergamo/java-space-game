import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

import javax.swing.ImageIcon;

public class spaceShip extends Rectangle{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public int speed = 0;
	private ImageIcon greenShip;
	private ImageIcon blackShip;
	private ImageIcon redShip;
	private ImageIcon blueShip;
	private int ship;

	public spaceShip(int x, int y, int width, int height) {
		super(x,y,width,height);
		Random r = new Random();
		this.ship = r.nextInt(4);
		this.greenShip = new ImageIcon(this.getClass().getResource("/sounds/ship5 1.png"));
		this.blackShip = new ImageIcon(this.getClass().getResource("/sounds/ship5 2.png"));
		this.redShip = new ImageIcon(this.getClass().getResource("/sounds/ship5 3.png"));
		this.blueShip = new ImageIcon(this.getClass().getResource("/sounds/ship5 4.png"));
		speed = r.nextInt(5+Game.pontuacao/40)+4+Game.pontuacao/100;
	}
	
	public void update() {
		x+=this.speed;
	}
	
	public void draw(Graphics g, int posX, int posY, int width, int height) {
		g.drawImage(this.ship == 1 ? greenShip.getImage() : this.ship == 2 ? blackShip.getImage() : this.ship == 3 ? redShip.getImage() : blueShip.getImage(), posX, posY, width, height,null);
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public ImageIcon getGreenShip() {
		return greenShip;
	}

	public ImageIcon getBlackShip() {
		return blackShip;
	}

	public ImageIcon getRedShip() {
		return redShip;
	}

	public ImageIcon getBlueShip() {
		return blueShip;
	}

	public void setGreenShip(ImageIcon greenShip) {
		this.greenShip = greenShip;
	}

	public void setBlackShip(ImageIcon blackShip) {
		this.blackShip = blackShip;
	}

	public void setRedShip(ImageIcon redShip) {
		this.redShip = redShip;
	}

	public void setBlueShip(ImageIcon blueShip) {
		this.blueShip = blueShip;
	}



	
	
}
