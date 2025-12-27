// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

/*
for use to be able to make the rotation the numeber has to least one arr, tops or bottoms
we here we assume that number is in tops and we try to find answer in that
if we find it return that value or else we search bottoms 
*/
class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int re = check(tops, bottoms, tops[0]);
        if (re != -1)
            return re;
        return check(tops, bottoms, bottoms[0]);

    }

    private int check(int[] tops, int[] bottoms, int target) {
        int trot = 0;
        int brot = 0;
        for (int j = 0; j < tops.length; j++) {
            if (tops[j] != target && bottoms[j] != target) {
                return -1;
            }
            if (tops[j] != target) {
                trot++;
            }
            if (bottoms[j] != target) {
                brot++;
            }
        }
        return Math.min(brot, trot);
    }
}