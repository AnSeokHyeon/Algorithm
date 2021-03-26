package algo11;

//가장 긴 증가하는 부분 수열3 12738

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_12738 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int num[] = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i= 0;  i<N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		int c[] = new int[N];
		int size = 0;
		
		for(int i= 0; i<N; i++) {
			
			int point = Arrays.binarySearch(c, 0, size, num[i]);
			if(point >= 0) continue;
			
			point = Math.abs(point)-1;
			c[point] = num[i];
			
			if(point == size) size++;
		}
		bw.write(size + "");
		br.close();
		bw.close();
	}
}