package algorithms.implementation;

/**
 * https://www.hackerrank.com/challenges/breaking-best-and-worst-records/problem
 */
public class BreakingTheRecords {
    static int[] breakingRecords(int[] score) {
        // Complete this function
        int[] recordBreakingRecord = {0,0};
        int minS, maxS;
        minS = maxS = score[0];
        for(int i = 1; i < score.length; i++) {
            if(score[i] > maxS){
                recordBreakingRecord[0]++;
                maxS = score[i];
            }
            if(score[i] < minS){
                recordBreakingRecord[1]++;
                minS = score[i];
            }
        }
        return recordBreakingRecord;
    }

    public static void main(String[] args) {
        /*Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] score = new int[n];
        for(int score_i = 0; score_i < n; score_i++){
            score[score_i] = in.nextInt();
        }*/
        int[] score = {10,5,20,20,4,5,2,25,1};
        int[] result = breakingRecords(score);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? " " : ""));
        }
        System.out.println("");


//        in.close();
    }
}
