// main(){
//      LRUCache cacheInstance = new LRUCache(3);
// }

class LRUCache {

    class DLLNode{
        public int key;
        public int value;
        public DLLNode next;
        public DLLNode prev;

        public DLLNode(int key, int value){
            this.key = key;
            this.value = value;
            this.next = null;
            this.prev = null;
        }
    }

    DLLNode head;
    DLLNode tail;
    int maxCapacity;
    int curSize;
    HashMap<Integer, DLLNode> keyVsNodeMap;


    public LRUCache(int capacity) {
        head = new DLLNode(-1, -1);
        tail = new DLLNode(-1, -1);
        head.next = tail;
        tail.prev = head;
        this.maxCapacity = capacity;
        this.curSize = 0;
        this.keyVsNodeMap = new HashMap<>();
    }
    
    private void remove(DLLNode node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.prev = null;
        node.next = null;
        this.curSize--;
    }

    private void addLast(DLLNode node){
        node.next = tail;
        node.prev = tail.prev;
        tail.prev = node;
        node.prev.next = node;
        this.curSize++;
    }

    private boolean isCacheFull(){
        return this.curSize == this.maxCapacity;
    }

    public int get(int key) {
        if(keyVsNodeMap.containsKey(key)){
            DLLNode temp = keyVsNodeMap.get(key);
            remove(temp);
            addLast(temp);
            return temp.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(keyVsNodeMap.containsKey(key)){
            // existing key
            DLLNode temp = keyVsNodeMap.get(key);
            temp.value = value;
            remove(temp);
            addLast(temp);
        }
        else{
            // new key
            if(isCacheFull()){
                keyVsNodeMap.remove(head.next.key);
                remove(head.next);
            }
            DLLNode newNode = new DLLNode(key, value);
            keyVsNodeMap.put(key, newNode);
            addLast(newNode);        
        }
    }

    public int size(){
        return this.curSize;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */