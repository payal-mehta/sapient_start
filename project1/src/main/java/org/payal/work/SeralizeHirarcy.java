package org.payal.work;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SeralizeHirarcy extends Child implements Serializable {
	SeralizeHirarcy(){
		System.out.println("Super Child");
	}
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Parent hirarcy=new SeralizeHirarcy();
		System.out.println(" My agent"+MyAgent.getObjectSize(hirarcy));
		
		FileOutputStream fileOutputStream=new FileOutputStream("file.txt");
		ObjectOutputStream objectOutputStream =new ObjectOutputStream(fileOutputStream);
		objectOutputStream.writeObject(hirarcy);
		 FileInputStream fileInputStream=new FileInputStream("file.txt");
		 ObjectInputStream inputStream=new ObjectInputStream(fileInputStream);
		 Parent x=(SeralizeHirarcy)inputStream.readObject();
	}
}
class Parent {
	Parent(){
		System.out.println("Parent");
	}
}

class Child extends Parent {
	Child(){
		System.out.println("Child");
	}
}
