package algo11;

// 10282 해킹
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

public class BOJ_10282 {
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();
		int T= Integer.parseInt(br.readLine());
		
		while(T-- > 0){
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			
			int min[] = new int[N+1];
			Arrays.fill(min, Integer.MAX_VALUE);
			@SuppressWarnings("unchecked")
			ArrayList<Point> arr[] = new ArrayList[N+1];
			for(int i= 1; i<N+1; i++) {
				arr[i] = new ArrayList<>();
			}
			
			while(d-- > 0) {
				st = new StringTokenizer(br.readLine(), " ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int t = Integer.parseInt(st.nextToken());
				arr[b].add(new Point(a, t));
			}
			
			PriorityQueue<Point> q = new PriorityQueue<>(new Comparator<Point>() {

				@Override
				public int compare(Point o1, Point o2) {
					// TODO Auto-generated method stub
					return o1.y - o2.y;
				}
			});
			
			q.add(new Point(s, 0));
			min[s] = 0;
			int result = 0;
			int time = 0;
			
			while(!q.isEmpty()) {
				
				Point p = q.poll();
				
				int now = p.x;
				int w = p.y;
				int size = arr[now].size();
				
				for(int i= 0; i<size; i++) {
					int next = arr[now].get(i).x;
					int nextW = arr[now].get(i).y + w;
					
					if(nextW >= min[next]) continue;
					min[next] = nextW;
					q.add(new Point(next, nextW));
					
				} // for 문 종료
			} // queue 종료 
			
			for(int i = 1; i<N+1; i++) {
				if(min[i] == Integer.MAX_VALUE) continue;
				time = Math.max(time, min[i]);
				result++;
			}
			
			sb.append(result + " " + time + "\n");
			
		}
		bw.write(sb.toString());
		br.close();
		bw.close();

	}


}
