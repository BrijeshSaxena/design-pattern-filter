package org.trishinfotech.filter.example1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.trishinfotech.filter.Deptt;
import org.trishinfotech.filter.Employee;

public class EngFilter implements Filter {

	@Override
	public List<Employee> apply(List<Employee> employees) {
		List<Employee> filteredEmployees = new ArrayList<Employee>();
		// implementing using lambda expressions
		if (employees != null) {
			filteredEmployees.addAll(employees.stream().filter(employee -> Deptt.ENG.equals(employee.getDepttName()))
					.collect(Collectors.toList()));
		}
		return filteredEmployees;
	}

}
