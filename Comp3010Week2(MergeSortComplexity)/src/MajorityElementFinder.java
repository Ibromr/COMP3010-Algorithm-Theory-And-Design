public class MajorityElementFinder {

    // Week 2 - Workshop Q3
    /*
     *  Given a list of n numbers, you want to output the Majority element (if exists, null
        otherwise). The majority element is the element that occurs repeatedly for more than
        half of the elements of the input. Assuming that a comparison takes O(1) computation
        cost (i.e., a constant time).

        Boyer-Moore majority vote algorithm:
     */
    public static Integer findMajorityElement(int[] nums) {
        Integer candidate = null;
        int count = 0;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
                count = 1;
            } else if (candidate == num) {
                count++;
            } else {
                count--;
            }
        }

        count = 0;
        for (int num : nums) {
            if (num == candidate) {
                count++;
            }
        }

        if (count > nums.length / 2) {
            return candidate;
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {2, 2, 1, 2, 3, 2, 2, 2, 3}; // Majority element exists
        int[] arr2 = {1, 2, 3, 4, 5};       // No majority element

        System.out.println("Majority in arr1: " + findMajorityElement(arr1));
        System.out.println("Majority in arr2: " + findMajorityElement(arr2));
    }
}
