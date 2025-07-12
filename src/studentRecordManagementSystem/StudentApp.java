package studentRecordManagementSystem;
import java.util.*;
public class StudentApp {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Student> students = new ArrayList<>();
		int option ;
		while(true) {
			// Runs until the given option is correct
			System.out.println("Welcome to Smartex Student System");
			System.out.println("1.Add Student");
			System.out.println("2.Display Student Details");
			System.out.println("3.Append Remarks");
			System.out.println("4.Calculate Grade");
			System.out.println("5.Compare Names");
			System.out.println("6.Simulate Exception");
			System.out.println("7.Exit");
			System.out.println("Enter your Option: ");
			option = sc.nextInt();
			try {
				switch(option){
				case 1 :
					//Adding Student Details
					System.out.println("Enter Student Details:");
					System.out.println("Enter Student ID");
					int id = sc.nextInt();
					boolean idAvail = false;
					for(Student s :students) {
						if (s.getStudentId() == id) {
							System.out.println("Student Id already exists");
							idAvail = true;
							break;
						}
					}
					if (!idAvail) {
						System.out.println("Enter Name");
						String name = sc.next();
						System.out.println("Enter Marks:");
						int marks = sc.nextInt();
						
						System.out.println("Enter Section:");
						char section = sc.next().charAt(0);
						System.out.print("Is this a scholar student? (yes/no): ");
	                    String ch = sc.next();
						if (ch.equals("yes")) {
							System.out.println("Enter Scholarship Amount: ");
							int schAmount = sc.nextInt();
							students.add(new ScholarStudent(id,name,marks,section,schAmount));
						} else {
							students.add(new Student(id,name,marks,section));
						}
					}
						
					break;
				case 2 :
					//Print Student Details
					if(students.size()==0) {
						System.out.println("No students available");
						break;
					}
					System.out.println("Enter Student Id");
					int idP = sc.nextInt();
					sc.nextLine();
					boolean flag = false;
					for (Student s : students) {
						if (s.getStudentId() == idP) {
							s.printDetails();
							flag = true;
							break;
						}
					}
					if (!flag) {
						System.out.println("No student found with given id: " + idP);
					}
					break;
				case 3 :
					//Adding Remarks 
					if(students.size()==0) {
						System.out.println("No students available");
						break;
					}
					System.out.println("Enter Student Id");
					int idx = sc.nextInt();
					sc.nextLine();
					boolean found = false;
					for (Student s : students) {
					    if (s.getStudentId() == idx) {
					    	System.out.println("Enter Remark:");
							String remark = sc.nextLine();
					        s.addRemarks(remark);
					        System.out.println("Remark added to student: " + idx);
					        found = true;
					        break;
					    }
					}
					if (!found) {
					    System.out.println("No student found with ID: " + idx);
					}
					break;
				case 4 :
					//Calculate Grade
					if(students.size()==0) {
						System.out.println("No students available");
						break;
					}
					System.out.println("Enter Student Id");
					int idg = sc.nextInt();
					sc.nextLine();
					boolean avail = false;
					for (Student s : students) {
					    if (s.getStudentId() == idg) {
					        System.out.println(s.getType() + " Grade: " + s.calculateGrade());
					        avail = true;
					        break;
					    }
					}
					if (!avail) {
					    System.out.println("No student found with ID: " + idg);
					}
					
                    break;
				case 5 :
					//Compare Student Details
					if(students.size()==0) {
						System.out.println("No students available");
						break;
					}
					System.out.println("Enter two student IDS to compare names: ");
					int id1 = sc.nextInt();
					int id2 = sc.nextInt();
					Student s1 = null;
					Student s2 = null;
					for(Student s: students) {
						if(s.getStudentId() == id1) s1 = s;
						if(s.getStudentId() == id2) s2 = s;		
					}
					if (s1 != null && s2 != null) {
						s1.compareNames(s2);
					} else {
						System.out.println("One or both Students are not found ");
					}
					break;
				case 6 :
					//Simulate Exception
					System.out.println("Simulating exception:divide by zero");
					int x = 10/0;
					break;
				case 7 :
					System.out.println("Bye");
					System.out.println("Have a nice day");
					sc.close();
					return;
				default :
					System.out.println("Invalid Choice! ");
				}
			} catch(InvalidMarkException e) {
				System.out.println("Invalid Marks: " + e.getMessage());
			} catch(ArithmeticException e) {
				System.out.println("Arthimetic Exception Caught" + e.getMessage());
			} catch(Exception e) {
				System.out.println("Something went wrong: " + e.getMessage());
			} finally {
				System.out.println("Operation Completed");
			}
		}
	}
}
