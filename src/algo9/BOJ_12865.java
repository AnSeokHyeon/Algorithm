package algo9;

// 12865 평범한 배낭
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_12865 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 출력을 위해 bw 객체 생성

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int w[] = new int[N+1];
        int v[] = new int[N+1];
        int max[][] = new int[N+1][W+1];
        
        for(int i = 1; i<=N; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	w[i] = Integer.parseInt(st.nextToken());
        	v[i] = Integer.parseInt(st.nextToken());
        }
        
        
        for(int i=1; i<=N; i++) {
            for(int j=1; j<=W; j++){
            	max[i][j] = max[i-1][j];
                if(j-w[i]>=0){
                //j값은 배열을 채워나가며 무게
                	max[i][j] = Math.max(max[i-1][j],max[i-1][j-w[i]]+v[i]);
                    // 기존 값과 value를 더한 새로운 값 중 큰 것을 dp배열에 넣기
                }
            }
        }
        bw.write(max[N][W] + "");
        bw.close();
        br.close();
    }
}