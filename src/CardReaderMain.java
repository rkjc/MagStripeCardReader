import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

public class CardReaderMain {

	public static void main(String[] args) {

		// make and open attendance file with time/date in file name
		Scanner scanner = new Scanner(System.in);
		String timeStamp  = new SimpleDateFormat("yyyy'-'MM'-'dd'_'hh'.'mm").format(new Date());
		String attendanceFileName = "attendanceLog_" + timeStamp + ".log";
		String inputLogFileName = "inputLog_" + timeStamp + ".log";
		String nameStr = "";
		HashMap<String, Student> inputHash = new HashMap<String, Student>();

		try {
			File attendanceLog = new File(attendanceFileName);
			File inputLog = new File(inputLogFileName);
			attendanceLog.createNewFile();
			inputLog.createNewFile();
			FileWriter attendance = new FileWriter(attendanceLog);
			FileWriter inputLogging = new FileWriter(inputLog);

			System.out.println("File " + attendanceFileName + " has been created");

			attendance.write("Attendance log for " + timeStamp + "\r\n");
			attendance.write("------------------------------------\r\n");

			boolean runScan = true;
			while(runScan){
				System.out.println("Please slide student ID card");
				String inputStr = scanner.next();
				// keep track of every card swipe
				inputLogging.write(inputStr + "\r\n");
				inputLogging.flush();

				if(inputStr.equals("exit")){break;}

				Student tempStud = new Student(inputStr);

				if(!tempStud.parseInputForName()){
					System.out.println("Error reading card or wrong format");
					System.out.println("####################################################################");
					System.out.println("####################################################################");
					System.out.println("####################################################################");
					System.out.println("####################################################################");
					System.out.println("####################################################################");
					System.out.println("####################################################################");
					System.out.println(" ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR");
					System.out.println(" ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR");
					System.out.println(" ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR");
					System.out.println("####################################################################");
					System.out.println("####################################################################");
					System.out.println("####################################################################");
					System.out.println("####################################################################");
					System.out.println("####################################################################");
					System.out.println("####################################################################");
				} else {
					System.out.println("------------------------------------\r\n");
					//putIfAbsent adds a key pair to the hashmap, return null if not there, returns value if value changed.
					if(inputHash.putIfAbsent(inputStr, tempStud) != null){
						System.out.println(tempStud.getName() + "\r\n\r\nhas already been logged\r\n");
					} else {
						attendance.write(inputStr + "\r\n");
						attendance.flush();
						System.out.println(tempStud.getName() + "\r\n\r\nhas been marked as present\r\n");
					}
				}
				System.out.println("------------------------------------");
			}

		//wait 2 sec
		//clear screen


			attendance.flush();
			attendance.close();
			System.out.println("Attendance file has been closed");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}