package pl.fizjogabinet.enums;

public enum EventE {
	
	COMPETITION("COMPETITION"),
	SEMINAR("SEMINAR"),
	CAMP("CAMP");
	
	private final String value;
	

	private EventE(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
