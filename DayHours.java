import java.util.ArrayList;
// import java.util.HashSet;

public class DayHours {
	private int dayInWeek; //1-7
	private boolean[] openingHours = new boolean[24]; //0-23, represents 1-24 o'clock
	public DayHours(int day){
		this.dayInWeek = day;
		for (int i=0;i<24;i++){
			this.openingHours[i]=false;
		}
	}
	public int getDayInWeek(){
		return this.dayInWeek;
	}
	public void addOpeningHours(int s, int e){
		for (int i=s;i<e+1;i++){
			openingHours[i-1] = true;
		}
	}
	public boolean[] getOpeningHours(){
		return this.openingHours;
	}

	public void printOpeningHours(){
		int s = -1;
		int e = -1;
		boolean notOpen = false;
		for (int i=1;i<25;i++){
			if (openingHours[i-1]){
				if (s == -1){
					// the start of a new shift
					s = i;
					e = -1;
				}
				//else continue
				notOpen=true;
				if (i==24){
					printTime(s);
					System.out.print(" to ");
					printTime(24);
					System.out.print("\n");
				}
			}
			else{ //openingHours[i-1] not true
				if (s!=-1 && e == -1){
					// i - 2 is the end of shift
					e = i - 1;
					printTime(s);
					System.out.print(" to ");
					printTime(e);
					System.out.print("\n");
					s = -1;
					e = -1;
				}
			}
		}
		if (!notOpen){
			System.out.println("Closed");
		}
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
