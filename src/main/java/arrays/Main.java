package arrays;

import arrays.twosum.Solution;

public class Main {
    public static void main(String[] args) {

        int[] answer = new Solution().twoSum(new int[]{2, 7, 11, 15}, 9);
        System.out.println("Welcome to the Arrays and Hashing module!" + " \n" +
                "The answer to the Two Sum problem is: [" + answer[0] + ", " + answer[1] + "]");
    }
}
