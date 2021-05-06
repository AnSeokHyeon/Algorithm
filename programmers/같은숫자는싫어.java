// 같은 숫자는 싫어
// https://programmers.co.kr/learn/courses/30/lessons/12906
import java.util.*;

public class 같은숫자는싫어 {
    public int[] solution(int []arr) {
		int size = arr.length;
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i<size; i++){
            if(i > 0 && arr[i-1] == arr[i]) continue;
            list.add(arr[i]);
        }
        int answer[] = new int[list.size()];
        for(int i = 0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}