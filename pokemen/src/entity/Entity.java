package entity;
import java.awt.image.BufferedImage;

// 这是所有活动对象的基类（无论是玩家、NPC还是怪物，都有这些基本属性）
public class Entity {
        public int x ,y;//坐标
        public int speed;//移动速度
        //BufferedImage 用来存放我们的角色图片
        public BufferedImage up1,up2,dwon1,down2,left1,left2,right1,right2;
        public String direction;// 记录角色当前的朝向（上、下、左、右）
    // 这两个变量用来控制角色走路时的“动画交替”
        public int spriteCounter = 0;// 动画计数器
        public int spriteNum = 1;// 当前显示第几张图片（1或2）
}
