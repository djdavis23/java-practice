
public class BinarySearch {
	
	

	public static void main(String[] args) {
		// TEST BINARY SEARCH
		int[] numbers = {1,2,3,4,5,6,7,8,9,10};
		int target = 10;
		int found = binarySearch(numbers, 0, numbers.length-1, target);
		System.out.println("Binary search for " + target + ":  " + found);

	}
	
	//Binary search only works if the input array is sorted	
	public static int binarySearch(int[] numbers, int low, int high, int myNumber) {
		if (low <= high) {
			int mid = low + (high - low)/2;
			if (myNumber == numbers[mid]) {
				return mid;
				}
			else if (myNumber < numbers[mid]) {
				high = mid-1;
				return binarySearch(numbers, low, high, myNumber);
			}
			else {
				low = mid+1;
				return binarySearch(numbers, low, high, myNumber);
			}
		}
		
		return -1;
	}

}
