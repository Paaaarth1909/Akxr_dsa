/* Given two integers a and b in the form of strings. Return the last digit of ab.

Examples:

Input: a = "3", b = "10"
Output: 9
Explanation: 310 = 59049. Last digit is 9.
Input: a = "6", b = "2"
Output: 6
Explanation: 62 = 36. Last digit is 6.
Constraints:
1 ≤ a.size(), b.size() ≤ 1000
a and b consist only of numeric digits ('0' - '9')
a and b do not contain any leading zeros, except when number itself is "0"
*/
class Solution {
    
    public int getLastDigit(String a, String b) {
        
        if (b.equals("0")) {
            return 1;
        }

        int lastDigit = a.charAt(a.length() - 1) - '0';

        int expMod4 = 0;
        for (int i = 0; i < b.length(); i++) {
            expMod4 = (expMod4 * 10 + (b.charAt(i) - '0')) % 4;
        }

        if (expMod4 == 0) {
            expMod4 = 4;
        }

        int result = 1;

        for (int i = 0; i < expMod4; i++) {
            result = (result * lastDigit) % 10;
        }

        return result;
    }
}