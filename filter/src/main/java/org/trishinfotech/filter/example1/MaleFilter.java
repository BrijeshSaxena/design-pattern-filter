package org.trishinfotech.filter.example1;

import java.util.ArrayList;
import java.util.List;

import org.trishinfotech.filter.Employee;
import org.trishinfotech.filter.Gender;

public class MaleFilter implements Filter {

	@Override
	public List<Employee> apply(List<Employee> employees) {
		// implementing in old way
		List<Employee> filteredEmployees = new ArrayList<Employee>();
		if (employees != null) {
			for (Employee employee : employees) {
				if (Gender.MALE.equals(employee.getGender())) {
					filteredEmployees.add(employee);
				}
			}
		}
		return filteredEmployees;
	}

}
