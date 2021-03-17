package algo10;

// 11657 타임머신
import java.awt.Point;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11657 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		long dist[] = new long[N + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		@SuppressWarnings("unchecked")
		ArrayList<Point> arr[] = new ArrayList[N + 1];
		for (int i = 1; i < N + 1; i++) {
			arr[i] = new ArrayList<>();
		}

		while (M-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			arr[x].add(new Point(y, w));

		}
		dist[1] = 0;
		boolean negativeCycle = false;
		for (int i = 1; i < N + 1; i++) {
			negativeCycle = false;
			for(int j = 1; j<N+1; j++) {

				for (int k = 0, size = arr[j].size(); k < size; k++) {

					long nowW = dist[j];
					long next = dist[arr[j].get(k).x];
					long nextW = arr[j].get(k).y;
					if (nowW == Integer.MAX_VALUE)
						break;
					
					if ((nowW + nextW) >= next)
						continue;
					dist[arr[j].get(k).x] = dist[j] + arr[j].get(k).y;
					negativeCycle = true;
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		if (negativeCycle) {
			sb.append("-1\n");

		} else {
			for (int i = 2; i < N + 1; i++) {
				if (dist[i] == Integer.MAX_VALUE)
					dist[i] = -1;
				sb.append(dist[i] + "\n");
			}
		}
		bw.write(sb.toString());
		br.close();
		bw.close();
	}

}