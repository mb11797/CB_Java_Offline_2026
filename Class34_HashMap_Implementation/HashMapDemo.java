public class HashMapDemo{
	public static void main(String[] args){
		Map<String, Integer> countryVsPeopleCountMap = new HashMap<>();

		countryVsPeopleCountMap.put("Egypt", 1);
		System.out.println("Egypt -> " + countryVsPeopleCountMap.get("Egypt"));

		countryVsPeopleCountMap.put("US", 2);
		countryVsPeopleCountMap.put("Russia", 4);
		countryVsPeopleCountMap.put("Canada", 3);
		countryVsPeopleCountMap.put("Egypt", 6);

		System.out.println("Size = " + countryVsPeopleCountMap.size());
		
		System.out.println("Egypt -> " + countryVsPeopleCountMap.get("Egypt"));
		System.out.println("US -> " + countryVsPeopleCountMap.get("US"));
		System.out.println("Russia -> " + countryVsPeopleCountMap.get("Russia"));
		System.out.println("Canada -> " + countryVsPeopleCountMap.get("Canada"));

		System.out.println("Removing Egypt...");
		countryVsPeopleCountMap.remove("Egypt");

		System.out.println("Egypt -> " + countryVsPeopleCountMap.get("Egypt"));

		HashMap<Integer, Integer> m = new HashMap<>();
		m.put(5,2);
		m.put(3,1);
		m.put(7,6);
		m.put(5,9);

		System.out.println("5 -> " + m.get(5));
		System.out.println("3 -> " + m.get(3));
		System.out.println("7 -> " + m.get(7));
	}
}