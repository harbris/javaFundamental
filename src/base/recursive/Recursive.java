package base.recursive;

public class Recursive {
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5};
		System.out.println(bTsearch(arr,5,0,arr.length-1));
	}
	
	public static int bTsearch(int[] arr, int target, int lower, int upper){
		
		int range,center;
		range = upper - lower;
		center = (range/2) + lower;
		
		if(range < 0){
			System.out.println("error:Limits reversed");
		}else if(range == 0 && arr[lower] != target){
			System.out.println("error:Element not in array");
		}
		
		if(arr[lower] > arr[upper]){
			System.out.println("error:Array not sorted");
		}
		
		if(arr[center] == target){
			return center;
		}else if(arr[center] > target){
			return bTsearch(arr, target, lower, center-1);
		}else{
			return bTsearch(arr, target, center+1, upper);
		}

	}
}
