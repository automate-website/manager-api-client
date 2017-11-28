package website.automate.manager.api.client.model;

public class Step {
	public enum STATUS {
		SUCCESS,
		ERROR
	}
		
	public STATUS status;

	private int index;
		


	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public STATUS getStatus() {
		return status;
	}

	public void setStatus(STATUS status) {
		this.status = status;
	}
	
	
}
