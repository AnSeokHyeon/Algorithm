package algo9;

// 13911 집 구하기
import java.awt.Point;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_13911 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int MC[] = new int[N + 1];
		int SB[] = new int[N + 1];
		Arrays.fill(MC, Integer.MAX_VALUE);
		Arrays.fill(SB, Integer.MAX_VALUE);
		@SuppressWarnings("unchecked")
		ArrayList<Point> arr[] = new ArrayList[N + 1];
		for (int i = 0; i < N + 1; i++) {
			arr[i] = new ArrayList<>();
		}

		// 간선 입력
		while (M-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			arr[x].add(new Point(y, w));
			arr[y].add(new Point(x, w));
		}

		int X = 0, Y = 0;
		PriorityQueue<Point> mcq = new PriorityQueue<>(new Comparator<Point>() {

			@Override
			public int compare(Point o1, Point o2) {
				// TODO Auto-generated method stub
				return o1.y - o2.y;
			}
		});
		PriorityQueue<Point> sbq = new PriorityQueue<>(new Comparator<Point>() {

			@Override
			public int compare(Point o1, Point o2) {
				// TODO Auto-generated method stub
				return o1.y - o2.y;
			}
		});
		// 맥세권 입력
		st = new StringTokenizer(br.readLine(), " ");
		int McN = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");
		while (McN-- > 0) {
			int temp = Integer.parseInt(st.nextToken());
			MC[temp] = 0;
			mcq.add(new Point(temp, 0));
		}

		// 스세권 입력
		st = new StringTokenizer(br.readLine(), " ");
		int SN = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");
		while (SN-- > 0) {
			int temp = Integer.parseInt(st.nextToken());
			SB[temp] = 0;
			sbq.add(new Point(temp, 0));
		}
		
		while (!mcq.isEmpty()) {
			Point p = mcq.poll();

			int now = p.x;
			int nowW = p.y;

			int size = arr[now].size();
			for (int k = 0; k < size; k++) {
				int next = arr[now].get(k).x;
				int nextW = arr[now].get(k).y;

				if (nowW + nextW >= MC[next])
					continue;
				MC[next] = nowW + nextW;
				mcq.add(new Point(next, nowW + nextW));
			}
		}

		while (!sbq.isEmpty()) {
			Point p = sbq.poll();

			int now = p.x;
			int nowW = p.y;

			int size = arr[now].size();
			for (int k = 0; k < size; k++) {
				int next = arr[now].get(k).x;
				int nextW = arr[now].get(k).y;

				if (nowW + nextW >= SB[next])
					continue;
				SB[next] = nowW + nextW;
				sbq.add(new Point(next, nowW + nextW));
			}
		}

		int result = Integer.MAX_VALUE;
		for (int i = 1; i < N + 1; i++) {
			if (MC[i] == 0 || SB[i] == 0)
				continue;
			if (MC[i] > X || SB[i] > Y)
				continue;

			int sum = MC[i] + SB[i];
			result = Math.min(result, sum);

		}

		if (result == Integer.MAX_VALUE)
			bw.write("-1");
		else
			bw.write(result + "");
		br.close();
		bw.close();
	}

}