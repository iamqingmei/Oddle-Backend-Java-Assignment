import java.util.ArrayList;
// import java.util.HashSet;

public class DayHours {
	private int dayInWeek; //1-7
	private ArrayList<OpeningHours> openingHours;
	public DayHours(int day){
		this.dayInWeek = day;
		this.openingHours = new ArrayList<OpeningHours>();  
	}
	public int getDayInWeek(){
		return this.dayInWeek;
	}
	public void addOpeningHours(OpeningHours s){
		this.openingHours.add(s);
	}
	public ArrayList<OpeningHours> getOpeningHours(){
		return this.openingHours;
	}
	public void mergeOpeningHours(){
		boolean[] hoursInDay = new boolean[24]; //1-24 o'clocks
		ArrayList<OpeningHours> merged = new ArrayList<OpeningHours>();    
		for (OpeningHours i:this.openingHours){
			for (int h = i.getStartHour(); h< i.getEndHour() + 1; h++){
				hoursInDay[h-1] = true;
			}
		}
		int s = -1;
		int e = -1;
		for (int i=1;i<25;i++){
			if (hoursInDay[i-1]){
				if (s == -1){
					// the start of a new shift
					s = i;
					e = -1;
				}
				//else continue
			}
			else{ //hoursInDay[i-1] not true
				if (s!=-1 && e == -1){
					// i - 2 is the end of shift
					e = i - 1;
					merged.add(new OpeningHours(s,e));
					s = -1;
					e = -1;
				}
			}
		}
		this.openingHours = merged;
	}
}
