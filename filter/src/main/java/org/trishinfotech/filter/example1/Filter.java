package org.trishinfotech.filter.example1;

import java.util.List;

import org.trishinfotech.filter.Employee;

public interface Filter {

	public List<Employee> apply(List<Employee> employees);
}
