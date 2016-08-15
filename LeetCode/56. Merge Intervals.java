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
    public List<Interval> merge(List<Interval> intervals) {
		List<Interval> res = new ArrayList<>();
		
		if(intervals == null || intervals.isEmpty()) return res;
		
		Collections.sort(intervals, new Comparator<Interval>(){
			@Override
			public int compare(Interval t1, Interval t2){
				// TODO Auto-generated method stub
				return t1.start - t2.start;
			}
		});
		
		Interval cur = intervals.get(0);
		for(int i = 0; i < intervals.size(); i++){
			Interval next = intervals.get(i);
			if(cur.end >= next.start){
				cur.end = Math.max(cur.end, next.end);
			} else{
				res.add(cur);
				cur = next;
			}
		}
		res.add(cur);
		return res;
    }
}