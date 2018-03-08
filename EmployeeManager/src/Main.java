
public class Main {
	public static void main(String[] args) {
//		Employee employee = new Employee();
//	//	employee.employeeName="MindlessWorker";
//	//	employee.salary=1000;
//		
//		employee.setEmployeeName("MindlessWorker");
//		employee.setSalary(1000);
//		
//	//	employee.salary=employee.increaseSalary(500,employee.salary);
//	//	System.out.println(employee.displayInfo(employee.salary, employee.employeeName));
//		
//		Employee employee2 = new Employee();
//		employee2.setEmployeeName("Pista");
//		employee2.setSalary(2000);
//		
//		System.out.println(employee.displayInfo());
//		System.out.println(employee2.displayInfo());
//		
//		System.out.println(employee.isInSalaryRange(500, 3000));
//		System.out.println(employee.getTax());
//		System.out.println(employee.hasHigherSalary(employee2));
		
		//tömbfeltöltés
		Employee[] employeeArray = new Employee[10];
		for (int i = 0; i < employeeArray.length; i++) {
			employeeArray[i] = new Employee();
			employeeArray[i].setSalary(i*1000+i*200);
			employeeArray[i].setEmployeeName("Worker"+i);
		}
		
		//legnagyobb fizetésű dolgozó
		long max = 0;
		int maxid = 0;
		for (int i = 0; i < employeeArray.length; i++) {
			if (employeeArray[i].getSalary()>max) {
				maxid = i;
			}
		}
		System.out.println(employeeArray[maxid].getEmployeeName());
		
		//fizetés intervallum
		int db = 0;
		for (int i = 0; i < employeeArray.length; i++) {
			if (employeeArray[i].isInSalaryRange(0,10000)) {
				db++;
				System.out.println("1");
			}
		}
		System.out.println(db);
		
		//átlagfizetés
		double AverageSalary = 0;
		for (int i = 0; i < employeeArray.length; i++) {
			AverageSalary+=employeeArray[i].getSalary();
		}
		AverageSalary/=employeeArray.length;
		System.out.println(AverageSalary);
		
		//befizetett adó összege
		long sum = 0;
		for (int i = 0; i < employeeArray.length; i++) {
			sum+=employeeArray[i].getTax();
		}
		System.out.println(sum);
	}

}
