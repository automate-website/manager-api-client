package website.automate.manager.api.client.model;

public class Step {
	enum STATUS {
		SUCCESS,
		ERROR
	}
	
	STATUS status;

	public STATUS getStatus() {
		return status;
	}

	public void setStatus(STATUS status) {
		this.status = status;
	}
	
	
}
