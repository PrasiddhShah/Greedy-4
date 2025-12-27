// Time Complexity :O(mlogk)
// Space Complexity :O(m)source string length
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

/*
we are maintaining a hashmap where keys are characters and value are the list of all the places where
that char has occured in the source string
we loop over target string to find it char in source using values from Hmap and doing binary search on
those values if the return ans of binary search is equal list length that mean we dont have any 
char left to add to current partition and we will have to start back from the first occurance of that character in source
so we set the value to first list value and increase the count
*/
class Solution {
    public int shortestWay(String source, String target) {
        int sl = source.length();
        int tl = target.length();
        int count = 1;
        int sp = 0; // source pointer
        int tp = 0; // target pointer
        HashMap<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < sl; i++) {
            char ch = source.charAt(i);
            if (!map.containsKey(ch)) {
                map.put(ch, new ArrayList<>());
            }
            map.get(ch).add(i);
        }
        while (tp < tl) {
            char c = target.charAt(tp);
            if (!map.containsKey(c)) {
                return -1;
            }
            List<Integer> sarr = map.get(c);
            int sidx = binarySearch(sarr, sp);
            if (sidx == sarr.size()) {
                sp = sarr.get(0);
                count++;
            } else {
                sp = sarr.get(sidx);
            }
            tp++;
            sp++;
        }
        return count;
    }

    private int binarySearch(List<Integer> li, int target) {
        int low = 0;
        int high = li.size() - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (li.get(mid) == target) {
                return mid;
            } else if (li.get(mid) > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}