package org.trishinfotech.filter.example2;

import org.trishinfotech.filter.Employee;

public class OrFilter implements Filter {

	private Filter filter;
	private Filter anotherFilter;

	public OrFilter(Filter Filter, Filter anotherFilter) {
		this.filter = Filter;
		this.anotherFilter = anotherFilter;
	}

	@Override
	public boolean apply(Employee employee) {
		boolean firstFilter = filter.apply(employee);
		boolean secondFilter = anotherFilter.apply(employee);
		return firstFilter || secondFilter;
	}
	
}
