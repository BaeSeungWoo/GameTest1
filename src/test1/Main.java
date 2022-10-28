package test1;

import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Main extends JFrame implements Runnable {

	Image background = new ImageIcon(Main.class.getResource("background.png")).getImage();
	int frameWidth = 800;
	int frameHeight = 600;
	Player player;
	Unit unit;
	Thread th;
	Image buffImg;
	Graphics buffG;
	boolean checkExit;
	ArrayList<Enemy> Enemys = new ArrayList<Enemy>();
	ArrayList<Enemy> Enemys2 = new ArrayList<Enemy>();

	public Main(Player player) {
		this.player = player;
		Control key = new Control(player);
		th = new Thread(key);
		th.start();
		homeframe();

		Enemy storm1 = new Storm(50, 30);
		Enemy thunder1 = new Thunder(150, 200);
		Enemy storm2 = new Storm(250, 30);
		Enemy thunder2 = new Thunder(400, 30);
		Enemy thunder3 = new Thunder(550, 30);
		Enemy storm3 = new Storm(700, 30);

		Enemy storm4 = new Storm(100, 30);
		Enemy thunder4 = new Thunder(200, 30);
		Enemy storm5 = new Storm(300, 30);
		Enemy thunder5 = new Thunder(400, 30);
		Enemy thunder6 = new Thunder(500, 30);
		Enemy storm6 = new Storm(600, 30);

		Enemys.add(storm1);
		Enemys.add(storm2);
		Enemys.add(storm3);
		Enemys.add(thunder1);
		Enemys.add(thunder2);
		Enemys.add(thunder3);

		Enemys2.add(storm4);
		Enemys2.add(storm5);
		Enemys2.add(storm6);
		Enemys2.add(thunder4);
		Enemys2.add(thunder5);
		Enemys2.add(thunder6);

		addKeyListener(key);

	}

	/* 생성자에 써도 되는 것들입니다. 그냥 저는 함수 만들어서 썻습니다. */
	public void homeframe() {
		setTitle("1");// 타이틀
		setSize(frameWidth, frameHeight);// 프레임의 크기
		setResizable(false);// 창의 크기를 변경하지 못하게
		setLocationRelativeTo(null);// 창이 가운데 나오게
		setLayout(null);// 레이아웃을 내맘대로 설정가능하게 해줌.
		setVisible(true);// 창이 보이게
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// JFrame이 정상적으로 종료되게
	}

	public void paint(Graphics g) {
		repaint();
		buffImg = createImage(getWidth(), getHeight());
		buffG = buffImg.getGraphics();
		update(g);
		if (this.player.hp <= 0)
			return;
	}

	public void update(Graphics g) {
		drawBackGround(g);
		drawPlayer(g);
		drawEnemy(g);
		g.drawImage(buffImg, 0, 0, this);
	}

	int count = 0;

	// 배경 그리기.
	public void drawBackGround(Graphics g) {
		buffG.clearRect(0, 0, frameWidth, frameHeight);
		buffG.drawImage(background, count, 0, this);
	}

	public void drawPlayer(Graphics g) {
		buffG.drawImage(this.player.resizeImg, this.player.posX, this.player.posY, this);

		// 플레이어의 피가0이 되면 모두 종료.
		if (this.player.hp <= 0) {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			// 적 리스트 초기화.
			Enemys = new ArrayList<Enemy>();

			// Frame 없애기.
			this.checkExit = true;
			this.dispose();
		}
	}

	public void drawEnemy(Graphics g) {
		for (int i = 0; i < Enemys.size(); i++) {
			
				buffG.drawImage(Enemys.get(i).resizeImg, Enemys.get(i).posX, Enemys.get(i).posY, this);
				Enemys.get(i).move();			
			}
		}


	
	@Override
	public void run() {
		while (true) {
			if (this.checkExit == true)
				break;
			else {
				System.out.print("");
				continue;
			}
		}
	}

	/* 메인함수 */
	public static void main(String[] args) {
		Player player = new Player();
		Main th = new Main(player);
		Thread gameth = new Thread(th);
		gameth.start();

	}
}