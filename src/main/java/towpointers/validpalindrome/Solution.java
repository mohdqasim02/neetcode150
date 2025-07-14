package towpointers.validpalindrome;

import java.util.Locale;

class Solution {
    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        String  lowerCaseString = s.toLowerCase(Locale.ENGLISH);

        while (i <= j) {
            if (isNotAlphaNumeric(lowerCaseString.charAt(i))) {
                i += 1;
                continue;
            }

            if (isNotAlphaNumeric(lowerCaseString.charAt(j))) {
                j -= 1;
                continue;
            }

            if (lowerCaseString.charAt(i) != lowerCaseString.charAt(j)) return false;

            i++; j--;
        }

        return true;
    }

    private boolean isNotAlphaNumeric(char c) {
        return !Character.isLetterOrDigit(c);
    }
}

