
public class Heap {
	private frecuans[] HeapTable;
	private int size;

	private static final int ROOT = 1;

	public Heap(int MaxSize) {
		this.size = 0;
		HeapTable = new frecuans[MaxSize + 1];
	}

	public void insert(frecuans element) {
		HeapTable[++size] = element;
		swim();
	}
	

	private void swim() {
		int curr = size;
		while (curr > 1 && less(curr / 2, curr)) {
			swap(curr, curr / 2);
			curr = curr / 2;
		}
	}

	private void swap(int curr, int parent) {
		frecuans temp;
		temp = HeapTable[curr];
		HeapTable[curr] = HeapTable[parent];
		HeapTable[parent] = temp;
	}

	private boolean less(int i, int j) {
		// (-) <0 the parent is smaller
		// (+) >0 or =0 the parent is larger
		return HeapTable[i].compareTo(HeapTable[j]) < 0;
	}

	public frecuans remove() {
		frecuans removedElement = HeapTable[ROOT];
		HeapTable[ROOT] = HeapTable[size--];
		sink(ROOT,size);
		HeapTable[size + 1] = null;
		return removedElement;
	}


	public void sortHeap() {
		try {
			Heap  maxHeap = (Heap) this.clone();
			int n = maxHeap.size;
			while (n >= 1) {
				System.out.println(maxHeap.remove().toString());
				n--;

			}
			maxHeap = null;
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
	}

	private void sink(int pos,int lastPos) {
		// left pos*2 =j
		// right pos*2+1 =j+1
		if (pos * 2 <= lastPos && (pos * 2) + 1 <= lastPos) // is not Leaf
			if (less(pos, pos * 2) || less(pos, (pos * 2) + 1)) {
				if (less(pos * 2, (pos * 2) + 1)) {
					swap(pos, (pos * 2) + 1);
					sink((pos * 2) + 1,lastPos);
				} else {
					swap(pos, pos * 2);
					sink(pos * 2,lastPos);
				}
			}
	}

	public void print() {
		for (int i = 1; i <= size / 2; i++) {
			System.out.print(" PARENT : " + HeapTable[i] + "----> LEFT CHILD : " + HeapTable[2 * i] + " RIGHT CHILD :"
					+ HeapTable[2 * i + 1]);
			System.out.println();
		}
	}
	
	public void printSort() {
		for (int i = 1; i <= size ; i++) {
			System.out.print(HeapTable[i] + "---->");
		}
	}
	
	public String toString() {
		String k="";
		for (int i = 1; i <= size ; i++) {
			k+=HeapTable[i]+"\n";
		}
		return k;
	}
	
	public frecuans getHeapTable() {
		return HeapTable[size];
	}
	
	public frecuans [] getHeapTablee() {
		return HeapTable;
	}
	
	public int getSize() {
		return size;
	}
	


}
