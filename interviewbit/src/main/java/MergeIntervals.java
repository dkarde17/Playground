import java.util.ArrayList;
import java.util.List;

/**
 * https://www.interviewbit.com/problems/merge-intervals/
 *
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
 *
 * You may assume that the intervals were initially sorted according to their start times.
 *
 * Example 1:
 *
 * Given intervals [1,3],[6,9] insert and merge [2,5] would result in [1,5],[6,9].
 *
 * Example 2:
 *
 * Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] would result in [1,2],[3,10],[12,16].
 *
 * This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
 *
 * Make sure the returned intervals are also sorted.
 */
public class MergeIntervals {
    /*
    idea is keep iterating and keep removing the unwanted entries
     */
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        if(newInterval == null)
            return intervals;
        else if(intervals == null || intervals.size() == 0) {
            intervals = new ArrayList<>();
            intervals.add(newInterval);
            return intervals;
        }

        int i = 0;
        while(i < intervals.size()) {
            Interval currInterval = intervals.get(i);
            if(newInterval.start > currInterval.end) {
                ++i;
                continue;
            } else if (newInterval.end < currInterval.start) {
                intervals.add(i, newInterval);
                break;
            } else {
                newInterval.start = Math.min(newInterval.start, currInterval.start);
                newInterval.end = Math.max(newInterval.end, currInterval.end);
                intervals.remove(i);
            }
        }
        if(i == intervals.size())
            intervals.add(newInterval);

        return intervals;
    }

    public static void main(String[] args) {
        MergeIntervals mergeIntervals = new MergeIntervals();
        ArrayList<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1, 2));
        intervals.add(new Interval(3, 6));
        ArrayList<Interval> insert = mergeIntervals.insert(intervals, new Interval(10, 8));
        System.out.println(insert);
    }

     public static class Interval {
         int start;
         int end;
         Interval() { start = 0; end = 0; }
         Interval(int s, int e) { start = s; end = e; }
     }
}
