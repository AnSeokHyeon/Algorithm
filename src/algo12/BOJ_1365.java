package algo12;

// 1365 꼬인 전깃줄

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1365 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int num[] = new int[N+1];
		int line[] = new int[N+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 1; i<N+1; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		int size = 0;
		for(int i = 1; i<N+1; i++) {
			int point = Arrays.binarySearch(line, 0, size, num[i]);
			point = Math.abs(point)-1;
			line[point] = num[i];
			
			if(size == point) size++;
			
		}
		bw.write((N-size)+"");
		bw.close();
		br.close();

	}
}