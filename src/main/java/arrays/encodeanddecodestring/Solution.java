package arrays.encodeanddecodestring;

import java.util.ArrayList;
import java.util.List;

class Solution {

    public String encode(List<String> strs) {
        return strs.stream()
                .map(s -> s.length() + "#" + s)
                .reduce("", (a, b) -> a + b);
    }

    public List<String> decode(String str) {
        int splitIndex = 0;
        int currentIndex = 0;
        List<String> strings = new ArrayList<>();

        while (currentIndex < str.length()) {
            if (str.charAt(currentIndex) == '#') {
                int endIndex = currentIndex + 1 + Integer.parseInt(str.substring(splitIndex, currentIndex));

                strings.add(str.substring(currentIndex + 1, endIndex));
                splitIndex = endIndex;
                currentIndex = splitIndex;
            }
            currentIndex++;
        }

        return strings;
    }
}

