package main;

import javax.swing.JFrame;

public class Main {
   public static void main(String[] args) {
       JFrame window = new JFrame();// 创建一个窗口对象
       window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 设置点击右上角关闭按钮时，程序完全退出
       window.setResizable(false);// 禁止玩家用鼠标拖拽改变窗口大小，防止游戏画面变形
       window.setTitle("Jade Journey - 阶段一测试");// 设置窗口的标题
       GamePanel gamePanel = new GamePanel();// 创建游戏面板（我们游戏的核心）
       window.add(gamePanel);// 将面板添加到窗口中
       window.pack();// 让窗口大小自适应面板(GamePanel)的推荐大小
       window.setLocationRelativeTo(null);// 将窗口居中显示在屏幕上
       window.setVisible(true);// 让窗口可见
       gamePanel.startGameThread();// 启动游戏主线程
    }
}
