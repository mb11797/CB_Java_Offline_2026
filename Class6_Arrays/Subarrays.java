public class Subarrays{
	public static void main(String[] args){

		int[] arr = {3,2,1,6,5};
		for(int i=0; i<arr.length; i++){
			for(int j=i; j<arr.length; j++){
				// print all elements from i to j
				for(int k=i; k<=j; k++){
					System.out.print(arr[k] + " ");
				}
				System.out.println();
			}
		}
		return;
	}
}