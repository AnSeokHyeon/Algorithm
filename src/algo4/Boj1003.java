// 피보나치함수
package algo4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Boj1003 {
	static int[] one;
	static int[] zero;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		zero = new int[100];
		one = new int[100];
		zero[0] = 1;
		one[0] = 0;
		zero[1] =0;
		one[1] = 1;
		zero[2] = 1;
		one[2] = 2;
		for(int i = 2; i<100; i++) {
			zero[i] = one[i-1];
			one[i] = zero[i] +zero[i-1];
   			
		}
		while(N-- > 0) {
			int num = Integer.parseInt(br.readLine());
			sb.append(zero[num] + " " + one[num]+"\n");

						
		}
		bw.write(sb.toString());
		bw.close();
		br.close();
	}

}
