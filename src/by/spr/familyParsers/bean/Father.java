package by.spr.familyParsers.bean;

public class Father extends Human {
	
	private int salary;

	public Father() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Father(String name, String surname, int age) {
		super(name, surname, age);
		// TODO Auto-generated constructor stub
	}

	public Father(String name, String surname, int age, int salary) {
		super(name, surname, age);
		this.salary = salary;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + salary;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Father other = (Father) obj;
		if (salary != other.salary)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Father [salary=" + salary + ", getName()=" + getName() + ", getSurname()=" + getSurname()
				+ ", getAge()=" + getAge() + "]";
	}

	
	

	
}
