package slidingwindows.characterreplacement;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0;
        int maxLength = 0;
        int maxFrequency = 0;
        Map<Character, Integer> frquencyMap = new HashMap<>();

        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);
            int currentLength = right - left + 1;
            int count = frquencyMap.getOrDefault(currentChar, 0) + 1;

            frquencyMap.put(currentChar, count);
            maxFrequency = Math.max(maxFrequency, count);

            if (currentLength - maxFrequency <= k) {
                maxLength = Math.max(maxLength, currentLength);
            } else {
                char leftChar = s.charAt(left);
                int leftCharCount = frquencyMap.get(leftChar) - 1;
                frquencyMap.put(leftChar, leftCharCount);
                left++;
            }
        }

        return maxLength;
    }
}