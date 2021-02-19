package main;

import javax.swing.*;
import java.awt.*;

public class GameStart {
	public static void main(String[] args) {
		//窗口绘制 关联课程：https://www.bilibili.com/video/BV1Tt4y1z7Pq?p=1
		JFrame jf = new JFrame();
		jf.setTitle("贪吃蛇 By萌狼蓝天");
		//设置窗口位置与大小 设置开始
		//关联课程 https://www.bilibili.com/video/BV1Tt4y1z7Pq?p=2
		int jfwidth=600;
		int jfheight=600;
		int width = Toolkit.getDefaultToolkit().getScreenSize().width;//取屏幕宽度
		int height = Toolkit.getDefaultToolkit().getScreenSize().height;//取屏幕高度
		int jfx=(width-jfwidth)/2;
		int jfy=(height-jfheight)/2;
		jf.setBounds(jfx,jfy,jfwidth,jfheight);
		//设置窗口位置与大小 设置完毕
		jf.setResizable(false);//设置窗口尺寸不可调整
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//设置窗口关闭同步

		//将面板加入到此窗口中
		jf.add(new GamePanel());

		jf.setVisible(true);//设置窗口可见
	}
}
