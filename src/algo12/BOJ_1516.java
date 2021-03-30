package algo12;

// 1516 게임 개발

import java.awt.Point;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1516 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int num[] = new int[N+1];
		int time[] = new int[N+1];
		int total[] = new int[N+1];
		@SuppressWarnings("unchecked")
		ArrayList<Integer> arr[] = new ArrayList[N+1];
		for(int i = 0; i<N+1; i++) {
			arr[i] = new ArrayList<>();
		}
		
		PriorityQueue<Point> q = new PriorityQueue<Point>(new Comparator<Point>() {

			@Override
			public int compare(Point o1, Point o2) {
				// TODO Auto-generated method stub
				return o1.y - o2.y;
			}
		});
		
		for(int i = 1; i<=N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			int t = Integer.parseInt(st.nextToken());
			time[i] = t;
			while(true) {

				int n = Integer.parseInt(st.nextToken());
				
				if(n == -1) {
					break;
				}
				num[i]++;
				arr[n].add(i);
			}
		}
		for(int i = 1; i<N+1; i++) {
			if(num[i] > 0) continue;
			
			q.add(new Point(i, time[i]));
			total[i] = time[i];
			
		}
		StringBuilder sb = new StringBuilder();
		while(!q.isEmpty()) {
			Point p = q.poll();
			int now = p.x;
			int nowT = p.y;
			int size = arr[now].size();
			
			for(int i = 0; i<size; i++) {
				int next = arr[now].get(i);
				num[next]--;
				if(num[next] == 0) {
					total[next] = nowT + time[next];
					q.add(new Point(next, total[next]));
				}
				
			}
		}
		for(int i = 1; i<N+1; i++) {
			sb.append(total[i] + "\n");
		}
		
		bw.write(sb.toString());
		bw.close();
		br.close();

	}
}