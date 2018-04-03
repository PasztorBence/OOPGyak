public class Employee {
	private String employeeName;
	private long salary;
	private int age;
	
	static int PensionRemainingAge;
	
	public Employee(String employeeName, long salary, int age) {
		super();
		this.employeeName = employeeName;
		this.salary = salary;
		this.age = age;
	}
	public Employee(String employeeName, int age) {
		super();
		this.employeeName = employeeName;
		this.age = age;
		this.salary = age*1000;
	}
	
	public int getRemainingYearsUntilPension(){
		return PensionRemainingAge-getAge();
	}
	
	public long increaseSalary (long increase,long employeeSalary){
		return employeeSalary+=increase;
	}
	public String displayInfo(){
		return "Salary:"+this.salary+" Name:"+this.employeeName;
	}
	public boolean isInSalaryRange(long salaryStart,long SalaryEnd){
		if (this.salary>salaryStart && this.salary<salaryStart) {
			return true;
		}
		else return false;
	}
	public long getTax(){
		return (long) (this.salary*0.16);
	}
	public boolean hasHigherSalary(Employee employee){
		if (this.salary>employee.salary) {
			return true;
		} else return false;
	}
	public static Employee getYoungerEmployee(Employee employee1,Employee employee2){
		if (employee1.getRemainingYearsUntilPension()>employee2.getRemainingYearsUntilPension()) {
			return employee2;
		} else return employee1;
	}
	
	
	//gettersetters
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public long getSalary() {
		return salary;
	}
	public void setSalary(long salary) {
		this.salary = salary;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public static int getPensionRemainingAge() {
		return PensionRemainingAge;
	}
	public static void setPensionRemainingAge(int pensionRemainingAge) {
		PensionRemainingAge = pensionRemainingAge;
	}
}
