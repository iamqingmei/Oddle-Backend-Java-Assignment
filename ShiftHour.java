import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//For your reference, do not modify
public class ShiftHour {
	private Set<Integer> daysInWeek = new HashSet<Integer>(); //CALENDAR'S DAYINWEEK
	private int startHour; //IN 24HR FORMAT (1 to 24)
	private int endHour;
	
	//helper methods
	public Set<Integer> getDaysInWeek() {
		return daysInWeek;
	}
	public void setDaysInWeek(Set<Integer> daysInWeek) {
		this.daysInWeek = daysInWeek;
	}
	public int getStartHour() {
		return startHour;
	}
	public void setStartHour(int startHour) {
		this.startHour = startHour;
	}
	public int getEndHour() {
		return endHour;
	}
	public void setEndHour(int endHour) {
		this.endHour = endHour;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//methods that generate assignment questions
	public static List<ShiftHour> initializeShiftHoursSetOne() {
		List<ShiftHour> shiftHours = new ArrayList<ShiftHour>(0);
		
		ShiftHour sh1 = new ShiftHour();
		sh1.getDaysInWeek().add(Calendar.MONDAY);
		sh1.getDaysInWeek().add(Calendar.TUESDAY);
		sh1.getDaysInWeek().add(Calendar.WEDNESDAY);
		sh1.getDaysInWeek().add(Calendar.THURSDAY);
		sh1.getDaysInWeek().add(Calendar.FRIDAY);
		sh1.getDaysInWeek().add(Calendar.SATURDAY);
		sh1.setStartHour(9);
		sh1.setEndHour(14);
		
		ShiftHour sh2 = new ShiftHour();
		sh2.getDaysInWeek().add(Calendar.MONDAY);
		sh2.getDaysInWeek().add(Calendar.TUESDAY);
		sh2.getDaysInWeek().add(Calendar.WEDNESDAY);
		sh2.getDaysInWeek().add(Calendar.THURSDAY);
		sh2.getDaysInWeek().add(Calendar.FRIDAY);
		sh2.setStartHour(16);
		sh2.setEndHour(21);
		
		ShiftHour sh3 = new ShiftHour();
		sh3.getDaysInWeek().add(Calendar.FRIDAY);
		sh3.setStartHour(12);
		sh3.setEndHour(17);
		
		ShiftHour sh4 = new ShiftHour();
		sh4.getDaysInWeek().add(Calendar.SATURDAY);
		sh4.setStartHour(14);
		sh4.setEndHour(19);
		
		shiftHours.add(sh1);
		shiftHours.add(sh2);
		shiftHours.add(sh3);
		shiftHours.add(sh4);
		
		return shiftHours;
		
	}
	
	public static List<ShiftHour> initializeShiftHoursSetTwo() {
		List<ShiftHour> shiftHours = new ArrayList<ShiftHour>(0);
		
		ShiftHour sh1 = new ShiftHour();
		sh1.getDaysInWeek().add(Calendar.MONDAY);
		sh1.getDaysInWeek().add(Calendar.TUESDAY);
		sh1.getDaysInWeek().add(Calendar.THURSDAY);
		sh1.getDaysInWeek().add(Calendar.FRIDAY);
		sh1.getDaysInWeek().add(Calendar.SATURDAY);
		sh1.setStartHour(9);
		sh1.setEndHour(14);
		
		ShiftHour sh2 = new ShiftHour();
		sh2.getDaysInWeek().add(Calendar.MONDAY);
		sh2.getDaysInWeek().add(Calendar.TUESDAY);
		sh2.getDaysInWeek().add(Calendar.WEDNESDAY);
		sh2.getDaysInWeek().add(Calendar.THURSDAY);
		sh2.getDaysInWeek().add(Calendar.FRIDAY);
		sh2.setStartHour(16);
		sh2.setEndHour(21);
		
		ShiftHour sh3 = new ShiftHour();
		sh3.getDaysInWeek().add(Calendar.WEDNESDAY);
		sh3.setStartHour(12);
		sh3.setEndHour(17);
		
		ShiftHour sh4 = new ShiftHour();
		sh4.getDaysInWeek().add(Calendar.SATURDAY);
		sh4.setStartHour(15);
		sh4.setEndHour(19);
		
		ShiftHour sh5 = new ShiftHour();
		sh5.getDaysInWeek().add(Calendar.MONDAY);
		sh5.setStartHour(8);
		sh5.setEndHour(19);
		
		shiftHours.add(sh1);
		shiftHours.add(sh2);
		shiftHours.add(sh3);
		shiftHours.add(sh4);
		shiftHours.add(sh5);
		
		return shiftHours;
		
	}
	
	
	
}
