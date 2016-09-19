import java.util.ArrayList;

public class OpeningHours {
	private int startHour; //IN 24HR FORMAT (1 to 24)
	private int endHour;
	public OpeningHours(int s, int e){
		this.startHour = s;
		this.endHour = e;
	}
	public void setStartHour(int s){
		this.startHour = s;
	}
	public void setEndHour(int e){
		this.endHour = e;
	}
	public int getStartHour(){
		return this.startHour;
	}
	public int getEndHour(){
		return this.endHour;
	}
	public boolean contains(ArrayList<OpeningHours> ohSet){
		for (OpeningHours oh:ohSet){
			if (this.startHour== oh.getStartHour() && this.endHour == oh.getEndHour()){
				return true;
			}
		}
		return false;
	}
}
