package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import tile.TileManager;


public class GamePanel extends JPanel implements Runnable {

   public final int originalTileSize = 16;
   public final int scale = 3;

    public final int tileSize = originalTileSize * scale;

   public final int maxScreenCol = 16;
   public final int maxScreenRow = 12;
   public final int screenWidth = tileSize * maxScreenCol;
   public final int screenHeight = tileSize * maxScreenRow;

    int FPS = 60;

    Thread gameThread;

    public GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth,screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);

        this.addKeyListener(keyH);
        this.setFocusable(true);
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        double drawInterval = 1000000000.0 / FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        while (gameThread != null) {
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            lastTime = currentTime;

            if (delta >= 1) {
                update();
                repaint();
                delta--;
            }
        }
    }

    public void update() {
                if(keyH.upPressed){
                    playerY -= playerSpeed;
                } else if (keyH.downPressed) {
                    playerY += playerSpeed;
                } else if (keyH.leftPressed) {
                    playerX -= playerSpeed;
                }
                else if (keyH.rightPressed) {
                    playerX += playerSpeed;
                }
    }


    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        tileM.draw(g2);

        g2.setColor(Color.WHITE);
        g2.fillRect(playerX, playerY, tileSize, tileSize);
        g2.dispose();





    }

    KeyHandler keyH = new KeyHandler();
    public TileManager tileM = new TileManager(this);

    int playerX = 100;
    int playerY = 100;
    int playerSpeed = 4;


}








