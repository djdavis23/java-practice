import java.util.Hashtable;
import java.util.HashSet;
public class FindSum {

	public static void main(String[] args) {
		int[] numbers = {1,2,3,4,5,6,7,8,9,10};
		int target = 8;
		int[] sumPair = findSumPair(numbers, target);
		System.out.println("Results of findSumPair:  " + sumPair[0] + ", " + sumPair[1]);
		System.out.println("Results of doesPairSum:  " + doesPairSum(numbers, target));
	}
	
	public static int[] findSumPair(int[] numbers, int target) {
		int[] pair = {-1,-1};
		Hashtable<Integer, Integer> sums = new Hashtable<Integer, Integer>();
		for (int i = 0; i < numbers.length; i++) {
			if (sums.containsKey(Integer.valueOf(numbers[i]))) {
				pair[0] = sums.get(Integer.valueOf(numbers[i]));
				pair[1] = i;
				return pair;
			}
			sums.put(Integer.valueOf(target - numbers[i]), Integer.valueOf(i));
		}
		return pair;
	}
	
	public static boolean doesPairSum(int[] numbers, int target) {
		HashSet<Integer> sums = new HashSet<Integer>();
		for (int i = 0; i < numbers.length; i++) {
			if (sums.contains(Integer.valueOf(numbers[i]))) {
				return true;
			}
			sums.add(Integer.valueOf(target - numbers[i]));
		}
		return false;
	}

}
