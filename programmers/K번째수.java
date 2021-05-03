import java.util.*;

class K번째수 {
    public int[] solution(int[] array, int[][] commands) {
        int testcase = commands.length;
        
        int[] answer = new int[testcase];
        
        for(int i = 0; i<testcase; i++){
            int start = commands[i][0]-1;
            int end = commands[i][1]-1;
            int idx = commands[i][2]-1;
            int arr[] = new int[end - start + 1];
            for(int j = start; j<=end; j++){
                arr[j - start] = array[j];
            }
            Arrays.sort(arr);
            answer[i] = arr[idx];
        }
        
        return answer;
    }
}