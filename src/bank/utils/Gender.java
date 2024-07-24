package bank.utils;

public enum Gender {
    FEMALE ("FM", "Female"),
	MALE ("ML", "Male"),
	NON_BINARY ("NB", "Non-Binary"),
	OTHER ("OT", "Other");
	
	private String name;
	private String abreviation;
	
	private Gender(String name, String abreviation){
		this.name = name;
		this.abreviation = abreviation;
	}
	
	public String getName() {
        return name;
    }

    public String getAbreviation() {
        return abreviation;
    }

}
