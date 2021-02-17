package algo6;

// 딸

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 딸기 {
	static int N;
	static int cake[][];

	static int result, sum;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		int Tcnt = 1;
		StringBuilder sb = new StringBuilder();
		
		while(T-- > 0) {
			N = Integer.parseInt(br.readLine());
			cake = new int[N][N];
			sum = 0;
			for(int i = 0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
 				
				for(int j = 0;j <N; j++) {
					cake[i][j] = Integer.parseInt(st.nextToken());
					sum += cake[i][j];
				}
			}
			result = 0;
			for(int i =1; i<N; i++) {
				for(int j =1; j<N;j++) {
					cut(i, j);
					if(result>0) break;
				}
				if(result>0) break;
			}
			sb.append("#" + (Tcnt++) + " " + result +"\n");
		}
		
		
		bw.write(sb.toString());
		bw.close();
		br.close();
	}

	static void cut(int n, int m) {
		int[][] cakeCut = new int[2][2];
		for (int x = 0; x < 2; x++) {
			for (int y = 0; y < 2; y++) {
				int xlen = Math.abs(N * x - n*(x-1));
				int ylen = Math.abs(N * y - m*(y-1));
				for (int i = n * x; i < xlen ; i++) {
					for (int j = m * y; j < ylen; j++) {
						cakeCut[x][y] += cake[i][j];
					}
				}
			}
		}
		boolean chk = true;
		int avg = sum / 4;
		for (int x = 0; x < 2; x++) {
			for (int y = 0; y < 2; y++) {
				if(cakeCut[x][y]!= avg) {
					chk = false;
					break;
				}
			}
			if(!chk) break;
		}
		if(chk) result = 1;

	}

}
