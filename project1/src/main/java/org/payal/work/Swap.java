package org.payal.work;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Swap {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		/*Point x1=new Point(10,10);
		Point x2=new Point(20,20);
		//swap(x1, x2);
		System.out.println(x2.x+ " "+x2.y);
		FileOutputStream fileOutputStream=new FileOutputStream("a.txt");
		ObjectOutputStream objectOutputStream =new ObjectOutputStream(fileOutputStream);
		objectOutputStream.writeObject(x2);*/
		 FileInputStream fileInputStream=new FileInputStream("a.txt");
		 ObjectInputStream inputStream=new ObjectInputStream(fileInputStream);
		 Point x=(Point)inputStream.readObject();
		// System.out.println(x.x+"  "+x.y);
		//System.out.println(x==x2);

		
	}
	/*static void  swap(Point x1,Point x2){
		Point  temp=new Point();
		temp.x=x2.x;
		temp.y=x2.y;
		x2.x=x1.x;
		x2.y=x1.y;
		x1.x=temp.x;
		x1.y=temp.y;
		System.out.println(x2.x+ " "+x2.y);

	}*/
}
