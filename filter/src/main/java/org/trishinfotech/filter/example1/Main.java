package org.trishinfotech.filter.example1;

import java.util.Arrays;
import java.util.List;

import org.trishinfotech.filter.Deptt;
import org.trishinfotech.filter.Employee;
import org.trishinfotech.filter.Gender;

public class Main {

	public static void main(String[] args) {
		List<Employee> employees = Arrays.asList(
				new Employee.EmployeeBuilder().empNo(101).name("Brijesh").gender(Gender.MALE).depttName(Deptt.ENG)
						.salary(140000).projectName("Builder Pattern").build(),
				new Employee.EmployeeBuilder().empNo(102).name("Racheal").gender(Gender.FEMALE).depttName(Deptt.ENG)
						.salary(90000).projectName("Factory Pattern").build(),
				new Employee.EmployeeBuilder().empNo(103).name("Kim").gender(Gender.MALE).depttName(Deptt.HR)
						.salary(150000).projectName("Editorial").build(),
				new Employee.EmployeeBuilder().empNo(104).name("Micheal").gender(Gender.FEMALE).depttName(Deptt.ENG)
						.salary(80000).projectName("Decorator Pattern").build(),
				new Employee.EmployeeBuilder().empNo(105).name("Martin").gender(Gender.MALE).depttName(Deptt.SUPPORT)
						.salary(65000).projectName("Web Management").build(),
				new Employee.EmployeeBuilder().empNo(106).name("Pierce").gender(Gender.MALE).depttName(Deptt.HR)
						.salary(130000).projectName("Audit").build(),
				new Employee.EmployeeBuilder().empNo(107).name("Anjali").gender(Gender.FEMALE).depttName(Deptt.ENG)
						.salary(60000).projectName("State Pattern").build(),
				new Employee.EmployeeBuilder().empNo(108).name("Angelina").gender(Gender.FEMALE).depttName(Deptt.ENG)
						.salary(70000).projectName("Flyweight Pattern").build(),
				new Employee.EmployeeBuilder().empNo(109).name("Hemant").gender(Gender.MALE).depttName(Deptt.HR)
						.salary(170000).projectName("Audit").build(),
				new Employee.EmployeeBuilder().empNo(110).name("Mike").gender(Gender.MALE).depttName(Deptt.IT)
						.salary(150000).projectName("Networking").build());

		System.out.println("Print all employees...");
		printEmployees(employees);
		List<Employee> maleEmployees = (new MaleFilter().apply(employees));
		System.out.println("Print all Male employees...");
		printEmployees(maleEmployees);
		List<Employee> maleEngEmployees = (new AndFilter(new MaleFilter(), new EngFilter()).apply(employees));
		System.out.println("Print all Male And ENG employees...");
		printEmployees(maleEngEmployees);
		List<Employee> femaleOrHREmployees = (new OrFilter(new FemaleFilter(), new HRFilter()).apply(employees));
		System.out.println("Print all Female Or HR employees...");
		printEmployees(femaleOrHREmployees);
	}

	private static void printEmployees(List<Employee> employees) {
		System.out.println("======================================================================");
		employees.stream().forEach(employee -> System.out.println(employee));
		System.out.println("======================================================================");
	}
}
