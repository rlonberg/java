package model;

public enum Mark {

	NONE("_"), X("X"), O("O");
	private String representation;

	Mark(String type) {
		this.representation = type;

	}

	String getRepresentation() {
		return this.representation;
	}

}
