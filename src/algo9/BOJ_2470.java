package algo9;

// 2470 두 용액
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2470 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		int left = 0;
		int right = N-1;
		int result = Integer.MAX_VALUE;
		int A = 0;
		int B = 0;
		while(left < right) {
			int gap = arr[left] + arr[right];
			int sum = Math.abs(gap);
			if(result > sum) {
				A = arr[left];
				B = arr[right];
				result = sum;
			}
			if(gap >=0) {
				right--;
			}
			else {
				left++;
			}
		}
		
		
		bw.write(A + " " + B + "");
		br.close();
		bw.close();
	}

}