package Q1;
/*
 * BroncoID: 014758458
 * Last Name: Siwiecki
 * First Name: Joseph
 */

public class Student 
{
	private String name;
	private String major;
	private double gpa;
	
	public Student()
	{
		
	}
	
	public Student(String name, String major, double gpa) 
	{
		this.name = name;
		this.major = major;
		this.gpa = gpa;
	}

	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}

	public String getMajor() 
	{
		return major;
	}

	public void setMajor(String major) 
	{
		this.major = major;
	}

	public double getGpa() 
	{
		return gpa;
	}

	public void setGpa(double gpa) 
	{
		this.gpa = gpa;
	}

	@Override
	// Created with Eclipse's toString generator
	public String toString() 
	{
		return "Student [name=" + name + ", major=" + major + ", gpa=" + gpa + "]";
	}
	
	public boolean equals(Student student)
	{
		if (!this.name.equals(student.name))
		{
			return false;
		}
		
		if (!this.major.equals(student.major))
		{
			return false;
		}
		
		return true;
	}
	
}
