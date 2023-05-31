import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferStrategy;

import javax.swing.ImageIcon;
import javax.swing.JFrame;


public class Game extends Canvas implements Runnable,MouseListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final int WIDTH = 1000, HEIGHT = 500;
	private ImageIcon img = new ImageIcon(this.getClass().getResource("/sounds/fundo.png"));
	public static int contador = 100;
	SoundEffect blasterSound;
	
	public Spawner spawner;
	
	public static int pontuacao = 0;
	
	public static int mx, my;
	public static boolean clicado = false;
	public boolean gameOver = false;
	
	public Game() {
		this.blasterSound = new SoundEffect("/sounds/blaster.wav", false);
		Dimension dimension = new Dimension(WIDTH, HEIGHT);
		this.setPreferredSize(dimension);
		this.addMouseListener(this);
		spawner = new Spawner();
		SoundEffect backgroundSound  = new SoundEffect("/sounds/spaceBackground.wav", true);
		backgroundSound.play();
	}
	public void update() {
		if(gameOver == false) {
			spawner.update();
			if(contador <= 0) {
				// Game Over
				contador = 100;
				gameOver = true;
			}
		}
	}
	public void render() {
		BufferStrategy bs = this.getBufferStrategy();
		
		if(bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		g.drawImage(img.getImage(), 0, 0, WIDTH, HEIGHT,null);
		if(gameOver == false) {
			
		
		/*
		g.setColor(Color.WHITE);
		
		g.setFont(new Font("Arial", Font.BOLD, 23));
		
		g.drawString("Pontos: " + contador, WIDTH/2 -60, 30);
		*/

		spawner.render(g);
		g.setColor(Color.WHITE);
		g.drawRect(Game.WIDTH/2-200, 20, 400,20);
		g.setColor(Color.GREEN);
		g.fillRect(Game.WIDTH/2-200, 20, contador*4,20);

		}else {
			g.setColor(Color.WHITE);
			g.setFont(new Font("Arial", Font.BOLD, 30));
			g.drawString("Game Over!", WIDTH/2-100, HEIGHT/2-100);
			g.setFont(new Font("Arial", Font.BOLD, 20));
			g.drawString("Pontuação Final : "+ Game.pontuacao, WIDTH/2-100, HEIGHT/2);
			if(Game.pontuacao < 400) {
				g.drawString("Você foi mediocre", WIDTH/2-100, 300);
			}else if(Game.pontuacao < 800) {
				g.drawString("Você foi mediano", WIDTH/2-100, 300);
			}else if(Game.pontuacao < 1500) {
				g.drawString("Você foi bem", WIDTH/2-100, 300);
			}

			

		}
		bs.show();
}
	
	public static void main(String[] args) {
		Game game = new Game();
		JFrame jframe = new JFrame("Meu Jogo");
		jframe.add(game);
		jframe.pack();
		jframe.setLocationRelativeTo(null);
		jframe.setResizable(false); //Disable the Resize Button  

		
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.setVisible(true);
		
		new Thread(game).start();
	}
	
	
	@Override
	public void run() {
		
		while(true) {
			update();
			render();
			try {
				Thread.sleep(1000/60);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		blasterSound.play();
		clicado = true;
		mx = e.getX();
		my = e.getY();
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		
	}

}
