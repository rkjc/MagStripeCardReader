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
		String fileName = "attendanceLog_" + timeStamp + ".log";
		String nameStr = "";
		HashMap<String, String> inputHash = new HashMap<String, String>();

		try {
			File attendanceLog = new File(fileName);
			attendanceLog.createNewFile();
			FileWriter attendance = new FileWriter(attendanceLog);


			System.out.println("File " + fileName + " has been created");

			attendance.write("Attendance log for " + timeStamp + "\r\n");
			attendance.write("------------------------------------\r\n");

			boolean runScan = true;
			while(runScan){
				System.out.println("Please slide student ID card");
				String inputStr = scanner.next();

				if(inputStr.equals("exit")){break;}

				nameStr = inputStr;  //TODO add name parser
				System.out.println("------------------------------------\r\n");
				if(inputHash.putIfAbsent(inputStr, nameStr) != null){
					System.out.println(nameStr + "\r\n\r\nhas already been logged\r\n");
				} else {
					attendance.write(inputStr + "\r\n");
					attendance.flush();
					System.out.println(nameStr + "\r\n\r\nhas been logged as present\r\n");
				}
				System.out.println("------------------------------------\r\n");
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