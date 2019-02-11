package pl.fizjogabinet.model.dto;

public class FizjoGabinetObject<T> {
	
	private T fizjoObject;

	public FizjoGabinetObject(Object objectFactory) {
		super();
		this.fizjoObject = (T) objectFactory;
	}

	public T getFizjoObject() {
		return fizjoObject;
	}

}
