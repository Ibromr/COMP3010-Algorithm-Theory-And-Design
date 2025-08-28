// Week 2 Workshop Question 4
/*
 * Homework - Not provided by tutors Give your “best-possible” algorithm (and its
   worst-case complexity in time) for the following problem:
   You are given an array of n integers, give an algorithm that finds two elements a and b
   (among n in the array) which largest possible difference (a − b is the maximum value,
   a > b).
 */
public class MaxDifference {

    public static void main(String[] args) {
        System.out.println(maxDiff(new int[] {7, 2, 9, 4, 1, 5, 3}));
    }
    static int maxDiff(int[] arr) {
        int minSoFar = arr[0];
        int a = arr[0];
        for (int i = 1; i < arr.length; i++) {  
            if(arr[i] > a) {
                a = arr[i];
            }
            if(arr[i] < minSoFar) {
                minSoFar = arr[i];
            }
        }
        System.out.println("b is " + minSoFar+"\n"+"a is " + a);
        return a - minSoFar;
    }
}
