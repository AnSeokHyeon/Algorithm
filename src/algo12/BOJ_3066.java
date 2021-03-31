package algo12;

// 3066 브리징 시그널

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class BOJ_3066 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while(T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			
			int num[] = new int[N+1];
			int lis[]= new int[N+1];
			
			for(int i = 1; i<=N; i++) {
				num[i] = Integer.parseInt(br.readLine());
			}
			
			int size = 0;
			for(int i = 1; i<=N; i++) {
				int point  = Arrays.binarySearch(lis, 0, size, num[i]);
				
				point = Math.abs(point) -1;
				
				lis[point] = num[i];
				
				if(point == size) size++;
				
				
			}
			
			
			sb.append(size+"\n");
			
		}
		
		bw.write(sb.toString());
		bw.close();
		br.close();
		
	}
}