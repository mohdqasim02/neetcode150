package slidingwindows.longestsubstring;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> distinctStr = new HashSet<>();
        int maxLength = 0;

        int l = 0;
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            while (distinctStr.contains(currentChar)) {
                distinctStr.remove(s.charAt(l));
                l++;
            }

            distinctStr.add(currentChar);
            maxLength = Math.max(maxLength, distinctStr.size());
        }

        return maxLength;
    }
}

