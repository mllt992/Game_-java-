package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Date;
import java.util.Random;

public class GamePanel extends JPanel implements KeyListener, ActionListener {
	//关于蛇的相关变量的定义
	int slength;//蛇的长度
	int[] snakeX =new int[600];//蛇的x轴坐标，最大为600
	int[] snakeY =new int[550];//蛇的x轴坐标，最大为550
	//关于蛇头的方向
	String fx ="D";//上 W 下 S 左 A 右 D 默认蛇头朝右
	//关于游戏状态
	int isStart; //游戏是否开始 0 未开始 1 新开始 2暂停游戏 3 继续游戏  4 游戏失败
//	关卡
	int GK;
	//定时器
	Timer timer =  new Timer(200,this);
	//食物
	Random seed = new Random();
	int foodx;
	int foody;
//积分
	int CG;




	//构造器
	public GamePanel(){
		init();
		this.setFocusable(true);//获取焦点
		this.addKeyListener(this);/* 添加监听 */
	}
    //初始化
	public void init(){
		slength=1;//蛇的长度 初始值为0
		snakeX[0]=100;snakeY[0]=100;//蛇的初始位置
		String fx ="D";//上 W 下 S 左 A 右 D 默认蛇头朝右
		GK=25;
		timer.start();
		foodx=seed.nextInt(550);
		foody=seed.nextInt(500)+50;//因为有头图
		CG=0;

	}




















	//建立画板
	@Override
	//Graphics 画笔
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);//清屏
		this.setBackground(Color.white);//设置背景颜色
		//窗口顶部位置绘制
		GameImg.IMG_header.paintIcon(this, g, 0, 0);
		//游戏区域绘制
		g.fillRect(0, 50, 600, 550);//矩形绘画 将此矩形作为游戏区域
		//蛇 绘制
		if (fx == "D") {
			GameImg.IMG_right.paintIcon(this, g, snakeX[0], snakeY[0]);
		} else if (fx == "A") {
			GameImg.IMG_left.paintIcon(this, g, snakeX[0], snakeY[0]);
		} else if (fx == "W") {
			GameImg.IMG_up.paintIcon(this, g, snakeX[0], snakeY[0]);
		} else if (fx == "S") {
			GameImg.IMG_down.paintIcon(this, g, snakeX[0], snakeY[0]);
		}
        //食物绘制
		GameImg.IMG_food.paintIcon(this,g,foodx,foody);

		//蛇身体的绘制
		for (int i = 1; i < slength; i++) {
			//蛇的身体通过变量slength控制
			GameImg.IMG_body.paintIcon(this, g, snakeX[i], snakeY[i]);
		}
		//游戏分数
		g.setColor(Color.blue);    //设置画笔颜色
		g.setFont(new Font("幼圆", Font.BOLD, 25));
		g.drawString("分数："+CG, 50, 30);
		//游戏状态提示
		if (isStart == 0) {
//			绘画文字
			g.setColor(Color.white);    //设置画笔颜色
			g.setFont(new Font("幼圆", Font.BOLD, 25));
			g.drawString("按下空格开始游戏", 200, 200);
		} else if (isStart == 1) {
		} else if (isStart == 2) {
			g.setColor(Color.white);    //设置画笔颜色
			g.setFont(new Font("幼圆", Font.BOLD, 25));
			g.drawString("按下空格继续游戏", 200, 200);
		} else if (isStart == 3) {
		} else if (isStart == 4) {
			g.setColor(Color.red);    //设置画笔颜色
			g.setFont(new Font("幼圆", Font.BOLD, 25));
			g.drawString("游戏结束", 200, 200);
		}
	}
	@Override
	public void keyTyped(KeyEvent e) {

	}
	@Override//按键被按下（未释放）
	public void keyPressed(KeyEvent e) {
    int keyCode = e.getKeyCode();
    if(keyCode==KeyEvent.VK_SPACE)//如果空格键被按下
    {
	    if (isStart == 0) {
		    //此时，游戏未开始，按下空格，将会开始游戏
		    isStart = 1;
		    init();//重新初始化游戏
	    } else if (isStart == 1) {
		    //此时游戏已开始，按下空格，将会暂停游戏
		    isStart = 2;
		    //此处后面需要重置游戏分数
	    } else if (isStart == 2) {
		    //此时游戏暂停，按下空格，将会继续游戏
		    isStart = 3;
	    } else if (isStart == 3) {
		    //此时游戏进行中，按下空格，将会暂停游戏
		    isStart = 2;
	    } else if (isStart == 4) {
		    //此时游戏结束，按下空格，将会重新开始游戏
		    isStart = 1;
		    init();

	    }
    }
    //键盘控制小蛇方向
		if(keyCode==KeyEvent.VK_LEFT){
			fx="A";
		}else if(keyCode==KeyEvent.VK_RIGHT){
			fx="D";
		}else if(keyCode==KeyEvent.VK_UP){
			fx="W";
		}else if(keyCode==KeyEvent.VK_DOWN){
			fx="S";
		}




   repaint();
    }
	@Override//按键被释放
	public void keyReleased(KeyEvent e) {

	}

	@Override//指定定时操作的内容
	public void actionPerformed(ActionEvent e) {
		timer.start();
		if(isStart==1 || isStart ==3){
      	//右移
	      for(int i = slength-1;i>0;i--){
	      	snakeX[i]=snakeX[i-1];
	      	snakeY[i]=snakeY[i-1];
	      }
	      if(fx.equals("D")){
		      snakeX[0]=snakeX[0]+GK;//头部移动
		      if(snakeX[0]>600){
			      snakeX[0]=0;
		      }
			}else if(fx.equals("A")) {
		      snakeX[0] = snakeX[0] - GK;//头部移动
		      if (snakeX[0] < 0) {
			      snakeX[0] = 600;
		      }
	      }else if(fx.equals("W")) {
		      snakeY[0] = snakeY[0] - GK;//头部移动
		      if (snakeY[0] < 50) {
			      snakeY[0] = 550;
		      }
	      }else if(fx.equals("S")) {
		      snakeY[0] = snakeY[0] + GK;//头部移动
		      if (snakeY[0] > 550) {
			      snakeY[0] = 50;
		      }
	      }
//食物监听1：吃到食物
			boolean flag = new Rectangle(foodx,foody,25,25).intersects(new Rectangle(snakeX[0],snakeY[0],25,25));
			if(flag == true) {

				//吃到食物，小蛇长度+1、
				slength++;
				CG++;
				//重新生成食物
				foodx=seed.nextInt(550);
				foody=seed.nextInt(500)+50;//因为有头图
			}


			//死亡判断
			for(int i = 1; i<slength;i++){
				boolean flagself = new Rectangle(snakeX[i],snakeY[i],25,25).intersects(new Rectangle(snakeX[0],snakeY[0],25,25));
				if(flagself==true){
					isStart=4;
				}
			}

		repaint();//重新绘制页面


      }
	}

}
