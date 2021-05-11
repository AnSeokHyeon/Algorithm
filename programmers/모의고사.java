class 모의고사 {
    public int[] solution(int[] answers) {
        
        int size = answers.length;
        int a = 0;
        int b = 0;
        int c = 0;
        int mathA[] = new int[size];
        for(int i = 0; i<size; i++){
            mathA[i] = i%5 +1;
        }
        int mathB[] = new int[size];
        for(int i = 0; i<size; i++){
            if(i%2 == 0){
                mathB[i] = 2;
            }
            else if(i%8 == 1){
                mathB[i] = 1;
                
            }else if(i%8 == 3){
                mathB[i] = 3;
                
            }else if(i%8 == 5){
                mathB[i] = 4;
                
            }else if(i%8 == 7){
                mathB[i] = 5;
            }
        }
        int mathC[] = new int[size];
        for(int i = 0; i<size; i++){
            if(i%10 < 2){
                mathC[i] = 3;
            }else if(i%10 < 4){
                mathC[i] = 1;
                
            }else if(i%10 < 6){
                mathC[i] = 2;
                
            }else if(i%10 < 8){
                mathC[i] = 4;
                
            }else if(i%10 < 10){
                mathC[i] = 5;
                
            }
        }
        int max = 0;
        int cnt = 0;
        for(int i = 0; i<size; i++){
            if(answers[i] == mathA[i]){
                a++;
            }
            if(answers[i] == mathB[i]){
                b++;
            }
            if(answers[i] == mathC[i]){
                c++;
            }
            max = Math.max(a, Math.max(b, c));
        }
        if(max == a) cnt++;
        if(max == b) cnt++;
        if(max == c) cnt++;
        
        int[] answer = new int[cnt];
        int idx = 0;
        if(max == a) answer[idx++] = 1;
        if(max == b) answer[idx++] = 2;
        if(max == c) answer[idx++] = 3;
        return answer;
    }
}