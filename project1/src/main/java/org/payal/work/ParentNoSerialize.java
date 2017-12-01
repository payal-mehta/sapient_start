package org.payal.work;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ParentNoSerialize {
	public static void main(String[] args)  {
		System.out.println("Hello");
		Parent1 child=new Parent1();
		try {
			ObjectOutputStream objectOutputStream=new ObjectOutputStream(new FileOutputStream("a.txt"));

			objectOutputStream.writeObject(child);
		} catch (IOException e) {
			System.out.println("in exceptions");
		}
	}
}
class Parent1 implements Serializable{
	String name;
	private void readObject(ObjectInputStream aInputStream) 
	{ 
		System.out.println("Parent1 readObject");

		try {
			throw new NotSerializableException();
		} catch (NotSerializableException e) {
			System.out.println("Parent1 readObject ex");
			e.printStackTrace();
		}
	}
	private void writeObject(ObjectOutputStream aInputStream) 
	{   
		System.out.println("Parent1 WriteObject");

		try {
			throw new NotSerializableException();
		} catch (NotSerializableException e) {
			System.out.println("Parent1 WriteObject ex");
			e.printStackTrace();
		}
	}
}
class Childnew1 extends Parent1 {
	String name;

}
