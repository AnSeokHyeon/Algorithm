package algo16;
import java.awt.Point;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_6118 {
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int step[] = new int[N+1];
		Arrays.fill(step, Integer.MAX_VALUE);
		
		@SuppressWarnings("unchecked")
		ArrayList<Integer> graph[] = new ArrayList[N+1];
		for(int i = 1; i<N+1; i++) {
			graph[i] = new ArrayList<>();
		}
		
		while(K-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a].add(b);
			graph[b].add(a);
		}
		
		Queue<Point> q = new LinkedList<>();
		
		int start = 1;
		q.add(new Point(start, 0));
		step[start] = 0;
		int max = 0;
		
		while(q.size() > 0) {
			Point p = q.poll();
			
			int n = p.x;
			int d = p.y;
			max = (d > max)? d:max;
			int size = graph[n].size();
			for(int k = 0; k<size; k++) {
				
				int next = graph[n].get(k);
				int nextd = d + 1;
				if(step[next] != Integer.MAX_VALUE) continue;
				step[next] = nextd;
				q.add(new Point(next, nextd));
				
			}
		}
		int min = Integer.MAX_VALUE;
		int cnt = 0;
		for(int i = 1; i<N+1; i++) {
			if(step[i] != max) continue;
			cnt++;
			min = Math.min(min, i);
		}
		System.out.println(min + " "+ max + " " + cnt);
		br.close();
		bw.close();
	}
}