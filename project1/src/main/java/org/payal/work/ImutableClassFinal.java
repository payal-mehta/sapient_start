package org.payal.work;

public class ImutableClassFinal {
	public static void main(String[] args) {
		Childnew childnew= new Childnew("Pa", 1);
		EmployeeFinal employeeFinal=(EmployeeFinal)childnew;
		System.out.println(employeeFinal.getName()+" "+employeeFinal.getId());
		childnew.setName("Payal");
		childnew.setId(6);
		System.out.println(employeeFinal.getName()+" "+employeeFinal.getId());
		
	}
}
class  EmployeeFinal{
	final String name;
	final int id;
	public int getId() {
		System.out.println("in Immutable");

		return id;
	}

	public String getName() {
		System.out.println("in Immutable");
		return name;
	}

	public EmployeeFinal(String name, int id) {
		super();
		this.name = name;
		this.id = id;
	}

	@Override
	public int hashCode() {

		return name.length()+id;
	}

	@Override
	public boolean equals(Object obj) {
		Employee e=(Employee)obj;

		return name.equals(e.name) && id==e.id;
	}
}
class Childnew extends EmployeeFinal{
	 String name;
	 int id;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Childnew(String name, int id) {
		super(name,id);
		this.name=name;
		this.id=id;
	}
	public String getName() {
		return name;
	}
}