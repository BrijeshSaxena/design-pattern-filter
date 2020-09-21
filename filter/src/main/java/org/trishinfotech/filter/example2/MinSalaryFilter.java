package org.trishinfotech.filter.example2;

import org.trishinfotech.filter.Employee;

public class MinSalaryFilter implements Filter {

	private int minSalary;
	
	public MinSalaryFilter(int minSalary) {
		super();
		this.minSalary = minSalary;
	}

	@Override
	public boolean apply(Employee employee) {
		return (employee != null && employee.getSalary() >= minSalary);
	}

}
