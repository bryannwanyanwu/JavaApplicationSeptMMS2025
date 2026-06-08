public class RecursiveMethod{
	public static void main(String[] args){
		displayName("John Doe")
	}
	public static void main displayName(){
		String name = "John Doe";
		System.out.printf("your name is %s%n", name);
	  displayName("John Doe");
	}
}