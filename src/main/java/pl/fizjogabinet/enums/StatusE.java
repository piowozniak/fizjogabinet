package pl.fizjogabinet.enums;

public enum StatusE {
	
	ACTIVE("ACTIVE"),
	RELEASED("RELEASED"),
	SUBMITTED("SUBMITTED"),
	DRAFT("DRAFT"),
	NONACTIVE("NONACTIVE"),
	ACCEPTED("ACCEPTED"),
	SIGNED("SIGNED"),
	REJECTED("REJECTED"),
	ACTIVEUSER("A"),
	NONACTIVEUSER("N");
	
	private final String value;

	private StatusE(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
	
}
