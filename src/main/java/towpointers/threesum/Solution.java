package towpointers.threesum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int a = nums[i];
            if (a > 0) break;
            if (i > 0 && a == nums[i - 1]) continue;

            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                int b = nums[l];
                int c = nums[r];
                int curSum = a + b + c;

                if (curSum == 0) {
                    result.add(List.of(a, b, c));
                    l++; r--;

                    while (l < r && nums[l] == b) l++;
                    while (l < r && nums[r] == c) r--;
                }
                if (curSum > 0) r--;
                if (curSum < 0) l++;
            }
        }

        return result;
    }
}