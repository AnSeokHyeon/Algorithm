package algo11;

// 1005 ACM craft
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

public class BOJ_1005 {
	

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		int time[];
		int chk[];
		int min[];
		int N = 0, K = 0;
		int X = 0, Y = 0;
		int M = 0;
		StringTokenizer st = null;
		ArrayList<Integer> arr[];
		

		PriorityQueue<Point> q = new PriorityQueue<>(new Comparator<Point>() {

			@Override
			public int compare(Point o1, Point o2) {
				// TODO Auto-generated method stub
				return o1.y - o2.y;
			}
		});
		
		int T = Integer.parseInt(br.readLine());
		while(T-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			time = new int[N+1];
			chk = new int[N+1];
			min = new int[N+1];
			arr = new ArrayList[N+1];
			q.clear();

			st = new StringTokenizer(br.readLine(), " ");
			for(int i = 1; i<N+1; i++) {
				time[i] = Integer.parseInt(st.nextToken());
				arr[i] = new ArrayList<>();
			}
			
			while(K-- > 0) {
				st = new StringTokenizer(br.readLine(), " ");
				X = Integer.parseInt(st.nextToken());
				Y = Integer.parseInt(st.nextToken());
				arr[X].add(Y);
				chk[Y]++;
			}
			
			M = Integer.parseInt(br.readLine());
			
			for(int i = 1; i<N+1; i++) {
				if(chk[i] > 0) continue;
				q.add(new Point(i, time[i]));
				min[i] = time[i];
			}
			
			while(!q.isEmpty()) {
				Point p = q.poll();
				
				int now = p.x;
				int nowTime = p.y;
				int size = arr[now].size();
				
				if(now == M) {
					break;
				}
				
				for(int i = 0; i<size; i++) {
					int next = arr[now].get(i);
					int nextTime = nowTime + time[next];
					chk[next]--;
					
					if(chk[next] == 0) {
						min[next] = nextTime;
						q.add(new Point(next, nextTime));
					}
					
				}
			}
			
			
			sb.append(min[M] + "\n");
			
		}
		bw.write(sb.toString());
		bw.close();
		br.close();
	}

}