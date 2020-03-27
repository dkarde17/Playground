public class DIStringMatch {
    public int[] diStringMatch(String S) {
        int n = S.length();
        int lo = 0, hi = n;
        int[] arr = new int[n + 1];
        for(int i = 0; i < n; i++) {
            if(S.charAt(i) == 'I')
                arr[i] = lo++;
            else arr[i] = hi--;
        }
        arr[n] = hi;
        return arr;
    }
}
