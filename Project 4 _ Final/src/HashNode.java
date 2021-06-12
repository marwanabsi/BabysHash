public class HashNode { 
	private String value;
	private Babys data;
	private int status; // insert: 1, delete: 2, empty: 0
	private Heap frec;
	

	HashNode(Babys data, int status) {
		this.data = data;
		this.status = status;
		
	}
	
	
	public Babys getData() {
		return data;
	}


	public void setData(Babys data) {
		this.data = data;
	}


	public Heap getFrec() {
		return frec;
	}


	public void setFrec(Heap frec) {
		this.frec = frec;
	}


	public String getValue() {
		return value;
	}

	public int getStatus() {
		return status;
	}

	public void setDeleteStatus() {
		status = 2;
	}
	

	@Override
	public String toString() {
		return data  + frec.toString() ;
	}
	
	
}
