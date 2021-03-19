package algo10;

// 1717 집합의 표현
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_1717 {
	
	static int parent[];
	
	static int findSet(int a){
		if(parent[a] == a) return a;
		return findSet(parent[a]);
	}
	
	static void unionSet(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if(aRoot == bRoot) return;
		if(aRoot > bRoot) parent[bRoot] = aRoot;
		else parent[aRoot] =bRoot;
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		parent = new int[N+1];
		for(int i = 0; i<N+1; i++) {
			parent[i] = i;
		}
		StringBuilder sb = new StringBuilder();
		while(M-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			int num = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(num == 0) {
				unionSet(a, b);
			}
			if(num == 1) {
				if(findSet(a) == findSet(b)) sb.append("YES\n");
				else sb.append("NO\n");
			}
		
			
		}
		bw.write(sb.toString());
		br.close();
		bw.close();
	}

}