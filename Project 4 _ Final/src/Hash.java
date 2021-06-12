
public class Hash {
	private int tableSize = 10;
	private HashNode[] table;
	private int currentSize = 0;

	public Hash(int size) {
		table = new HashNode[size];
		for (int i = 0; i < size; i++)
			table[i] = null;
		tableSize = size;
		currentSize = 0;
	}

	public void makeEmpty() {
		for (int i = 0; i < table.length; i++)
			table[i] = null;

		currentSize = 0;
	}

	public int getCurrentSize() {
		return currentSize;
	}

	public int getTableSize() {
		return tableSize;
	}

	public boolean contains(Babys value) {
		
		return find(value) != "null";
	}

	

	public void remove(Babys data) {
		
		String valuu = data.getName() + data.getGender();
		int xKey = hash(valuu.toLowerCase(), tableSize);
		int i = 1;
		
		if (!contains(data))
			return;
		
		int hashVal, hash = getHash(xKey);
		hashVal = hash;

		while ((table[hash] != null) && (((table[hash].getStatus() != 0) && !(table[hash].getData().getName().equalsIgnoreCase(data.getName())))
				|| ((table[hash].getData().getName().equalsIgnoreCase(data.getName())) && (table[hash].getStatus() == 2)))) {
			//System.out.println("#############################################");
			hash = (hashVal + i * i) % tableSize; // Quadratic
			// hash = (hash + 1) % tableSize; // Linear
			// hash = (hashVal + i * F2) % tableSize; // Double
			i++;
		}
		System.out.println(table[hash].getData().getName());
		
		currentSize--;
		table[hash].setDeleteStatus();
	}
	
	public HashNode findNode(Babys data) {

		String valuu = data.getName() + data.getGender();
		int xKey = hash(valuu.toLowerCase(), tableSize);
		int i = 1;
		int hashVal, hash = getHash(xKey);
		hashVal = hash;

		while ((table[hash] != null) && (((table[hash].getStatus() != 0) && !(table[hash].getData().getName().equalsIgnoreCase(data.getName())))
				|| ((table[hash].getData().getName().equalsIgnoreCase(data.getName())) && (table[hash].getStatus() == 2)))) {
			hash = (hashVal + i * i) % tableSize; // Quadratic

			i++;
		}

		if ((table[hash] == null) || (table[hash].getStatus() == 0))
			return null;
		else if ((table[hash].getData().getName().equalsIgnoreCase(data.getName()))
				&& (table[hash].getData().getGender().equalsIgnoreCase(data.getGender())))  {
				return table[hash];
			}
		else
			return null;
	}
	
	
	public String find(Babys data) {

		String valuu = data.getName() + data.getGender();
		int xKey = hash(valuu.toLowerCase(), tableSize);
		int i = 1;
		int hashVal, hash = getHash(xKey);
		hashVal = hash;

		while ((table[hash] != null) && (((table[hash].getStatus() != 0) && !(table[hash].getData().getName().equalsIgnoreCase(data.getName())))
				|| ((table[hash].getData().getName().equalsIgnoreCase(data.getName())) && (table[hash].getStatus() == 2)))) {
			//System.out.println("#############################################");
			hash = (hashVal + i * i) % tableSize; // Quadratic
			// hash = (hash + 1) % tableSize; // Linear
			// hash = (hashVal + i * F2) % tableSize; // Double
			i++;
		}
		

		if ((table[hash] == null) || (table[hash].getStatus() == 0))
			return "null";
		else if ((table[hash].getData().getName().equalsIgnoreCase(data.getName()))
				&& (table[hash].getData().getGender().equalsIgnoreCase(data.getGender())))  {
				return (table[hash].getData().getName()+" "+(table[hash].getData().getGender())+table[hash].getFrec());
			}
		else
			return "null";
	}

	public void insert(Babys data, Heap frec) {
		String value = data.getName() + data.getGender();
		if (currentSize >= tableSize / 2)
			rehash();
		int hashVal, hash = getHash(hash(value.toLowerCase(), tableSize));
		hashVal = hash;
		// System.out.println(hash+" Hash ");
		int i = 1;
		boolean isKeyInserted = false;
		while ((table[hash] != null) && (table[hash].getStatus() != 0) && (table[hash].getStatus() != 2)) {
			if (!table[hash].getData().getName().equalsIgnoreCase(data.getName())
					|| !table[hash].getData().getGender().equalsIgnoreCase(data.getGender())) {

				hash = (hashVal + i * i) % tableSize; // Quadratic
				// hash = (hash + 1) % tableSize; // Linear
				// hash = (hashVal + i * F2) % tableSize; // Double

				i++;

			} else {
				isKeyInserted = true;
				break;
			}
		}
		if (!isKeyInserted) {
			currentSize++;
			// System.out.println("hash =="+hash);
			table[hash] = new HashNode(data, 1);
			table[hash].setFrec(frec);
			

		}
		else {
			table[hash].getFrec().insert(frec.getHeapTable());
			}
	}
//	public insertFrecouns() {
//		
//	}
	public int getHash(int key) {
		int hashVal = 0;
		hashVal = (int) key % tableSize;
		if (hashVal < 0)
			hashVal += tableSize;
		return hashVal;
	}

	private void rehash() {
		Hash newList;
		newList = new Hash(nextPrime(2 * table.length));

		for (int i = 0; i < table.length; i++)
			if ((table[i] != null) && (table[i].getStatus() == 1))
				newList.insert(table[i].getData(), table[i].getFrec());

		table = newList.table;

		tableSize = newList.tableSize;
	}

	private int nextPrime(int n) {
		if (n % 2 == 0)
			n++;
		while (!isPrime(n)) {
			n += 2;
		}
		return n;
	}

	private boolean isPrime(int n) {
		if (n == 2 || n == 3)
			return true;
		if (n == 1 || n % 2 == 0)
			return false;
		for (int i = 3; i * i <= n / 2; i += 2)
			if (n % i == 0)
				return false;
		return true;
	}

	int hash(String key, int hashSize) {
		int hashVal = 0, i = 0;
		while (i != key.length())
			hashVal += key.charAt(i++);
		return (hashVal % hashSize);
	}

	public void printHashTable() {
		for (int i = 0; i < table.length; i++)
			if (table[i] == null) {
				
			}
			else if (table[i].getStatus() == 1)
				System.out.println(table[i].toString());

	}
	
	public String printHashString() {
		String s="";
		for (int i = 0; i < table.length; i++) {
			if (table[i] == null) {
			}
			else if (table[i].getStatus() == 1)
				s+=table[i].toString();
			}
		return s;

	}

	public HashNode[] getTable() {
		return table;
	}

	public void setTable(HashNode[] table) {
		this.table = table;
	}
	
	
	
}