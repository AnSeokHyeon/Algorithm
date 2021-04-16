package algo14;

// 17471 게리맨더링
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

public class BOJ_17471 {
	static int N;
	static int population[];
	static int section[];
	static boolean chk[];
	static ArrayList<Integer> arr[];
	static int limit = 0;
	static int result = Integer.MAX_VALUE;
	static Queue<Integer> q;
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		population = new int[N+1];
		arr = new ArrayList[N+1];
		chk = new boolean[N+1];
		section = new int[N+1];
		q = new LinkedList<Integer>();
		limit = (int) (Math.pow(2, N)-1);
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 1; i<N+1; i++) {
			population[i] = Integer.parseInt(st.nextToken());
			arr[i] = new ArrayList<>();
		}
		
		for(int i = 1; i<N+1; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int m = Integer.parseInt(st.nextToken());
			while(m-- > 0) {
				int temp = Integer.parseInt(st.nextToken());
				arr[i].add(temp);
			}
		}
		
		dfs(0,0);
		if(result == Integer.MAX_VALUE) result = -1;
		bw.write(result + "");
		br.close();
		bw.close();
	}
	
	private static void dfs(int n,int flag) {
		if(n == N) {
			if(flag != 0 && flag != limit ) {
				bfs(flag);
			}
			return;
		}
		dfs(n+1, flag);

		dfs(n+1, flag | 1 <<   (n));
		
		
	}

	private static void bfs(int flag) {
		Arrays.fill(section, 0);
		Arrays.fill(chk, false);
		q.clear();
		
		int section1 = -1;
		int section2 = -1;
		
		int p1 = 0;
		int p2 = 0;
		
		for (int i = 0; i < N; i++) {
			if ((flag & 1 << i) > 0) {
				section[i + 1] = 1;
				section1++;
				if(section1 == 0) {
					q.add(i+1);
					chk[i+1] = true;
				}
			} else {
				section[i + 1] = 2;
				section2++;
				if(section2 == 0) {
					q.add(i + 1);
					chk[i+1] = true;
				}
			}
		}
		
		while(!q.isEmpty()) {
			Integer i = q.poll();
			int size = arr[i].size();
			if(section[i] == 1) {
				p1 += population[i];
			}
			else {
				p2 += population[i];
			}
			
			for(int k = 0; k<size; k++) {
				int next = arr[i].get(k);
				if(section[i] != section[next]) continue;
				if(chk[next]) continue;
				
				if(section[i] == 1) {
					section1--;
				}
				else {
					section2--;
				}
				chk[next] = true;
				q.add(next);
			}
			
		}
		if(section1 ==0 && section2 == 0) {
			result = Math.min(result, Math.abs(p1 - p2));
		}
	}
	
	
}