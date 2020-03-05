public class NumberOfStepsToReduceANumberToZero_1342 {
    public int numberOfSteps (int num) {
        int steps = 0;
        while(num > 0) {
            steps++;
            if(num%2 == 0)
                num = num >> 1;
            else num -= 1;
        }
        return steps;
    }
}
