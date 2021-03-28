package algo11;

// 1854 K번째 최단경로 찾기
import java.awt.Point;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1854 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		@SuppressWarnings("unchecked")
		ArrayList<Point> arr[] = new ArrayList[N + 1];
		@SuppressWarnings("unchecked")
		PriorityQueue<Integer> t[] = new PriorityQueue[N + 1];
		for (int i = 0; i < N + 1; i++) {
			arr[i] = new ArrayList<>();
			t[i] = new PriorityQueue<>(Collections.reverseOrder());
		}

		while (M-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			arr[a].add(new Point(b, w));

		}

		PriorityQueue<Point> q = new PriorityQueue<>(new Comparator<Point>() {

			@Override
			public int compare(Point o1, Point o2) {
				// TODO Auto-generated method stub
				return o1.y - o2.y;
			}
		});

		q.add(new Point(1, 0));
		t[1].add(0);
		while (!q.isEmpty()) {
			Point p = q.poll();
			int now = p.x;
			int w = p.y;
			int size = arr[now].size();
			for (int i = 0; i < size; i++) {
				int next = arr[now].get(i).x;
				int nextw = arr[now].get(i).y + w;
				if (t[next].size() < K) {
					t[next].add(nextw);
					q.add(new Point(next, nextw));
				} else if (t[next].peek() > nextw) {
					t[next].poll();
					t[next].add(nextw);
					q.add(new Point(next, nextw));
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < N + 1; i++) {
			if (t[i].size() < K) {
				sb.append("-1\n");
			} else {

				sb.append(t[i].peek() + "\n");

			}
		}
		bw.write(sb.toString());
		br.close();
		bw.close();

	}

}
