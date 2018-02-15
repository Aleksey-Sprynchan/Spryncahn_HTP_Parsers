package by.spr.familyParsers.enam;

public enum StAXFamilyTagName {
	
	FAMILY, MOTHER, FATHER, CHILD, CHILDREN, NAME, SURNAME, AGE, MAIDEN_NAME, SALARY, GENDER;
	
	public static StAXFamilyTagName getElementTagName(String element) {
		
		switch (element) {
		case "family":
			return FAMILY;
		case "mother":
			return MOTHER;
		case "father":
			return FATHER;
		case "child":
			return CHILD;
		case "children":
			return CHILDREN;
		case "name":
			return NAME;
		case "surname":
			return SURNAME;
		case "age":
			return AGE;
		case "maiden-name":
			return MAIDEN_NAME;
		case "salary":
			return SALARY;
		case "gender":
			return GENDER;
		default :
			 throw new EnumConstantNotPresentException(StAXFamilyTagName.class, element);	
		}
		
	}

}
