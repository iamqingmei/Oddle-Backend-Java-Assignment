import java.util.List;
import java.util.Set;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;


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
		//for display uses
		HashMap<Integer, String> display = new HashMap<Integer, String>();
		display.put(2,"Monday");
		display.put(3,"Tuesday");
		display.put(4,"Wednesday");
		display.put(5,"Thursday");
		display.put(6,"Friday");
		display.put(7,"Saturday");
		display.put(1,"Sunday");
		

		convertToOpeningHours(shiftHours,display);
		
		//Additional set of data for verification
		shiftHours = ShiftHour.initializeShiftHoursSetTwo();
	}
	
	private static boolean sameOpeningHours(boolean[] a, boolean[] b){
		for (int i=0;i<24;i++){
			if (a[i]!=b[i]){
				return false;
			}
		}
		return true;
	}

	private static void convertToOpeningHours(List<ShiftHour> shiftHours,HashMap<Integer, String> display){
		// initialize 7 DayHours objects to save the opening hours for seven days
		ArrayList<DayHours> sevenDays = new ArrayList<DayHours>();
		sevenDays.add(new DayHours(Calendar.SUNDAY)); //sevenDays.get(0)
		sevenDays.add(new DayHours(Calendar.MONDAY)); //sevenDays.get(1)
		sevenDays.add(new DayHours(Calendar.TUESDAY));//sevenDays.get(2)
		sevenDays.add(new DayHours(Calendar.WEDNESDAY)); //sevenDays.get(3)
		sevenDays.add(new DayHours(Calendar.THURSDAY)); //sevenDays.get(4)
		sevenDays.add(new DayHours(Calendar.FRIDAY)); //sevenDays.get(5)
		sevenDays.add(new DayHours(Calendar.SATURDAY)); //sevenDays.get(6)
		
		// add the shift hours into sevenDays
		for(ShiftHour sh:shiftHours){
			for (int i:sh.getDaysInWeek()){
				sevenDays.get(i-1).addOpeningHours(sh.getStartHour(),sh.getEndHour());
			}
		}

		//print out the final result
		DayHours sDay = sevenDays.get(1);
		DayHours eDay = sevenDays.get(1);
		System.out.print("Monday");
		int[] list = {2,3,4,5,6,0}; // for traversing from Tuesday to Sunday
		for (int i:list){
			DayHours dh = sevenDays.get(i);
			if (!sameOpeningHours(eDay.getOpeningHours(),dh.getOpeningHours())){
				if (eDay.getDayInWeek() != sDay.getDayInWeek()){ 
					//if not same, need to print out the day of eDay
					System.out.print(" - " + display.get(eDay.getDayInWeek()));					
				}
				System.out.print("\n");	
				eDay.printOpeningHours();
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
		// print out the opening hours for Sunday
		sevenDays.get(0).printOpeningHours();
	}
	
}


