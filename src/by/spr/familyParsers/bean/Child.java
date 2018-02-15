package by.spr.familyParsers.bean;

public class Child extends Human {

	private String gender;
		
	public Child() {
		
	}

	public Child(String name, String surname, int age) {
		super(name, surname, age);
		
	}

	public Child(String name, String surname, int age, String gender) {
		super(name, surname, age);
		this.gender = gender;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
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
		Child other = (Child) obj;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Child [gender=" + gender + ", getName()=" + getName() + ", getSurname()=" + getSurname() + ", getAge()="
				+ getAge() + "]";
	}
	
	

}
