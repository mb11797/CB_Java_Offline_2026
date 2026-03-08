public class Sort0s1s2s{

	public static void swap(int[] arr, int i, int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void printArr(int[] arr){
		for(int i=0; i<arr.length; i++){
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static void sortColors_DNF_Algo(int[] arr){
		int n = arr.length;
		int beg = 0;
		int mid = 0;
		int en = n-1;

		while(mid <= en){
			if(arr[mid] == 0){
				swap(arr, mid, beg);
				mid++;
				beg++;
			}
			else if(arr[mid] == 1){
				mid++;
				continue;	// not mandatory
			}
			else{
				// case arr[mid] == 2
				swap(arr, mid, en);
				en--;
			}
		}
	}

	public static void main(String[] args){
		int[] arr = {2,0,1,1,2,0,1,0};
		
		printArr(arr);
		sortColors_DNF_Algo(arr);
		printArr(arr);
	}
}