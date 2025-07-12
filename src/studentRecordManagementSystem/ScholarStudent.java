package studentRecordManagementSystem;

public class ScholarStudent extends Student {
    private int scholarshipAmount;

    public ScholarStudent(int id, String name, int marks, char section, int scholarshipAmount) throws InvalidMarkException {
        super(id, name, marks + 5, section); // Adding bonus marks for scholar students
        this.scholarshipAmount = scholarshipAmount;
    }

    @Override
    public char calculateGrade() {
        return super.calculateGrade();
    }

    @Override
    public String getType() {
        return "Scholar Student";
    }
    
    @Override
    public void printDetails() {
		System.out.println("ID: "+super.getStudentId());
		System.out.println("NAME: " + super.getName());
		System.out.println("Marks: "+ super.getMarks());
		System.out.println("Pass: "+ super.isPassed());
		System.out.println("Scholarship amount: " + this.scholarshipAmount);
		System.out.println("Remarks: "+super.getRemarks().toString());
	}
    
    
}

