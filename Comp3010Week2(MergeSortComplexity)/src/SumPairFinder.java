import java.util.HashSet;

 // Week 2 - Workshop Q2
 /*
  * For the following problem, identify the input and its size, think of the “best possible”
    algorithm (as in the most effective in use of CPU and memory), give its complexity (worstcase analysis in big-Oh notation):
    You are given a set of n integers and a special integer K, give an algorithm that checks
    if there exists two numbers (among n) which sum equals K.
    solution: in order of quality
  */
public class SumPairFinder {
    public static boolean hasPairWithSum(int[] arr, int k) {
        HashSet<Integer> seen = new HashSet<>();

        for (int num : arr) {
            int complement = k - num;
            if (seen.contains(complement)) {
                System.out.println("Pair found: " + num + " + " + complement + " = " + k);
                return true;
            }
            seen.add(num);
        }

        System.out.println("No pair found with sum " + k);
        return false;
    }

    public static void main(String[] args) {
        int[] numbers = {4, 7, 1, 9, 2, 5, 11, 6, 3, 8};
        int k = 10;

        hasPairWithSum(numbers, k);
    }
}
