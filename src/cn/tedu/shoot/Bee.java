package cn.tedu.shoot;
import java.awt.image.BufferedImage;
import java.util.Random;
/** С�۷� */
public class Bee extends FlyingObject implements Award{
	private static BufferedImage[] images;
	static{
		images=new BufferedImage[5];
		images[0]=loadImage("bee.png");
		for(int i=1;i<images.length;i++){
			images[i]=loadImage("bee_ember"+(i-1)+".png");
		}
	}
	
	private int xSpeed; //x�����ƶ��ٶ�
	private int ySpeed; //y�����ƶ��ٶ�
	private int awardType; //��������(0��1)
	/** ���췽�� */
	public Bee(){
		super(60,50);
		this.xSpeed = 1;
		this.ySpeed = 2;
		Random rand = new Random();
		this.awardType = rand.nextInt(2); //0��1֮��������
	}

	/** С�۷��ƶ� */
	public void step(){
		x+=xSpeed;
		y+=ySpeed;
		if(x<=0 || x>=World.WIDTH-this.width){
			xSpeed*=-1;
		}
	}
	
	int deadIndex=1;
	public BufferedImage getImage(){
		if(isLife()){
			return images[0];
		}else if(isDead()){
			BufferedImage img=images[deadIndex++];
			if(deadIndex==images.length){
				state=REMOVE;
			}
			return img;
		}
		return null;
	}
	public int getAwardType(){
		return awardType;
	}
}












