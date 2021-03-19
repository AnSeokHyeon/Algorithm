package algo10;

// 20040번 - 사이클 게임
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_20040 {
	
	static int parent[];
	
	static int findSet(int a){
		if(parent[a] == a) return a;
		return parent[a] =findSet(parent[a]);
	}
	
	static boolean unionSet(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if(aRoot == bRoot) return false;
		if(aRoot > bRoot) parent[bRoot] = aRoot;
		else parent[aRoot] =bRoot;
		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		parent = new int[N+1];
		for(int i = 0; i<N+1; i++)
		{
			parent[i] = i;
		}
		int result = 0;
		int cnt  = 1;
		while(cnt <=M) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(!unionSet(a, b) && result ==0) {
				result = cnt;
			}
			cnt++;
		}
		bw.write(result+"");
		br.close();
		bw.close();
	}

}