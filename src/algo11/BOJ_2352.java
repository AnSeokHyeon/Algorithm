package algo11;

// 2352 반도체 설계

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2352 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int num[] = new int[N];
		int c[] = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				 
		for(int i = 0; i<N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		int size = 0;
		for(int i = 0; i<N; i++) {
			int point = Arrays.binarySearch(c, 0, size, num[i]);
			
			point = Math.abs(point) -1;
			
			c[point] = num[i];
			
			if(point == size) size++;
			
		}
		bw.write(size + "");
		bw.close();
		br.close();
	}

}