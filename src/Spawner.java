import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Spawner {

	public int timer = 0;
	public List<spaceShip> rectangles = new ArrayList<spaceShip>();
	public List<Particles> particles = new ArrayList<Particles>();
	SoundEffect explosionSound  = new SoundEffect("/sounds/explosion.wav", false);
	SoundEffect swooshSound  = new SoundEffect("/sounds/swoosh.wav", false);

		
	public void update() {
		timer++;
		if(timer % 25 ==0) {
			rectangles.add(new spaceShip(0,new Random().nextInt(480-40), 90, 90));
		}
		
		for(int i = 0; i < rectangles.size();i++) {
			
			spaceShip current = rectangles.get(i);
			
			current.update();
			if(current.x > Game.WIDTH) {
				rectangles.remove(current);
				Game.contador-=current.getSpeed();
				swooshSound.play();
			}
			if(Game.clicado) {
				if(Game.mx >= current.x && Game.mx < current.x+current.width) {
					if(Game.my >= current.y && Game.my < current.y+current.height) {
						explosionSound.play();
						rectangles.remove(current);
						Game.pontuacao+=current.getSpeed();
						if(Game.contador < 100) {
							Game.contador += current.getSpeed()/2;
						}
						Game.clicado = false;
						
						for(int n = 0; n < 100;n++) {
							particles.add(new Particles(current.x, current.y, 8, 8));
						}
					}
				}
			}
		}
		
		for(int i = 0; i < particles.size(); i++) {
			particles.get(i).update();
			
			Particles part = particles.get(i);
			if(part.timer >= 120) {
				particles.remove(part);
			}
		}
	}
	
	
		
	public void render(Graphics g) {
		for(int i = 0;i< rectangles.size(); i++) {
			spaceShip current = rectangles.get(i);
			current.draw(g, (int)current.getX(), (int)current.getY(), (int)current.getWidth(), (int)current.getHeight());
		}
		for(int i = 0; i < particles.size(); i++) {
			particles.get(i).render(g);
		}
			
	}
	

}
