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
		boolean pass = true;
		int nameStartIndex = 0;
		int nameEndIndex = 0;
		String nameTemp1 = "";
		String nameTemp2 = "";
		String studentNum = "";
		// first check for device error
		if(rawInput.endsWith("E?")){
			System.out.println("failed with device error code");
			pass = false;
		} else {
			//check for specific errors

			// track-1 conditions
			if(!rawInput.startsWith("%B6048880000")){
				System.out.println("Card track-1 format not recognized");
				pass = false;
			} else {
				// check for and get name

				// ascii code for carrot symbol
				int carrot = 94;
				nameStartIndex = rawInput.indexOf(carrot);
				nameEndIndex = rawInput.indexOf(94, nameStartIndex  +1);

				//debug message
				System.out.println("nameStartIndex = " + nameStartIndex);
				System.out.println("nameEndIndex = " + nameEndIndex);

				if(nameStartIndex != -1 && nameEndIndex != -1){
					nameTemp1 = rawInput.substring(nameStartIndex +1, nameEndIndex);
					nameTemp2 = nameTemp1.replace('/', ',');
					System.out.println("Name = " + nameTemp2);
				} else {
					System.out.println("error parsing name - 2-part name problem?");
					pass = false;
				}
			}

			// check for track-2 problems
			//ascii code for semicolon
			int semicolon = 59;
			int semicolonIndex = rawInput.indexOf(semicolon);

			//debug message
			System.out.println("semicolonIndex = " + semicolonIndex);

			String track2 = "";
			if(semicolonIndex != -1){
				track2 = rawInput.substring(semicolonIndex +1);
				//System.out.println(track2);
			} else {
				System.out.println("error parsing track-2");
				pass = false;
			}

			if(!track2.startsWith("6048880000")){
				System.out.println("Track-2 format not recognized");
				pass = false;
			} else {
				studentNum = track2.substring(24, 33);
				//System.out.println("student number = " + studentNum);
			}
		}

		if(pass){
			name = nameTemp2;
			CIN = studentNum;
		}
		return pass;
	}

}
