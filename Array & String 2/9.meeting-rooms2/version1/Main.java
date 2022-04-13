public class Main {
    public static void main(String[] args) {

    }
}

/**
 * Definition of Interval:
 * public classs Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

public class Solution {
    /**
     * @param intervals: an array of meeting time intervals
     * @return: the minimum number of conference rooms required
     */
    public int minMeetingRooms(List<Interval> intervals) {
        Collections.sort(intervals, (a, b) -> {
            if (a.end != b.end)
                return Integer.compare(a.start, b.start);
            return Integer.compare(a.end, b.end);
        });

        PriorityQueue<Interval> minheap = new PriorityQueue<>((a, b) -> {
            if (a.end != b.end)
                return Integer.compare(a.end, b.end);
            return Integer.compare(a.start, b.start);
        });

        minheap.add(intervals.get(0));

        int size = intervals.size();
        for (int i = 1; i < size; i++) {
            Interval next = intervals.get(i);

            if (minheap.peek().end <= next.start) {
                minheap.poll();
            }

            minheap.add(next);

        }

        return minheap.size();

    }
}

//see version2
