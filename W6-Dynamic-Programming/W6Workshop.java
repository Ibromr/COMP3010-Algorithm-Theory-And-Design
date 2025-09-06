import java.util.*;

public class W6Workshop {
    private int[] myArray;
    
	public W6Workshop(int[] myArray) {
		this.myArray = Arrays.copyOf(myArray, myArray.length);
	}

	void printAll() {
		for (int i = 0; i < myArray.length; i++)
			System.out.println(myArray[i]);
	}
    
    /*
     * 1. An inversion in an array A is a pair of indexes (i, j), with i < j, but with A[i] > A[j] (i.e., a
    pair of indexes that references values that are out of increasing order).
    
    • What is the maximum number of inversions in an array of size n?
    • Give an O(n log n) algorithm that returns the number of inversions. Provide the complexity
    analysis of your algorithm using asymptotic notations

	Analysis:
	This is because of using Merge Sort algorithm  we know:
	At each level, it splits the array into two halves (2T(n/2)) and merges in linear time (O(n)).
	The recurrence relation for the algorithm is:
	T(n) = 2T(n/2) + O(n)

     */

    /*
     * 2. Considering two databases A and B containing n sorted values each (there are 2n values total),
    you may assume that no two values are the same. You need determine the median of this set
    of 2n values, which we will define here to be the n
    th smallest value. However, the only way you
    can access these values is through queries to the databases. In a single query, you can specify a
    value k to one of the two databases, and the chosen database will return the k
    th smallest value
    that it contains. Since queries are expensive, you would like to compute the median using as
    few queries as possible.
    
    Give an algorithm that finds the median value using at most O(log n) queries.

	Analysis:
	In each recursive step, we compare the medians of both arrays
	Based on the comparison, we discard approximately half of the elements
	The problem size reduces from n to approximately n/2 in each iteration

	This gives us a recurrence relation: T(n) = T(n/2) + O(1)

     */


	 /*
	  * 3. Home work - Self-Diagnostic Question. Consider a sequence of 2n values as input.
	• Give an efficient algorithm that partitions the numbers into n pairs, with the property that
	the partition minimizes the maximum sum of a pair.
	For example, say we are given the numbers (2,3,5,9). The possible partitions are ((2,3),(5,9)),
	((2,5),(3,9)), and ((2,9),(3,5)). The pair sums for these partitions are (5,14), (7,12), and
	(11,8). Thus the third partition has 11 as its maximum sum, which is the minimum over
	the three partitions.
	• Give and justify its complexity.

	Analysis: 
	This algorithm works because pairing the smallest with the largest values balances the sums
	Any other pairing strategy would create more imbalanced pairs
	The goal is to minimize the maximum pair sum, which is achieved when the largest element is paired with the smallest element
	This "greedy" approach is optimal for this problem because it minimizes the maximum possible pair sum

	Time Complexity: O(n log n)
	Sorting the array takes O(n log n) time
	Pairing elements takes O(n) time
	Overall complexity is dominated by the sorting step: O(n log n)

	Space Complexity: O(n)
	We need O(n) space to store the n pairs
	If we return just the pairing indices, it would still be O(n)
	  */
    public static void main(String[] args) {
		int[] arr = {8, 9, 2, 4, 7, 6};
		W6Workshop array = new W6Workshop(arr);
		System.out.println("Starting to find inversions...");  //Answer 1
		System.out.println(array.sortUsingMergeCountInversion());
		System.out.println();
		System.out.println("Starting FindMedian..."); 		   //Answer 2
		System.out.println(findMedian(new int[]{1, 3, 5, 7}, new int[]{2, 4, 6, 8}, 4 ));

		System.out.println();
		System.out.println("Starting findOptimalPairing...");  //Answer 3
		int[][] result = findOptimalPairing(new int[]{2,3,5,9});
		System.out.println(Arrays.deepToString(result));
    }														   
    														   

    // Q1
	int countInversion(int[] arr, int first, int last) {
		int result = 0;
		// POST: sorts the array portion A[first..last]
		if (first < last) { // just swap the nodes;
			result += countInversion(arr, first, (first + last) / 2);
			result += countInversion(arr, (first + last) / 2 + 1, last);
			// PRE for MERGE: the array portions A[first..(first+last)/2]
			// and A[(first+last)/2+1..last] are sorted
			result += mergeAndCount(arr, first, (first + last) / 2 + 1, last);
		}
		return result;
	}

	int mergeAndCount(int[] arr, int a, int mid, int b) {
		
		int count = 0;
        if (a <= b && mid >= a && mid <= b) {
			int[] tA = new int[b - a + 1];
			int i = a;
			int j = mid;
			int ti = 0;
			
			while (i < mid && j < b + 1) {		// Handle conquer left and right array
				if (arr[i] <= arr[j]) {
					tA[ti] = arr[i];
					i++;
				} else {
					tA[ti] = arr[j];
					j++;
                    count += (mid - i);
				}
				ti++;
			}
			if (i < mid) {						// Hanle if there is only one element left after this
				for (; i < mid; i++) {
					tA[ti] = arr[i];
					ti++;
				}
			} else {
				for (; j < b + 1; j++) {
					tA[ti] = arr[j];
					ti++;
				}
			}
			// copy back to A
			for (int k = a; k <= b; k++) {
				arr[k] = tA[k - a];
			}
		}
        return count;
	}
    
	int sortUsingMergeCountInversion() {
		return countInversion(myArray, 0, myArray.length - 1);
	}

	// Q2
	public static int findMedian(int[] array1, int[] array2, int n) {
		if (n == 1) {
			return Math.min(array1[0], array2[0]); 
		}

		// Finding median
		int mid1 = (n - 1) / 2;
		int mid2 = (n - 1) / 2;
		int median1 = array1[mid1];
		int median2 = array2[mid2];

		if (median1 == median2) {
			return median1;
		}

		if (median1 < median2) {
			if (n == 2) {
				return Math.min(array1[1], array2[0]);
			}

			// Discard left of Array1 and right of Array2
			int[] newArray1 = Arrays.copyOfRange(array1, n/2, n);
			int[] newArray2 = Arrays.copyOfRange(array2, 0, n-n/2 ); // n/2 + n%2
			
			// Send new range
			return findMedian(newArray1, newArray2, n - n/2);
		} 
		else { // Median1 > Median2
			if (n == 2) {
				return Math.min(array1[0], array2[1]);
			}

			// Discard right of Array1 and left of Array2
			int[] newArray1 = Arrays.copyOfRange(array1, 0, n-n/2);
			int[] newArray2 = Arrays.copyOfRange(array2, n/2, n);
			
			// Send new range
			return findMedian(newArray1, newArray2, n - n/2);
		}
	}

	// Q3
	public static int[][] findOptimalPairing(int[] arr) {
		// Sort the array
		Arrays.sort(arr);
		
		int n = arr.length / 2;
		int[][] pairs = new int[n][2];
		
		// Pair smallest with largest
		for (int i = 0; i < n; i++) {
			pairs[i][0] = arr[i];
			pairs[i][1] = arr[2*n - 1 - i];
		}
		
		return pairs;
	}
}


