package org.trishinfotech.filter.example2;

import org.trishinfotech.filter.Employee;
import org.trishinfotech.filter.Gender;

public class MaleFilter implements Filter {

	@Override
	public boolean apply(Employee employee) {
		return (employee != null && Gender.MALE.equals(employee.getGender()));
	}

}
