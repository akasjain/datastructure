package leetcode.challenge.may;

/**
 Week2 May8
 https://leetcode.com/problems/check-if-it-is-a-straight-line/

 You are given anarray coordinates, coordinates[i] = [x, y], where [x, y] represents the coordinate of a point.
 Check if these points make a straight line in the XY plane.

 Example 1:
    Input: coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]
    Output: true

 Example 2:
    Input: coordinates = [[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]]
    Output: false

 Constraints:
    1. 2 <= coordinates.length <= 1000
    2.  coordinates[i].length == 2
    3. -10^4 <= coordinates[i][0], coordinates[i][1] <= 10^4
    4. coordinates contains no duplicate point.

 */
public class C08_CheckIfItIsAStraightLine {
    public boolean checkStraightLine(int[][] coordinates) {
        int y1y2 = 0, x1x2 = 0;

        if (coordinates.length == 2)     // two points always form a straight line
            return true;

        y1y2 = coordinates[1][1] - coordinates[0][1];
        x1x2 = coordinates[1][0] - coordinates[0][0];

        for (int i = 2; i < coordinates.length; i++) {
            if (((coordinates[i][0]-coordinates[1][0])*y1y2) != ((coordinates[i][1]-coordinates[1][1])*x1x2)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        C08_CheckIfItIsAStraightLine obj = new C08_CheckIfItIsAStraightLine();

        int[][] coordinates = new int[][]{{1,2},{2,3},{3,4},{4,5},{5,6},{6,7}};
        System.out.println(obj.checkStraightLine(coordinates));

        coordinates = new int[][]{{0,2},{0,3},{0,4},{0,5}};
        System.out.println(obj.checkStraightLine(coordinates));

        coordinates = new int[][]{{1,1},{2,2},{3,4},{4,5},{5,6},{7,7}};
        System.out.println(obj.checkStraightLine(coordinates));

        coordinates = new int[][]{{-7,-3},{-7,-1},{-2,-2},{0,-8},{2,-2},{5,-6},{5,-5},{1,7}};
        System.out.println(obj.checkStraightLine(coordinates));
    }
}
