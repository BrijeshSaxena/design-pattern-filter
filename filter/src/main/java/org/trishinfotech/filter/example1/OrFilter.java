package org.trishinfotech.filter.example1;

import java.util.ArrayList;
import java.util.List;

import org.trishinfotech.filter.Employee;

public class OrFilter implements Filter {

	private Filter filter;
	private Filter anotherFilter;

	public OrFilter(Filter Filter, Filter anotherFilter) {
		this.filter = Filter;
		this.anotherFilter = anotherFilter;
	}

	@Override
	public List<Employee> apply(List<Employee> employees) {
		List<Employee> firstFilteredEmployees = filter.apply(employees);
		List<Employee> secondFilterEmployees = anotherFilter.apply(employees);
		// now lets make or Filter.
		// first copy all first Filter filtered employees.
		// now add all second Filter filtered employees which are NOT already in the list
		// via first Filter employees.
		List<Employee> orFilteredEmployees = new ArrayList<Employee>(firstFilteredEmployees);
		secondFilterEmployees.removeAll(firstFilteredEmployees);
		orFilteredEmployees.addAll(secondFilterEmployees);
		return orFilteredEmployees;
	}
	
}
