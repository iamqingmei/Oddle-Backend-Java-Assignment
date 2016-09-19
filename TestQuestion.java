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
		
		sevenDays.add(new DayHours(Calendar.MONDAY));
		sevenDays.add(new DayHours(Calendar.TUESDAY));
		sevenDays.add(new DayHours(Calendar.WEDNESDAY));
		sevenDays.add(new DayHours(Calendar.THURSDAY));
		sevenDays.add(new DayHours(Calendar.FRIDAY));
		sevenDays.add(new DayHours(Calendar.SATURDAY));
		sevenDays.add(new DayHours(Calendar.SUNDAY));

		for(ShiftHour sh:shiftHours){
			OpeningHours theShift = new OpeningHours(sh.getStartHour(),sh.getEndHour());
			for (int i:sh.getDaysInWeek()){
				sevenDays.get(i-2).addOpeningHours(theShift);
			}
		}
		DayHours sDay = new DayHours(-1);
		DayHours eDay = sevenDays.get(0);
		System.out.print("Monday");
		for (DayHours dh:sevenDays){
			dh.mergeOpeningHours();	

					
			if (!SameOpeningHours(eDay.getOpeningHours(),dh.getOpeningHours())){
								
				if (eDay.getDayInWeek() != sDay.getDayInWeek()){
					System.out.print(" - " + display.get(eDay.getDayInWeek()));					
				}
				System.out.print("\n");
				if (eDay.getOpeningHours() == null){
					System.out.println("Closed");
				}
				else{
					for (OpeningHours s:eDay.getOpeningHours()){
						printTime(s.getStartHour());
						System.out.print(" to ");
						printTime(s.getEndHour());
						System.out.print("\n");
					}
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
		if (sevenDays.get(6).getOpeningHours().size() == 0){
			System.out.println("Closed");
		}
		else{
			System.out.println("here?");
			for (OpeningHours s:sevenDays.get(6).getOpeningHours()){
				printTime(s.getStartHour());
				System.out.print(" to ");
				printTime(s.getEndHour());
				System.out.print("\n");
			}
		}
		
		
		
		//Additional set of data for verification
		shiftHours = ShiftHour.initializeShiftHoursSetTwo();
	}
	
	private static boolean SameOpeningHours(ArrayList<OpeningHours> a, ArrayList<OpeningHours> b){
		if (a.size() != b.size()){
			return false;
		}
		for (OpeningHours oh:a){
			if (!oh.contains(b)){
				return false;
			}
		}
		return true;
	}
	
	private static void printTime(int n){
		int pm = n/12;
		int time = n%12;
		if (time ==0){
			System.out.print("12");
		}
		else{
			System.out.print(time);
		}
		if (pm == 1){
			System.out.print("PM");
		}
		else{
			System.out.print("AM");
		}
	}
}


