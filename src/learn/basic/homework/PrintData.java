package learn.basic.homework;

public class PrintData {

	public void printStudents (){
		Student[] studentArray  = new Student[3];
		Student one = new Student();
		one.setFirstName("Chinmay");
		one.setLastName("Kulkarni");
		
		Student two = new Student();
		two.setFirstName("Mohan");
		two.setLastName("Shastri");
		
		
		Student three = new Student();
		three.setFirstName("Rohan");
		three.setLastName("Trivedi");
		
		studentArray[0] = one;
		studentArray[1] = two;
		studentArray[2] = three;
		
		for(Student s : studentArray){
			System.out.println(s.getFirstName());
		}
		
	}
}
