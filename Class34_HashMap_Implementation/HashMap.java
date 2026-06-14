public class HashMap<T,U> implements Map<T,U>{

	public class Node<T,U>{
		public T key;
		public U value;
		public Node next;

		public Node(T key, U value){
			this.key = key;
			this.value = value;
			this.next = null;
		}
	}

	private Node<T,U>[] hashTable;
	private int tableSize;
	private int curMapSize;

	public HashMap(){
		tableSize = 10;
		hashTable = new Node[tableSize];
		curMapSize = 0;
	}

	private int hashFn(T key){
		String str = String.valueOf(key);
		int primeNo = 47;
		int primeFactor = 1;

		int sum = 0;
		int i=0;
		while(i < str.length()){
			char ch = str.charAt(i);
			sum = (sum + primeFactor * ch) % tableSize;
			primeFactor = (primeFactor * primeNo) % tableSize;
			i++;
		}

		return sum % tableSize;
	}

	private Node updateOrinsert(Node head, T key, U value){
		Node temp = head;
		Node prev = null;

		if(head == null){
			head = new Node(key, value);
			this.curMapSize++;
			return head;
		}

		while(temp != null){
			if(temp.key == key){
				temp.value = value;
				return head;
			}
			prev = temp;
			temp = temp.next;
		}

		prev.next = new Node(key, value);
		this.curMapSize++;
		return head;
	}

	private U search(Node head, T key){
		Node temp = head;

		while(temp != null){
			if(temp.key == key){
				return (U)temp.value;
			}
			temp = temp.next;
		}

		return null;
	}

	private Node delete(Node head, T key){
		int idx = hashFn(key);
		if(head.key == key){
			head = head.next;
			this.curMapSize--;
			return head;
		}

		Node temp = head;
		Node prev = null;

		while(temp != null){
			if(temp.key == key){
				prev.next = temp.next;
				this.curMapSize--;
				return head;
			}
			temp = temp.next;
		}
		return head;
	}

	private void rehash(){
		System.out.println("Rehashing...");
		int tableSizeOld = this.tableSize;
		this.tableSize *= 2;
		this.curMapSize = 0;
		Node<T,U>[] hashTableOld = hashTable;
		hashTable = new Node[this.tableSize];

		for(int i=0; i<tableSizeOld; i++){
			Node head = hashTableOld[i];
			Node temp = head;

			while(temp != null){
				put((T)temp.key, (U)temp.value);
				temp = temp.next;
			}
		}
		return;
	}

	private void printHashTable(){
		System.out.println("Printing HashTable:");
		for(int i=0; i<tableSize; i++){
			Node head = hashTable[i];
			Node temp = head;

			System.out.print("idx = " + i + " -> ");
			while(temp != null){
				System.out.print("(" + temp.key + ", " + temp.value + "), ");
				temp = temp.next;
			}
			System.out.println(" null ");
		}
		return;
	}

	public void put(T key, U value){
		int idx = hashFn(key);

		Node head = hashTable[idx];
		hashTable[idx] = updateOrinsert(head, key, value);

		double loadFactor = (1.0 * this.curMapSize) / this.tableSize;
		if(loadFactor > 0.75){
			printHashTable();
			System.out.println();
			rehash();
			System.out.println();
			printHashTable();
			System.out.println();
		}

		return;
	}

	public U get(T key){
		int idx = hashFn(key);
		Node head = hashTable[idx];

		return search(head, key);
	}

	public void remove(T key){
		int idx = hashFn(key);

		Node head = hashTable[idx];

		hashTable[idx] = delete(head, key);
		return;
	}

	public int size(){
		return this.curMapSize;
	}
}