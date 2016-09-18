package komarica.slavko.examples.lambdas;

public class LambdaExample {
	
	public static MyFunctionalInterface myFunctionalInterface;
	
	public static void createWithLambda(){
		myFunctionalInterface = (message) -> {
			System.out.println("Hello from lambda 1. This is your message: \n"+message);
		};		
	}
	
	public static void createWithLambda2(){
		myFunctionalInterface = (message) -> {
			System.out.println("Hello from lambda 2. This is your message: \n"+message);
		};		
	}
	
	public static void createdWithFunctionRefference(){
		myFunctionalInterface = System.out::println;
	}	
	
	public static void createWithInnerClass(){
		myFunctionalInterface = new MyFunctionalInterface() {			
			@Override
			public void simplePrintFunction(String message) {
				System.out.println("Hello from inner class 1. This is your message: \n"+message);				
			}
		};
	}
	
	public static void createWithInnerClass2(){
		myFunctionalInterface = new MyFunctionalInterface() {			
			@Override
			public void simplePrintFunction(String message) {
				System.out.println("Hello from inner class 2. This is your message: \n"+message);				
			}
		};
	}

	public static void main(String[] args) {
		createWithLambda();
		myFunctionalInterface.simplePrintFunction("Hello world");
		createWithLambda2();
		myFunctionalInterface.simplePrintFunction("Hello world 2");
		createWithInnerClass();
		myFunctionalInterface.simplePrintFunction("Hello world 3");
		createWithInnerClass2();
		myFunctionalInterface.simplePrintFunction("Hello world 4");
		createdWithFunctionRefference();
		myFunctionalInterface.simplePrintFunction("Java has function pointers know!");
	}
	
}
