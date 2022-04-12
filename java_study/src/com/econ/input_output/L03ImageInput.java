package com.econ.input_output;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

//image.jpeg�� �����
//jvm�� teacher_java ���� ��ο� ����Ǳ� ������ �����('./','')�� ������ ������Ʈ ������ �ȴ�.
// ./src/com/econ/input_output/image.jpeg
//������  C:\Users\wjdgn\git\repository\java_study\java_study\src\com\econ\input_output\image.jpg
//����� src/com/econ/input_output/image.jpg ���� ./src/com/econ/input_output/image.jpg
class CardFrame extends JFrame{
	JLabel image=new JLabel("");
	public CardFrame() throws IOException{
		//�̹����� ���� ���� ���� => � �� ���� ����� ���� ���ؾ��Ѵ�.
		BufferedImage thumbnail=new BufferedImage(300,200,BufferedImage.TYPE_3BYTE_BGR);
		//BufferedImage �۰� �׸��� �׸��� ����� �Ǵ� �̹��� ���� �ҷ�����
		BufferedImage img=ImageIO.read(new File("src/com/econ/input_output/image.jpg"));
		thumbnail.createGraphics().drawImage(img, 0, 0, 300, 150,null);
				
		ImageIcon ii=new ImageIcon(thumbnail);
		image.setIcon(ii);
		this.add(image);
		this.setBounds(0,0,300,200);
		this.setVisible(true);
	}
}

public class L03ImageInput {
	public static void main(String[] args) {
		try {
			new CardFrame();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
