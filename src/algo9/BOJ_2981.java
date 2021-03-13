package algo9;
// 2981 검문
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class BOJ_2981 {
	static int GCD(int a, int b) {
		if(a%b == 0) {
			return b;
			
		}
		return GCD(b, a%b);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int num[] = new int[N];
		HashSet<Integer> arr = new HashSet<>();
		for(int i = 0; i<N; i++) {
			num[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(num);
		
		int gcd = num[1]-num[0];
		
		for(int i = 2; i<N; i++) {
			gcd = GCD(gcd, num[i] - num[i-1]);
		}
		arr.add(gcd);
		for(int i = 2; i*i <= gcd; i++) {
			if(gcd%i ==0 ) {
				arr.add(i);
				arr.add(gcd/i);
			}
		}
		ArrayList<Integer> arr2 = new ArrayList<>(arr);
		Collections.sort(arr2);
		int size = arr2.size();
		StringBuilder sb = new StringBuilder();
		for(int i = 0;i <  size; i++ ) {
			sb.append(arr2.get(i)+ " ");
		}
		bw.write(sb.toString());
		br.close();
		bw.close();
	}

}