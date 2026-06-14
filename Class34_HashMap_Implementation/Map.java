interface Map<T,U>{
	public void put(T key, U value);
	public U get(T key);
	public void remove(T key);
	public int size();
}