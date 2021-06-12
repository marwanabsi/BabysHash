
public class frecuans implements Comparable<frecuans> {
	private int year;
	private int frec;
	
	
	public frecuans(int year, int frec) {
		super();
		setYear(year);
		setFrec(frec); 
	}
	
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getFrec() {
		return frec;
	}
	public void setFrec(int frec) {
		this.frec = frec;
	}

	@Override
	public int compareTo(frecuans o) {
		return this.frec - o.getFrec();
	}

	@Override
	public String toString() {
		return " Frecuans  at " + year + " is = " +frec ;
	}
	
	
}
