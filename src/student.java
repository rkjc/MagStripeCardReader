import java.text.SimpleDateFormat;
import java.util.Date;

public class Student {
	private String name;
	private String CIN;
	private String rawInput;
	private String timeStamp;
	
	public Student(){
		name = "";
		CIN = "";
		rawInput = "";
		timeStamp = new SimpleDateFormat("yyyy'-'MM'-'dd'_'hh'.'mm").format(new Date());
	}
	
	public Student(String inputStr) {
		name = "";
		CIN = "";
		rawInput = inputStr;
		timeStamp = new SimpleDateFormat("yyyy'-'MM'-'dd'_'hh'.'mm").format(new Date());
	}

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
	
	public boolean parseInputForName(){
		//this.name = "bobby";
		//indexOf(int ch)  
		return true;
	}
	
}
