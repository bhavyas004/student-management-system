package studentRecordManagementSystem;


public class Student {
	private int studentId;
	private String name;
	private int marks;
	private char section;
	private boolean isPassed;
	private StringBuffer remarks;
	protected static int studentCount = 0;
	public static final String InstituteName = "SMARTEX INSTITUTE";
	//constructors for different functionalities
	public Student() {
		studentCount++;
	}
	public Student(int studentId, String name, int marks,char section ) throws InvalidMarkException {
		if (marks<0 || marks > 100) throw new InvalidMarkException("Marks Should be in the range between 0 and 100.");
		this.studentId = studentId;
		this.name = name;
		this.marks = marks;
		this.isPassed = marks >= 40 ;
		this.remarks = new StringBuffer();
		studentCount++;
		
	}
	public Student(Student other) {
		this.studentId = other.studentId;
		this.name = other.name;
		this.marks = other.marks;
		this.section = other.section;
		this.isPassed = other.isPassed;
		this.remarks = new StringBuffer(other.remarks);
		studentCount++;
	}
	public void printDetails() {
		System.out.println("ID: "+studentId);
		System.out.println("NAME: " + name);
		System.out.println("Marks: "+marks);
		System.out.println("Pass: "+isPassed);
		System.out.println("Remarks: "+remarks.toString());
	}
	public void addRemarks(String r) {
		remarks.append(r).append(" ");
	}
	public void compareNames(Student other) {
		System.out.println("Using == " + (this.name == other.name));
		System.out.println("Using equals()method: " + this.name.equals(other.name));
	}
	public char calculateGrade() {
		if(marks>=90) return 'A';
		if(marks>=75) return 'B';
		if(marks>=60) return 'C';
		if(marks>=40) return 'D';
		else return 'F';
		
	}
	public final void finalizeRecord() {
		System.out.println("Finalizing Record for: "+name);
		
	}
	public void displayBasicInfo() {
		System.out.println("ID: "+studentId+", Name:"+name);
		
	}
	public String getType() {
		return "Regular Student";
	}

}
