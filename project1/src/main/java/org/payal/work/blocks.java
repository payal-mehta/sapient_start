package org.payal.work;
class Par {
static{
	System.out.println("1");
}
{
	System.out.println("2");
}
Par(){
	System.out.println("3");
}
}
public class blocks extends Par {

static{
	System.out.println("4");
}
{
	System.out.println("5");
}
blocks(){
	System.out.println("6");
}

public static void main(String[] args) {
	blocks blocks=new blocks();
}
}

