package by.spr.familyParsers.bean;

public class Mother extends Human {
	
	private String madenName;

	public Mother() {
		super();
	}

	public Mother(String name, String surname, int age) {
		super(name, surname, age);
	}
	
	public Mother(String name, String surname, int age, String madenName) {
		super(name, surname, age);
		this.madenName = madenName;
	}

	public String getMadenName() {
		return madenName;
	}

	public void setMadenName(String madenName) {
		this.madenName = madenName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((madenName == null) ? 0 : madenName.hashCode());
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
		Mother other = (Mother) obj;
		if (madenName == null) {
			if (other.madenName != null)
				return false;
		} else if (!madenName.equals(other.madenName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Mother [madenName=" + madenName + ", getName()=" + getName() + ", getSurname()=" + getSurname()
				+ ", getAge()=" + getAge() + "]";
	}

	
	
	
	
	
	
	
	

}
