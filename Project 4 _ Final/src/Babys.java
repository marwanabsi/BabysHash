
public class Babys implements Comparable<Babys> {

	private String name;
	private String gender;
	
	
	public Babys(String name, String gender) {
		super();
		this.name = name; 
		this.gender = gender;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}


	public int compareTo(String string) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String toString() {
		return "\n"+"Baby name : " + name + ", Babys Gender : " + gender + "\n";
	}

	@Override
	public int compareTo(Babys o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	

}
