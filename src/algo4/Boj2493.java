package algo4;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Boj2493 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		StringTokenizer S = new StringTokenizer(br.readLine(), " ");
		Stack<Point> top = new Stack<>();
		Stack<Point> wait = new Stack<>();
		PriorityQueue<Point> q = new PriorityQueue<Point>(new Comparator<Point>() {

			@Override
			public int compare(Point o1, Point o2) {
				// TODO Auto-generated method stub
				if (o1.x > o2.x) {
					return 1;
				} else {
					return -1;
				}

			}
		});
		int num = 1;
		while (S.hasMoreTokens()) {
			top.push(new Point(num++, Integer.parseInt(S.nextToken())));
		}
		while (top.size() > 0) {

			Point now = top.peek();
			top.pop();
			if (!top.isEmpty()) {
				Point next = top.peek();
				if (next.y > now.y) {
					q.add(new Point(now.x, next.x));
					while (wait.size() > 0) {
						Point w = wait.peek();

						if (!(next.y > w.y))
							break;

						q.add(new Point(w.x, next.x));
						wait.pop();

					}

				} else {
					wait.add(new Point(now.x, now.y));

				}
			} else {
				q.add(new Point(now.x, 0));
			}

		}
		while (!wait.isEmpty()) {

			q.add(new Point(wait.peek().x, 0));
			wait.pop();
		}
		StringBuilder sb = new StringBuilder();
		while (!q.isEmpty()) {
			sb.append(q.poll().y + " ");
		}

		bw.write(sb.toString() + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

}
