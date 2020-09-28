import java.util.Scanner;

public class URLify {
    public static void main (String[] args) {
        //code
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        scanner.nextLine();
        for(int i = 0; i < t; i++) {
            char[] chars = scanner.nextLine().toCharArray();
            int k = scanner.nextInt();
            if(i != t - 1)
                scanner.nextLine();
            String urilifiedString = urilify(chars, k);
            System.out.println(urilifiedString);

        }
    }

    private static String urilify(char[] chars, int k) {
        int end = chars.length - 1;
        int start = k - 1;
        while(start >= 0 && end > 0) {
            if(chars[start] == ' ') {
                chars[end--] = '0';
                chars[end--] = '2';
                chars[end--] = '%';
            } else chars[end--] = chars[start];
            --start;
        }
        return new String(chars);
    }
}
