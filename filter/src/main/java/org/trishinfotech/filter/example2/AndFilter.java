package org.trishinfotech.filter.example2;

import org.trishinfotech.filter.Employee;

public class AndFilter implements Filter {

	private Filter filter;
	private Filter anotherFilter;

	public AndFilter(Filter filter, Filter anotherFilter) {
		this.filter = filter;
		this.anotherFilter = anotherFilter;
	}

	@Override
	public boolean apply(Employee employee) {
		boolean firstFilter = filter.apply(employee);
		boolean secondFilter = anotherFilter.apply(employee);
		return firstFilter && secondFilter;
	}
	
}
