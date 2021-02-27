package algo7;

// 2635 수 이어가기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class BOJ_2635 {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		ArrayList<Integer> arr = new ArrayList<>();
		ArrayList<Integer> result = new ArrayList<>();
		for(int i = N; i>0; i--) {
			
			arr.clear();
			arr.add(N);
			arr.add(i);
			int idx = 2;
			while(true) {
				int num = arr.get(idx-2) - arr.get(idx-1);
				if(num < 0) break;
				idx++;
				arr.add(num);
			}
			
			if(arr.size() > result.size()) {
				result = (ArrayList<Integer>) arr.clone();
			}
		}
		StringBuilder sb = new StringBuilder();
		sb.append(result.size()+"\n");
		for(int i = 0; i<result.size(); i++) {
			sb.append(result.get(i) + " ");
		}
		bw.write(sb.toString());
		br.close();
		bw.close();

	}
}