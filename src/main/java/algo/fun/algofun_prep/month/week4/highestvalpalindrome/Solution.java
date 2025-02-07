package algo.fun.algofun_prep.month.week4.highestvalpalindrome;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

class Result {

    /*
     * Complete the 'highestValuePalindrome' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. INTEGER n
     *  3. INTEGER k
     */
    
    private static class PalindromeWrapper {
        String palindrome;
        int remainingChanges;
        Set<Integer> changedPos;

        PalindromeWrapper(final String palindrome, final int remainingChanges, final Set<Integer> changedPos) {
            this.palindrome = palindrome;
            this.remainingChanges = remainingChanges;
            this.changedPos = changedPos;
        }
    }

    public static String highestValuePalindrome(String s, int n, int k) {
        final PalindromeWrapper palindromeWrapper = createPalindrome(s, k);

        final int remainingChanges = palindromeWrapper.remainingChanges;
        if (remainingChanges < 0) {
            return "-1";
        }

        if (remainingChanges == 0) {
            return palindromeWrapper.palindrome;
        }

        return fillNines(palindromeWrapper);
    }

    private static String fillNines(final PalindromeWrapper palindromeWrapper) {
        final String palindrome = palindromeWrapper.palindrome;
        final Set<Integer> changedPos = palindromeWrapper.changedPos;

        final char[] chars = palindrome.toCharArray();

        int leftPos = 0;
        int rightPos = palindrome.length() - 1;
        int remainingChanges = palindromeWrapper.remainingChanges;

        while (leftPos < rightPos && remainingChanges > 0) {
            if (chars[leftPos] == '9' && chars[rightPos] == '9') {
                leftPos++;
                rightPos--;
                continue;
            }
            
            if (changedPos.contains(leftPos) || chars[leftPos] == '9' || chars[rightPos] == '9') {
             
                chars[leftPos] = '9';
                chars[rightPos] = '9';
                remainingChanges--;
                
            } else if (remainingChanges >= 2) {
                
                chars[leftPos] = '9';
                chars[rightPos] = '9';
                remainingChanges -= 2;
                
            }

            leftPos++;
            rightPos--;
        }

        if (leftPos == rightPos && remainingChanges > 0) {
            chars[leftPos] = '9';
        }

        return new String(chars);
    }

    private static PalindromeWrapper createPalindrome(final String s, final int k) {
        final char[] chars = s.toCharArray();
        final Set<Integer> changedPos = new HashSet<>();
        int remainingChanges = k;

        int leftPos = 0;
        int rightPos = s.length() - 1;

        while (leftPos < rightPos && remainingChanges >= 0) {
            final char leftChar = chars[leftPos];
            final char rightChar = chars[rightPos];

            if (leftChar == rightChar) {
                leftPos++;
                rightPos--;
                continue;
            }

            if (leftChar > rightChar) {
                chars[rightPos] = leftChar;
            } else {
                chars[leftPos] = rightChar;
            }

            remainingChanges--;

            changedPos.add(leftPos);
            changedPos.add(rightPos);

            leftPos++;
            rightPos--;
        }

        final String palindrome = new String(chars);
        
        return new PalindromeWrapper(palindrome, remainingChanges, changedPos);
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        String s = bufferedReader.readLine();

        String result = Result.highestValuePalindrome(s, n, k);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
