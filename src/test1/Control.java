package test1;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Control extends KeyAdapter implements Runnable {

	boolean KeyUp = false; // 위로 이동.
	boolean KeyDown = false; // 밑으로 이동.
	boolean KeyLeft = false; // 왼쪽 이동.
	boolean KeyRight = false; // 오른쪽 이동.
	Player player;
	Unit unit;

	public Control(Player player) {
		this.player = player;
	}

	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP:
			KeyUp = true;
			break;
		case KeyEvent.VK_DOWN:
			KeyDown = true;
			break;
		case KeyEvent.VK_LEFT:
			KeyLeft = true;
			break;
		case KeyEvent.VK_RIGHT:
			KeyRight = true;
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP:
			KeyUp = false;
			break;
		case KeyEvent.VK_DOWN:
			KeyDown = false;
			break;
		case KeyEvent.VK_LEFT:
			KeyLeft = false;
			break;
		case KeyEvent.VK_RIGHT:
			KeyRight = false;
			break;
		}
	}

	public void keyProcess() {

		if (KeyUp == true) {
			if (this.player.posY >= 26)
				this.player.posY -= 5;
		}
		if (KeyDown == true) {
			if (this.player.posY < 584)
				this.player.posY += 5;
		}
		if (KeyLeft == true) {
			if (this.player.posX > 0)
				this.player.posX -= 5;
		}
		if (KeyRight == true) {
			if (this.player.posX < 740)
				this.player.posX += 5;
		}
	}
	
	@Override
	public void run() {
		while (true) {
			try {
				keyProcess();
				Thread.sleep(20);

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
