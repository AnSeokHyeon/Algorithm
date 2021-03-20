package algo10;

// 9372 상근이의 여행
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_9372 {
	static int p[];
	
	static int find(int n) {
		if(p[n] == n) return n;
		
		return p[n] = find(p[n]);
		
	}
	
	static boolean union(int a, int b) {
		int pa = find(a);
		int pb = find(b);
		
		if(pa == pb) return false;
		
		if(pa > pb) p[pa] =  pb;
		else p[pb] = pa;
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while(T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			p = new int[N+1];
			@SuppressWarnings("unchecked")
			ArrayList<Integer> arr[] = new ArrayList[N+1];

			for(int i = 0; i<N+1; i++) {
				p[i] = i;
				arr[i] = new ArrayList<>();
			}
			while(M-- > 0) {
				st = new StringTokenizer(br.readLine(), " ");
				
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				arr[a].add(b);
				arr[b].add(a);
			}
			
			Queue<Integer> q = new LinkedList<Integer>();
			q.add(1);
			
			int cnt = 0;
			while(!q.isEmpty()) {
				Integer now = q.poll();
				int size = arr[now].size();
				for(int k = 0; k<size; k++) {
					int next = arr[now].get(k);
					if(!union(now, next)) continue;
					cnt++;
					q.add(next);
				}
			}
			
			
			
			sb.append(cnt + "\n");
		}
		bw.write(sb.toString());
		br.close();
		bw.close();
	}

}