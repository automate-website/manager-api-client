package website.automate.manager.api.client.model;

public class Step {
	public enum Status {
		SUCCESS,
		ERROR,
		FAILURE
	}
		
	public Status status;

	private int index;
		


	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	
	
}
