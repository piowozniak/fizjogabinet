package pl.fizjogabinet.model.enums;
import java.util.function.Supplier;
import java.util.Arrays;

import pl.fizjogabinet.model.entity.*;

public enum FizjoGabinetFactoryE {
	
	PATIENT("patient", Patient::new),
	MEDICALHISTORY("medicalhistory", MedicalHistory::new),
	HYPOTHESIS("hypothesis", Hypothesis::new),
	VISIT("visit", Visit::new),
	ATTACHMENT("attachment", Attachement::new),
	THERAPIST("therapist", Therapist::new),
	USER("user", User::new);
	
	public final Supplier<Object> factory;
	public final String name;
	
	FizjoGabinetFactoryE(String name, Supplier<Object> factory) {
		this.name = name;
		this.factory = factory;
	}
	
	public static Object objectFactory(String objectName) {
		FizjoGabinetFactoryE object = Arrays.asList(FizjoGabinetFactoryE.values()).stream().filter(o -> o.name.equalsIgnoreCase(objectName)).findFirst().orElse(null);
		return object == null ? null : object.factory.get();
	}

	public String getName() {
		return name;
	}

	public Supplier<Object> getFactory() {
		return factory;
	}
	

}
