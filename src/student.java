import java.util.Date;

public class student {
	private String name;
	private String CIN;
	private String rawInput;
	private Date timeStamp;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCIN() {
		return CIN;
	}
	public void setCIN(String cIN) {
		CIN = cIN;
	}
	public String getRawStripeInput() {
		return rawInput;
	}
	public void setRawStripeInput(String rawStripeInput) {
		this.rawInput = rawStripeInput;
	}
	
}
