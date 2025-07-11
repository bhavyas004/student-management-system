package studentRecordManagementSystem;

public abstract class Record {
	public static void welcomeMessage() {
		System.out.println("Welcome to the Smartex Instutute!!!");
	}
	public abstract void finalizeRecord(); // final method which will be available in student class
}
