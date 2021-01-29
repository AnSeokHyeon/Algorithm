package algo2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Boj10989 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		int[] count = new int[10001];
		
		for(int i = 0; i<n;i++) {
			count[Integer.parseInt(br.readLine())]++;
		}	

		StringBuilder sb = new StringBuilder();
		for(int i = 1; i<10001;i++) {
			while(count[i] > 0)
			{
				sb.append(i).append('\n');
				count[i]--;
			}
		}
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
}
