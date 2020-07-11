import java.util.ArrayList;
import java.util.List;

/**
 * https://www.interviewbit.com/problems/gas-station/
 * Given two integer arrays A and B of size N.
 * There are N gas stations along a circular route, where the amount of gas at station i is A[i].
 *
 * You have a car with an unlimited gas tank and it costs B[i] of gas to travel from station i
 * to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.
 *
 * Return the minimum starting gas station’s index if you can travel around the circuit once, otherwise return -1.
 *
 * You can only travel in one direction. i to i+1, i+2, … n-1, 0, 1, 2.. Completing the circuit means starting at i and
 * ending up at i again.
 *
 *
 *
 * Input Format
 *
 * The first argument given is the integer array A.
 * The second argument given is the integer array B.
 * Output Format
 *
 * Return the minimum starting gas station's index if you can travel around the circuit once, otherwise return -1.
 * For Example
 *
 * Input 1:
 *     A =  [1, 2]
 *     B =  [2, 1]
 * Output 1:
 *     1
 *     Explanation 1:
 *         If you start from index 0, you can fill in A[0] = 1 amount of gas. Now your tank has 1 unit of gas. But you need B[0] = 2 gas to travel to station 1.
 *         If you start from index 1, you can fill in A[1] = 2 amount of gas. Now your tank has
 */
public class GasStation {
    public int canCompleteCircuit(final List<Integer> A, final List<Integer> B) {
        int ans = -1;
        if(A == null || A.size() == 0 || B == null || B.size() == 0)
            return ans;
        else if (A.size() == 1)
            return A.get(0) < B.get(0) ? -1 : 0;
        int i = 0;
        int n = A.size();
        while(i < n) {
            int res = 0;
            for(int j = 0; j < n; j++) {
                int k = (i + j)%n;
                res = res + A.get(k) - B.get(k);
                if(res < 0)
                    break;
                else if(j == n - 1) {
                    ans = i;
                    break;
                }
            }
            if(ans > -1)
                break;
            ++i;
        }
        return ans;
    }

    public static void main(String[] args) {
        GasStation gasStation = new GasStation();
        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();
        int[] arrA = {383, 521, 491, 907, 871, 705};
        int[] arrB = {96, 197, 592, 67, 77, 641};
        for(int i = 0; i < arrA.length; i++) {
            a.add(arrA[i]);
            b.add(arrB[i]);
        }
        System.out.println(gasStation.canCompleteCircuit(a, b));
    }
    //kadane
    /*
    vector<int> leftOver;

for(int i = 0; i < A.size(); i++){
    leftOver.push_back(A[i] - B[i]);
}

int left_sum = 0;
int curr_sum = 0;
int curr = 0;
for(int i = 0; i < A.size(); i++){
    curr_sum += leftOver[i];

    if(curr_sum < 0){
        left_sum += curr_sum;
        curr_sum = 0;
        curr = i+1;
    }
}

if(left_sum + curr_sum >= 0)
    return curr;

return -1;
     */
}
