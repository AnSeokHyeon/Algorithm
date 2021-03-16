package algo10;

// 1956 운동
// 플로이드 와샬 알고리즘 
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1956 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int INF = Integer.MAX_VALUE/2;

		int arr[][] = new int[V+1][V+1];
		for(int i= 0; i<V+1; i++) {
			Arrays.fill(arr[i], INF);
		}
		
		while(E-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			arr[x][y] = w;
		}
		
		for(int k = 1; k<V+1; k++) {
			for(int i = 1; i<V+1; i++) {
				for(int j = 1; j<V+1; j++) {
					if(arr[i][j] > arr[i][k] + arr[k][j]) {
						arr[i][j] = arr[i][k] + arr[k][j];
					}
				}
				
			}	
		}
		int result = INF;
		for(int i = 1; i<V+1;i++) {
			result = Math.min(arr[i][i], result);
		}
		if(result == INF) result = -1;
		bw.write(result+"");
		br.close();
		bw.close();
	}

}