package algo10;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_3289_서로소집합 {
	static int N;
	static int parents[];
	static void make() {
		for(int i = 0; i<N+1; i++) {
			parents[i] = i;
		}
	}
	
	
	static int findSet(int a) {
		if(parents[a] == a) return a;
		return parents[a] = findSet(parents[a]);
	}
	
	static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if(aRoot == bRoot) return false;
		
		parents[bRoot] = aRoot;
		return true;
	}
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		int Tcnt = 1;
		StringBuilder sb = new StringBuilder();
		while(T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			N = Integer.parseInt(st.nextToken());
			parents = new int[N+1];
			make();
			int M = Integer.parseInt(st.nextToken());
			String S = "";
			
			while(M-- > 0) {
				st = new StringTokenizer(br.readLine(), " ");
				
				int num = Integer.parseInt(st.nextToken());
				int a= Integer.parseInt(st.nextToken());
				int b= Integer.parseInt(st.nextToken());
				
				if(num == 0) {
					union(a, b);
				}
				
				if(num == 1) {
					if(findSet(a) == findSet(b)) S += "1";
					else S+="0";
				}
				
				
				
			}
			
			
			
			sb.append("#" + (Tcnt++) + " "+ S + "\n");
			
		}
		bw.write(sb.toString());
		bw.close();
		br.close();
		
	}
}
