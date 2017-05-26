package learn.basic.homework;

public class JavaClassBasic {
	/*
	 * Class contains following things
	 * 1) Constructor: 
	 * 2) Methods/Function/Procedure:
	 * 		a) local variables
	 * 3) Attributes/Variables: 
	 * */
	
	// What are difference between Constructor and Method
	// 1) Name of Constructor is always the name of Class. It's not the case with method
	// 2) Constructor is called/executed as : new ClassName(); While method is executed as obj.MethodName()
	// 3) Constructor does not have a return type
	// 4) For a given object Constructor is executed only once in its lifecycle. Method can be executed many times.
	// 5) In most cases, Constructor has 'public' access modifier, Method can be public/private/protected/default
	
	// This is a default constructor
	public JavaClassBasic(){
		
	}
	
	// Global Variable example
	private int iamGlobalVariable;
	
	
	// This is a parameterized constructors
	public JavaClassBasic(int a, int b){
		
	}
	
	// This is an example of Method
	public static void main(String[] args) {
		// Local Variable example
		int iamLocalVariable = 10;
		
		System.out.println("Hello world");
	}
	
	// Global variable example
	private String iamAnotherGlobalVariable;
}
