package rpg.game;

import java.awt.Rectangle;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import rpg.api.KeyAction;
import rpg.game.music.Music;
import rpg.game.setting.Setting;
import rpg.state.GameState;
import rpg.world.Map;
import rpg.world.WorldMap;

public class Game implements Runnable {
	private GameState gameState;
	private Display display;
	public int width, height, currentMap;
	public String title;
	private Rectangle[] port;
	private Map map;
	private WorldMap worldMap;
	private Thread thread;
	private boolean running = false;
	private String musicFilePath;
	private Music music;
	private KeyAction key;
	private BufferStrategy bs;
	private Graphics g;

	public Game(String title, int width, int height) {
		this.width = width;
		this.height = height;
		this.title = title;
		key = new KeyAction();
	}
	
	public  GameState getGameState() {
		return this.gameState;
	}

	public synchronized void start() {
		if (running) {
			return;
		}
		running = true;
		thread = new Thread(this);
		thread.start();
		musicFilePath = "src/Assets/nhac.wav";
		music = new Music(musicFilePath);
		if (Setting.musicable == true)
			music.start();
	}

	public synchronized void stop() {
		if (!running) {
			return;
		}
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void update() {
		key.update();
		gameState.update();
	}

	private void render() {
		bs = display.getCanvas().getBufferStrategy();
		if (bs == null) {
			display.getCanvas().createBufferStrategy(2);
			return;
		}
		g = bs.getDrawGraphics();
		
		if(gameState.getPlayer().getDead()){
			display.renderEndGame(g);
			if(key.space == true) {
				new GameStart();
				music.setRunning(false);
				display.getFrame().dispose();
				this.stop();
			}
		}else {
			map = worldMap.getMap(currentMap);
			port = map.getPort();
			changeMap();
			map.render(g);
			gameState.render(g);
		}
		
		bs.show();
		g.dispose();
	}

	public void run() {
		init();
		int fps = 30;
		double timePerTick = 1000000000.0 / fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		while (running) {
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			lastTime = now;
			if (delta >= 1) {
				render();
				update();
				delta--;
			}

		}
		stop();
	}

	private void init() {
		worldMap = new WorldMap();
		map = worldMap.getMap(2);
		currentMap = 2;
		display = new Display(title, width, height);
		display.getFrame().addKeyListener(key);
		gameState = new GameState(this);
	}

	public KeyAction getKeyaction() {
		return key;
	}
//	public Graphics getGraphic() {
//		return this.g;
//	}

	public Map getCurrentMap() {
		return map;
	}

	public void changeMap(){
		if (currentMap == 0) {
			if (gameState.getPlayer().getCollisionBounds(0).intersects(port[0])) {
				currentMap = 2;
				gameState.getPlayer().setX(731);
				gameState.getPlayer().setY(381);
			} else if (gameState.getPlayer().getCollisionBounds(0).intersects(port[1])) {
				currentMap = 1;
				gameState.getPlayer().setX(320);
				gameState.getPlayer().setY(35);
			}
		} else if (currentMap == 1) {
			if (gameState.getPlayer().getCollisionBounds(0).intersects(port[0])) {
				currentMap = 0;
				gameState.getPlayer().setX(348);
				gameState.getPlayer().setY(550);
			}
		} else if (currentMap == 2) {
			if (gameState.getPlayer().getCollisionBounds(0).intersects(port[0])) {
				currentMap = 0;

				gameState.getPlayer().setX(60);
				gameState.getPlayer().setY(270);
			}
		}
	}

}
