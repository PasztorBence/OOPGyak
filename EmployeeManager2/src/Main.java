import java.io.ObjectInputStream.GetField;
import java.util.Scanner;


public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("please input the number of employees");
		int numberOfEmployees=scanner.nextInt();
		Employee[] employeeArray = new Employee[numberOfEmployees];
		
		for (int i = 0; i < employeeArray.length; i++) {
			System.out.println("please input the name of the employee: ");
			String tempName = scanner.next();
			System.out.println("please input the age of the employee: ");
			int tempAge = scanner.nextInt();
			
			employeeArray[i] = new Employee(tempName,tempAge);
			System.out.println(employeeArray[i]);
		}
		
		Employee.setPensionRemainingAge(5);
		
		for (Employee employee : employeeArray) {
			if (employee.getRemainingYearsUntilPension()<5) {
				System.out.println(employee);
			}
		}
		
		int avgAgeRemaining = 0;
		
		for (Employee employee : employeeArray) {
			avgAgeRemaining+=employee.getRemainingYearsUntilPension();
		}
		avgAgeRemaining/=employeeArray.length;
		
		for (Employee employee : employeeArray) {
			if (employee.getRemainingYearsUntilPension()>avgAgeRemaining) {
				System.out.println(employee);
			}
		}
		
		for (int i = 0; i < employeeArray.length; i++) {
			int max =i; 
				for (int j = 0; j < employeeArray.length; j++) {
					if (employeeArray[max].getRemainingYearsUntilPension()<employeeArray[j].getRemainingYearsUntilPension()) {
						max = j;
					}
				}
				Employee tempEmployee = new Employee(employeeArray[i].getEmployeeName(),employeeArray[i].getAge());
				employeeArray[i] = new Employee(employeeArray[i].getEmployeeName(),employeeArray[i].getAge());
				employeeArray[max] = new Employee(employeeArray[i].getEmployeeName(),employeeArray[i].getAge());
		}
			
		
	}

}
