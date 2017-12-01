package org.payal.work;

import java.util.ArrayList;

public class ClassLoaderTest {
public static void main(String[] args) {
	System.out.println(ClassLoaderTest.class.getClassLoader());
	ArrayList<Integer> str=new ArrayList<Integer>();
	System.out.println(String.class.getClassLoader());
	try {          
        //printing ClassLoader of this class
        System.out.println("ClassLoaderTest.getClass().getClassLoader() : "
                             + ClassLoaderTest.class.getClassLoader());

      
        //trying to explicitly load this class again using Extension class loader
        Class.forName("test.ClassLoaderTest", true 
                        ,  ClassLoaderTest.class.getClassLoader().getParent());
    } catch (ClassNotFoundException ex) {
    	System.out.println("inexception  "+ClassLoaderTest.class.getName());
    }

}
}
