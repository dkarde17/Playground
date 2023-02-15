package com.divyekarde.dev;
import java.util.Scanner;

public class LongestWord {
    /**
     * Longest Word
     * Have the function LongestWord(sen) take the sen parameter being passed
     * and return the longest word in the string. If there are two or more
     * words that are the same length, return the first word from the string
     * with that length. Ignore punctuation and assume sen will not be empty.
     * Words may also contain numbers, for example "Hello world123 567"
     * Examples
     * Input: "fun&!! time"
     * Output: time
     * Input: "I love dogs"
     * Output: love
     *
     * https://coderbyte.com/editor/Longest%20Word:Java
     * @param sen
     */
    public static String LongestWord(String sen) {
        char[] arr = sen.toCharArray();
        int length = sen.length();
        int start = 0;
        int end = 0;
        int currLen = 0;
        int max = Integer.MIN_VALUE;
        int maxLeftIndex = start;
        int maxRightIndex = end;
        while(end < length) {
            if(((int) arr[end] > (int) 'a' && (int) arr[end] < (int) 'z') || ((int) arr[end] > (int) 'A' && (int) arr[end] < (int) 'Z')) {
                currLen++;
            } else {
                currLen = 0;
                start = end + 1;
            }
            if(max < currLen) {
                max = currLen;
                maxLeftIndex = start;
                maxRightIndex = end;
            }
            end++;
        }

        return sen.substring(maxLeftIndex, maxRightIndex + 1);
    }

    public static void main (String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        System.out.print(LongestWord(s.nextLine()));
    }
}