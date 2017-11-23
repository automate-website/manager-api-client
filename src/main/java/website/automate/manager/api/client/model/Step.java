package website.automate.manager.api.client.model;

public class Step {
	enum STATUS {
		SUCCESS,
		ERROR
	}
		
	private STATUS status;

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
