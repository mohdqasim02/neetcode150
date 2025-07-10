package arrays.longestconsecutivesequence;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;

        int longestLength = 1;
        Set<Integer> distinctNums = Arrays.stream(nums).boxed().collect(Collectors.toSet());


        for (Integer num: distinctNums) {
            int currentLength = 0;

            if (!distinctNums.contains(num - 1)) {
                int i = 1;
                currentLength = 1;
                while (distinctNums.contains(num + i)) {
                    currentLength += 1;
                    i++;
                }
            }

            if (currentLength > longestLength) longestLength = currentLength;
        }

        return longestLength;
    }
}