package algo.fun.algofun_prep.threemonth.week1.camelcase;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Solution {

    public static void main (String[] args) throws java.lang.Exception {
        final Scanner in  = new Scanner(System.in);
        
        while (in.hasNextLine()) {
            final String s = in.nextLine();
            final String processedString = createProcessedString(s);
            System.out.println(processedString);
        }

    }

    static String createProcessedString(final String s) {
        final StringTokenizer str = new StringTokenizer(s, ";");

        final String action = str.nextToken();
        final String strType = str.nextToken();
        final String string = str.nextToken();
        
        if (action.equals("S")) {
            return createSplitString(string);
        }

        if (strType.equals("M")) {
            return createCombinedMethod(string);
        }
        
        if (strType.equals("V")) {
            return createCombinedVariable(string);
        }

        return createCombinedClass(string);
    }

    private static String createCombinedMethod(final String string) {
        return createCombinedVariable(string) + "()";
    }

    private static String createCombinedVariable(final String string) {
        final String combinedClass = createCombinedClass(string);
        return firstLowerCase(combinedClass);
    }

    private static String createCombinedClass(final String string) {
        final String[] words = string.split(" ");
        return Arrays.stream(words)
                .map(Solution::firstUpperCase)
                .collect(Collectors.joining());
    }

    private static String createSplitString(final String string) {
        final String lowerTitleString = firstLowerCase(string);

        final char[] chars = lowerTitleString
                .replace("()", "")
                .toCharArray();

        final StringBuilder strBuilder = new StringBuilder();
        for (final char c : chars) {
            if (Character.isLowerCase(c)) {
                strBuilder.append(c);
                continue;
            }
            
            final char lowerC = Character.toLowerCase(c);
            strBuilder.append(" ").append(lowerC);
        }
        
        return strBuilder.toString();
    }

    private static String firstLowerCase(final String string) {
        final char[] chars = string.toCharArray();
        chars[0] = Character.toLowerCase(chars[0]);
        return new String(chars);
    }

    private static String firstUpperCase(final String string) {
        final char[] chars = string.toCharArray();
        chars[0] = Character.toUpperCase(chars[0]);
        return new String(chars);
    }

};
