package main;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener{
    public boolean upPressed , downPressed , leftPressed , rightPressed;

    @Override
    public void keyTyped(KeyEvent e){ // 注意：k是小写
        // 这个方法我们用不到，但因为实现了接口，必须留着它
    }

    @Override
    public void keyPressed(KeyEvent e){ // 注意：k是小写
        int code = e.getKeyCode();

        if(code == KeyEvent.VK_W){
            upPressed = true;
        }
        if(code == KeyEvent.VK_S){
            downPressed = true;
        }
        if(code == KeyEvent.VK_A){
            leftPressed = true;
        }
        if(code == KeyEvent.VK_D){
            rightPressed = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e){
        int code = e.getKeyCode(); // 你之前漏掉了这一行！需要先获取按键代码

        if(code == KeyEvent.VK_W){
            upPressed = false;
        }
        if(code == KeyEvent.VK_S){
            downPressed = false;
        }
        if(code == KeyEvent.VK_A){
            leftPressed = false;
        }
        if(code == KeyEvent.VK_D){
            rightPressed = false;
        }
    }
}