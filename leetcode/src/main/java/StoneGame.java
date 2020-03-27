public class StoneGame {
    public boolean stoneGame(int[] piles) {
        int ans = 0;
        int i = 0, j = piles.length - 1;
        boolean flag = false;
        while (i <= j) {
            if (flag == false) {
                if (piles[i] > piles[j]) {
                    ans += piles[i];
                    i++;

                } else {
                    ans += piles[j];
                    j--;
                }
            } else if (flag == true) {
                if (piles[i] > piles[j]) {
                    ans -= piles[i];
                    i++;
                } else {
                    ans -= piles[j];
                    j--;
                }
                flag = !flag;
            }
        }

        if (ans > 0) return true;
        else return false;
    }

    public static void main(String[] args) {
        StoneGame stoneGame = new StoneGame();
        int[] piles = {3, 7, 2, 3};
        System.out.println(stoneGame.stoneGame(piles));
    }
}
