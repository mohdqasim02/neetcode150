package towpointers.twosumparttwo;

public class Solution {
    public static int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1;

        while (j >= 0 && i < numbers.length) {
            int curSum = numbers[i] + numbers[j];

            if (curSum == target) return new int[] {i+1, j+1};
            if (curSum > target) j--;
            if (curSum < target) i++;
        }

        return new int[] {-1, -1};
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        System.out.println("args = " + twoSum(nums, 4));
    }
}