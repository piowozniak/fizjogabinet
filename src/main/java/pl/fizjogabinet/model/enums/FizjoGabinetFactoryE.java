package pl.fizjogabinet.model.enums;
import java.util.function.Supplier;

import pl.fizjogabinet.model.entity.Patient;

public enum FizjoGabinetFactoryE {
	
	PATIENT("Patient", Patient::new);
	
	public final Supplier<Object> factory;
	public final String nazwa;
	
	FizjoGabinetFactoryE(String nazwa, Supplier<Object> factory) {
		this.nazwa = nazwa;
		this.factory = factory;
	}

	public String getNazwa() {
		return nazwa;
	}

	public Supplier<Object> getFactory() {
		return factory;
	}
	

}
