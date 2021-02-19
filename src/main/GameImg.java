package main;

import javax.swing.*;
import java.net.URL;

public class GameImg {
	//第一步：获取图片 URL_header是可以自定义的名称
	public static URL URL_header = GameImg.class.getResource("/res/header.png");
	 //第二步：将图片封装为对象 IMG_header是可以自定义的名称
	public static ImageIcon IMG_header = new ImageIcon(URL_header);
	//蛇 相关图片资源
	public static URL URL_up = GameImg.class.getResource("/res/up.png");
	public static URL URL_down = GameImg.class.getResource("/res/down.png");
	public static URL URL_left = GameImg.class.getResource("/res/left.png");
	public static URL URL_right = GameImg.class.getResource("/res/right.png");
	public static URL URL_body = GameImg.class.getResource("/res/body.png");
	public static ImageIcon IMG_up = new ImageIcon(URL_up);
	public static ImageIcon IMG_down = new ImageIcon(URL_down);
	public static ImageIcon IMG_left = new ImageIcon(URL_left);
	public static ImageIcon IMG_right = new ImageIcon(URL_right);
	public static ImageIcon IMG_body = new ImageIcon(URL_body);
	//食物
	public static URL URL_food = GameImg.class.getResource("/res/food.png");
	public static ImageIcon IMG_food= new ImageIcon(URL_food);
}
