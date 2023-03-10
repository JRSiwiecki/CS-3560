package Q1;

public class StudentTest 
{
	public static void main(String[] args) 
	{
		// Instantiate two students
		// One with arguments, other with no arguments
		Student student1 = new Student("John", "CS", 3.5);
		Student student2 = new Student();
		
		// Update student2's name, major, and gpa
		student2.setName("Mary Ann");
		student2.setMajor("CE");
		student2.setGpa(3.3);
		
		// Print student1
		System.out.println(student1.toString());
		
		// Print student2
		System.out.println(student2.toString());
	}
}
