package entity;

public class Reason {

	private boolean result = false;
	private String reason = null;
	
	public Reason(){}
	public Reason(boolean result, String reason) {
		super();
		this.result = result;
		this.reason = reason;
	}
	
	public boolean isResult() {
		return result;
	}
	public void setResult(boolean result) {
		this.result = result;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	
}
