package slidingwindows.slidingwindowmaximum;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length + 1 - k];

        int left = 0;
        int right = 0;
        Deque<Integer> deque = new ArrayDeque<>();


        while (right < nums.length) {
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[right]) {
                deque.removeLast();
            }
            deque.add(right);

            if (left > deque.peekFirst()) deque.removeFirst();
            if (right - left + 1 == k) {
                result[left] = nums[deque.peekFirst()];
                left++;
            }
            right++;
        }

        return result;
    }
}



