package org.trishinfotech.filter;

public class Employee {

	private int empNo;
	private String name;
	private Gender gender;
	private Deptt depttName;
	private int salary;
	private int mgrEmpNo;
	private String projectName;

	public Employee(EmployeeBuilder employeeBuilder) {
		if (employeeBuilder == null) {
			throw new IllegalArgumentException("Please provide employee builder to build employee object.");
		}
		if (employeeBuilder.empNo <= 0) {
			throw new IllegalArgumentException("Please provide valid employee number.");
		}
		if (employeeBuilder.name == null || employeeBuilder.name.trim().isEmpty()) {
			throw new IllegalArgumentException("Please provide employee name.");
		}
		this.empNo = employeeBuilder.empNo;
		this.name = employeeBuilder.name;
		this.gender = employeeBuilder.gender;
		this.depttName = employeeBuilder.depttName;
		this.salary = employeeBuilder.salary;
		this.mgrEmpNo = employeeBuilder.mgrEmpNo;
		this.projectName = employeeBuilder.projectName;
	}

	public int getEmpNo() {
		return empNo;
	}

	public String getName() {
		return name;
	}

	public Gender getGender() {
		return gender;
	}

	public Deptt getDepttName() {
		return depttName;
	}

	public int getSalary() {
		return salary;
	}

	public int getMgrEmpNo() {
		return mgrEmpNo;
	}

	public String getProjectName() {
		return projectName;
	}

	@Override
	public String toString() {
		// StringBuilder class also uses Builder Design Pattern with implementation of
		// java.lang.Appendable interface
		StringBuilder builder = new StringBuilder();
		builder.append("Employee [empNo=").append(empNo).append(", name=").append(name).append(", gender=")
				.append(gender).append(", depttName=").append(depttName).append(", salary=").append(salary)
				.append(", mgrEmpNo=").append(mgrEmpNo).append(", projectName=").append(projectName).append("]");
		return builder.toString();
	}

	public static class EmployeeBuilder {
		private int empNo;
		protected String name;
		protected Gender gender;
		protected Deptt depttName;
		protected int salary;
		protected int mgrEmpNo;
		protected String projectName;

		public EmployeeBuilder() {
			super();
		}

		public EmployeeBuilder empNo(int empNo) {
			this.empNo = empNo;
			return this;
		}

		public EmployeeBuilder name(String name) {
			this.name = name;
			return this;
		}

		public EmployeeBuilder gender(Gender gender) {
			this.gender = gender;
			return this;
		}

		public EmployeeBuilder depttName(Deptt depttName) {
			this.depttName = depttName;
			return this;
		}

		public EmployeeBuilder salary(int salary) {
			this.salary = salary;
			return this;
		}

		public EmployeeBuilder mgrEmpNo(int mgrEmpNo) {
			this.mgrEmpNo = mgrEmpNo;
			return this;
		}

		public EmployeeBuilder projectName(String projectName) {
			this.projectName = projectName;
			return this;
		}

		public Employee build() {
			Employee emp = null;
			if (validateEmployee()) {
				emp = new Employee(this);
			} else {
				System.out.println("Sorry! Employee objects can't be build without required details");
			}
			return emp;
		}

		private boolean validateEmployee() {
			return (empNo > 0 && name != null && !name.trim().isEmpty());
		}
	}
}
