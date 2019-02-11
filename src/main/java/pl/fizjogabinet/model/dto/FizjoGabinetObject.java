package pl.fizjogabinet.model.dto;

public class FizjoGabinetObject<T> {
	
	private T fizjoObject;

	public FizjoGabinetObject(T o) {
		super();
		this.fizjoObject = o;
	}

	public T getFizjoObject() {
		return fizjoObject;
	}

}
