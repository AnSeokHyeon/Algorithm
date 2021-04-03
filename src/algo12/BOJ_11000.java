package algo12;

//11000 강의실 배정
import java.awt.Point;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_11000 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());

		PriorityQueue<Point> q = new PriorityQueue<>(new Comparator<Point>() {

			@Override
			public int compare(Point o1, Point o2) {
				// TODO Auto-generated method stub
				if (o1.x == o2.x)
					return o1.y - o2.y;
				return o1.x - o2.x;
			}
		});
		PriorityQueue<Integer> c = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());

			q.add(new Point(start, end));
		}

		while (!q.isEmpty()) {
			Point p = q.poll();
			int start = p.x;
			int end = p.y;

			if (!c.isEmpty() && start >= c.peek()) {
				c.remove();
			}
			c.add(end);
		}
		bw.write(c.size() + "");
		br.close();
		bw.close();
	}

}