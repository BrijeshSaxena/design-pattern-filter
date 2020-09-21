package org.trishinfotech.filter.example1;

import java.util.List;

import org.trishinfotech.filter.Employee;

public class AndFilter implements Filter {

	private Filter filter;
	private Filter anotherFilter;

	public AndFilter(Filter filter, Filter anotherFilter) {
		this.filter = filter;
		this.anotherFilter = anotherFilter;
	}

	@Override
	public List<Employee> apply(List<Employee> employees) {
		List<Employee> firstFilteredEmployees = filter.apply(employees);
		List<Employee> secondFilterEmployees = anotherFilter.apply(firstFilteredEmployees);
		return secondFilterEmployees;
	}
	
}
