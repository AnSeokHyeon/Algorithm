package algo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Boj7568 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int[] w = new int[51];
		int[] h = new int[51];
		int N = Integer.parseInt(br.readLine());
		for(int i = 0; i<N;i++) {
			String[] s = br.readLine().split(" ");
			w[i] = Integer.parseInt(s[0]);
			h[i] = Integer.parseInt(s[1]);
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i<N;i++) {
			int rank = 1;
			for(int j = 0; j<N;j++) {
				
				if(i == j) continue;
				if(w[j] > w[i] && h[j] > h[i]) {
					rank++;
				}
			}
			sb.append(rank).append(" ");
		}
		bw.write(sb.toString());
		bw.close();
	}
}
