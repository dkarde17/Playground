/**
 * You are given an array coordinates, coordinates[i] = [x, y], where [x, y] represents the coordinate of a point. Check if these points make a straight line in the XY plane.
 *
 *
 *
 *
 *
 * Example 1:
 *
 *
 *
 * Input: coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]
 * Output: true
 * Example 2:
 *
 *
 *
 * Input: coordinates = [[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]]
 * Output: false
 *
 *
 * Constraints:
 *
 * 2 <= coordinates.length <= 1000
 * coordinates[i].length == 2
 * -10^4 <= coordinates[i][0], coordinates[i][1] <= 10^4
 * coordinates contains no duplicate point.
 */
public class CheckIfItIsAStraightLine {
    public boolean checkStraightLine(int[][] coordinates) {
        if(coordinates.length == 2)
            return true;
        //calculating line equation from first two points
        double slope = ((coordinates[1][1] - coordinates[0][1]) * 1.0)/(coordinates[1][0] - coordinates[0][0] * 1);
        double constant = coordinates[0][1] - slope * coordinates[0][0];
        for(int i = 2; i < coordinates.length; i++) {
            if(!isOnLine(slope, constant, coordinates[i][0], coordinates[i][1]))
                return false;
        }
        return true;
    }

    private boolean isOnLine(double slope, double constant, int x, int y) {
        return y == slope * x + constant;
    }

    /*
    can also use this equation for 3 collinear points 1, 2 and 3
    (y2 - y1)/(x2 - x1) == (y3 - y1)/(x3-x1) //which means same slope
    which can also be written as:
    (y2 - y1) * (x3 - x1) == (y3 - y1) * (x2 - x1) //do simplify the calculations, division will bring in decimal so it's good to avoid division
    you can precalculate y2 - y1 and x2 - x1 and use it for every point
     */
}
