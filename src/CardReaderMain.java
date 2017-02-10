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
		String fileName = "attendanceLog_" + timeStamp + ".txt";
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

				nameStr = inputStr;
				
				if(inputHash.putIfAbsent(inputStr, nameStr) != null){
					System.out.println(nameStr + " has already been logged");
				} else {
					attendance.write(inputStr + "\r\n");
					System.out.println(nameStr + " hass been logged as present");
				}
				
			
			}
			
        		
		//while loop - test input for "end" or "quit"
		//print "Please scan Student ID"
		//check if value in hashmap
		//if not in hashmap, parse name, add to hash, append to attendance file
		//print name has been logged -or- name is already logged
		//wait 2 sec
		//clear screen
		//loop while
		//close file
			
			attendance.flush();
			attendance.close();
			System.out.println("Attendance file has been closed");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}