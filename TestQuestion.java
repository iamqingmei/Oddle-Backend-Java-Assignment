import java.util.List;
import java.util.Set;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
//import java.util.HashSet;

/**
 * -------------
 * INTRODUCTION
 * -------------
 * Every restaurant has shift hours.These hours are usually defined based on day in week, e.g. Monday to Sunday, and hours and minutes, e.g. from 10.30 AM to 3.30 PM.
 * The combination of shift hours make up the actual opening hours of the restaurant. 
 * 
 * -------------
 * ASSIGNMENT
 * -------------
 * You are tasked to convert and print out the shift hours into nice opening hours. 
 *
 * ******************************************
 * Here's an example of an Italian restaurant with multiple shift hours:
 * 
 * Monday to Saturday 
 * 9AM to 2PM
 * 
 * Monday to Friday
 * 4PM to 9PM
 * 
 * Friday
 * 12PM to 5PM 
 * NOTE: the opening hours for Friday will be from 9AM to 9PM (A combination of 3 shifts, 9AM to 2PM, 12PM to 5PM and 4PM to 9PM)
 * 
 * Saturday 
 * 2PM to 7PM
 * NOTE: the opening hours for Saturday will be from 9AM to 7PM (A combination of 2 shifts, 9AM to 2PM and 2PM to 7PM)
 * 
 *
 *******************************************
 * The output of the opening hours will be:
 *
 * Monday - Thursday
 * 9AM to 2PM
 * 4PM to 9PM
 * 
 * Friday
 * 9AM to 9PM
 * 
 * Saturday
 * 9AM to 7PM
 * 
 * Sunday
 * Closed
 * ******************************************
 *   
 * @author joonhui
 *
 */
public class TestQuestion {
	
	public static void main(String[] args) {
		//Initialize first set of data
		List<ShiftHour> shiftHours = ShiftHour.initializeShiftHoursSetOne();
		
		//your solution here
		ArrayList<DayHours> sevenDays = new ArrayList<DayHours>();
		//for display uses
		HashMap<Integer, String> display = new HashMap<Integer, String>();
		display.put(2,"Monday");
		display.put(3,"Tuesday");
		display.put(4,"Wednesday");
		display.put(5,"Thursday");
		display.put(6,"Friday");
		display.put(7,"Saturday");
		display.put(1,"Sunday");
		
		sevenDays.add(new DayHours(Calendar.SUNDAY)); //sevenDays.get(0)
		sevenDays.add(new DayHours(Calendar.MONDAY)); //1
		sevenDays.add(new DayHours(Calendar.TUESDAY));//2
		sevenDays.add(new DayHours(Calendar.WEDNESDAY)); //3
		sevenDays.add(new DayHours(Calendar.THURSDAY)); //4
		sevenDays.add(new DayHours(Calendar.FRIDAY)); //5
		sevenDays.add(new DayHours(Calendar.SATURDAY)); //6
		

		for(ShiftHour sh:shiftHours){
			for (int i:sh.getDaysInWeek()){
				sevenDays.get(i-1).addOpeningHours(sh.getStartHour(),sh.getEndHour());
			}
		}
		// sevenDays.get(0).printOpeningHours();
		// sevenDays.get(0).addOpeningHours(12,24);
		// sevenDays.get(0).printOpeningHours();

		
		DayHours sDay = new DayHours(-1);
		DayHours eDay = sevenDays.get(0);
		System.out.print("Monday");
		for (int i=1;i<7;i++){
			DayHours dh = sevenDays.get(i);
			if (!SameOpeningHours(eDay.getOpeningHours(),dh.getOpeningHours())){								
				if (eDay.getDayInWeek() != sDay.getDayInWeek()){
					System.out.print(" - " + display.get(eDay.getDayInWeek()));					
				}
				// System.out.print("\n");
				// if (i==6){
				// 	dh.printOpeningHours();
				// }
				else{
					eDay.printOpeningHours();
				}
				System.out.print("\n");				
				System.out.print(display.get(dh.getDayInWeek()));
				sDay = dh;	
				eDay = dh;
			}
			else{
				eDay = dh;	
			}	
		}
		System.out.print("\n");
		
		
		
		
		//Additional set of data for verification
		shiftHours = ShiftHour.initializeShiftHoursSetTwo();
	}
	
	private static boolean SameOpeningHours(boolean[] a, boolean[] b){
		for (int i=0;i<24;i++){
			if (a[i]!=b[i]){
				return false;
			}
		}
		return true;
	}
	
	
}


