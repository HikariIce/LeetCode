/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> res = new ArrayList<>();
		
		if(intervals == null || intervals.isEmpty()) {
			res.add(newInterval);
			return res;
		}
		

		for(int i = 0; i < intervals.size(); i++){
			Interval cur = intervals.get(i);
			
			if(newInterval.end < cur.start){
				res.add(newInterval);
				for(int j = i; j < intervals.size(); j++)
					res.add(intervals.get(j));
				break;
			}else if(cur.end < newInterval.start){
				res.add(cur);
			}else{
				newInterval.start = Math.min(newInterval.start, cur.start);
				newInterval.end = Math.max(newInterval.end, cur.end);
			}
			
			if(i == intervals.size()-1) res.add(newInterval);
		}
		
		
		return res;
    }
}