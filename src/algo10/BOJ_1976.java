package algo10;

//1976	 여행 가자
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_1976 {
	
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
		
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		parent = new int[N+1];
		int trip[] = new int[M];
		
		for(int i = 0; i<N+1; i++) {
			parent[i] = i;
		}
		StringTokenizer st ;
		int board[][] = new int[N+1][N+1];
		for(int i = 1; i<N+1; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 1; j<N+1; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine(), " ");

		for(int i= 0; i<M; i++) {
			trip[i] = Integer.parseInt(st.nextToken());
		}
		for(int i = 1; i<N+1; i++) {
			for(int j = i+1; j<N+1; j++) {
				if(board[i][j] == 0) continue;
				unionSet(i, j);
			}
		}
		int result = 0;
		boolean chk = true;
		for(int i= 0; i<M; i++) {
			if ( result == 0) result = findSet(trip[i]);
			else {
				if(result != findSet(trip[i])) {
					chk = false;
					break;
					
				}
			}
		}
		if(chk) bw.write("YES");
		else bw.write("NO");
		br.close();
		bw.close();
	}

}