package org.trishinfotech.filter.example2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
		List<Employee> maleEmployees = applyFilter(new MaleFilter(), employees);
		System.out.println("Print all Male employees...");
		printEmployees(maleEmployees);
		List<Employee> maleEngEmployees = applyFilter(new AndFilter(new MaleFilter(), new MinSalaryFilter(140000)), employees);
		System.out.println("Print all Male And Min Salary 140000 employees...");
		printEmployees(maleEngEmployees);
		// now lets try the same with the help of Java Lambda Expressions...
		System.out.println("\n\n\nnow lets try the same with the help of Java Lambda Expressions...");
		List<Employee> maleEmployeesUsingLambda = employees.stream()
				.filter(employee -> Gender.MALE.equals(employee.getGender())).collect(Collectors.toList());
		System.out.println("Print all Male employees using lambda...");
		printEmployees(maleEmployeesUsingLambda);
		List<Employee> maleEngEmployeesUsingLambda = employees.stream()
				.filter(employee -> Gender.MALE.equals(employee.getGender()))
				.filter(employee -> Deptt.ENG.equals(employee.getDepttName())).collect(Collectors.toList());
		System.out.println("Print all Male And ENG employees using lambda...");
		printEmployees(maleEngEmployeesUsingLambda);
	}

	private static List<Employee> applyFilter(Filter filter, List<Employee> employees) {
		return employees.stream().filter(employee -> filter.apply(employee)).collect(Collectors.toList());
	}

	private static void printEmployees(List<Employee> employees) {
		System.out.println("======================================================================");
		employees.stream().forEach(employee -> System.out.println(employee));
		System.out.println("======================================================================");
	}
}
