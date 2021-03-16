package algo10;

// 9370 미확인 도착지
import java.awt.Point;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_9370 {
	static class Inf{
		int next;
		int nextWeight;
		int flag;
		public Inf(int next, int nextWeight, int flag) {
			super();
			this.next = next;
			this.nextWeight = nextWeight;
			this.flag = flag;
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while(T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine(), " ");

			int s = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			
			int min[][] = new int[n+1][4];
			boolean chk[] = new boolean[n+1];
			@SuppressWarnings("unchecked")
			ArrayList<Point> arr[] = new ArrayList[n+1];
			for(int i = 0; i<n+1; i++) {
				Arrays.fill(min[i], Integer.MAX_VALUE);
				arr[i] = new ArrayList<>();
			}
			
			while(m-- > 0) {

				st = new StringTokenizer(br.readLine(), " ");

				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int w = Integer.parseInt(st.nextToken());
				arr[x].add(new Point(y, w));
				arr[y].add(new Point(x, w));
			}
			
			for(int i = 0; i<t; i++) {
				chk[Integer.parseInt(br.readLine())] = true;
			}
			
			PriorityQueue<Inf> q = new PriorityQueue<>(new Comparator<Inf>() {

				@Override
				public int compare(Inf o1, Inf o2) {
					// TODO Auto-generated method stub
					return o1.nextWeight - o2.nextWeight;
				}
			});
			
			int startFlag = 0;
			if(s == g) startFlag = startFlag|(1<<0);
			if(s == h) startFlag = startFlag|(1<<1); 
			q.add(new Inf(s, 0, startFlag));
			min[s][startFlag] = 0;
			while(!q.isEmpty()) {
				Inf i = q.poll();
				
				int now = i.next;
				int nowW = i.nextWeight;
				int flag = i.flag;
				int size = arr[now].size();
				for(int k = 0; k <size; k++) {
					int next = arr[now].get(k).x;
					int nextW = arr[now].get(k).y;
					int nextflag = flag;
					if(next == g) nextflag = nextflag|(1<<0);
					if(next == h) nextflag = nextflag|(1<<1); 
					if(nowW + nextW >= min[next][nextflag]) continue;
					min[next][nextflag] = nowW + nextW;
					q.add(new Inf(next, nowW + nextW , nextflag));
					
				}
				
			}
			
			ArrayList<Integer> result = new ArrayList<>();
			
			for(int i = 1; i<n+1; i++) {
				if(!chk[i] || min[i][3] == Integer.MAX_VALUE) continue;
				if(min[i][3] > min[i][0] ||min[i][3] > min[i][1] ||min[i][3] > min[i][2]) continue;
				result.add(i);
			}
			
			Collections.sort(result);
			for(int i = 0, size = result.size(); i<size; i++) {
				sb.append(result.get(i)+ " ");
		
			}
			sb.append("\n");
			
		}
		
		bw.write(sb.toString());
		br.close();
		bw.close();
	}

}