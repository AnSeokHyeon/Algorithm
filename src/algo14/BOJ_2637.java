package algo14;

// 2637 장난감조립
import java.awt.Point;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2637 {
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		@SuppressWarnings("unchecked")
		ArrayList<Point> arr[] = new ArrayList[N+1];
		int total[] = new int[N+1];
		int line[] = new int[N+1];
		for(int i = 1; i<N+1; i++) {
			arr[i] = new ArrayList<>();
		}
		
		Queue<Point> q = new LinkedList<>();
		
		while(M-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			arr[a].add(new Point(b, k));
			line[b] += k;
		}
		
		q.add(new Point(N, 1));
		total[N] = 1;
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			int now = p.x;
			int k = p.y;
			int size = arr[now].size();
			for(int i = 0; i<size; i++) {
				int next = arr[now].get(i).x;
				int nextk = arr[now].get(i).y;
				total[next] += nextk * k;
				line[next] -=nextk;
				if(line[next] == 0) {
					q.add(new Point(next, total[next]));
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i<N; i++) {
			if(arr[i].size() > 0) continue;
			sb.append((i) + " " + total[i] + "\n");
			
		}
		bw.write(sb.toString());
		br.close();
		bw.close();
	}

}