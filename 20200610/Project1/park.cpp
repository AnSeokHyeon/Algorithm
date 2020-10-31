// [모의 SW 역량테스트] 벌꿀채취.cpp : 이 파일에는 'main' 함수가 포함됩니다. 거기서 프로그램 실행이 시작되고 종료됩니다.
//

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int board[101];
int order[6];
vector<int> f;
vector<int> s;

int N, M, C, T, Tcnt = 1;
int max_f = 0;
int max_s = 0;
int result = 0;

void find() {
    int temp_f = 0;
    int temp_s = 0;

    for (int i = 0; i < M; i++) {
        if (order[i] == 1) {
            temp_f += f[i];
            temp_s += s[i];
        }
    }
    int max_sum1 = 0;

    if (temp_f <= C) {

        for (int j = 0; j < M; j++){
            if (order[j] == 1) {
                max_sum1 = max_sum1 + f[j] * f[j];
            }
        }
        if (max_sum1 > max_f) max_f = max_sum1;
    }

    int max_sum2 = 0;

    if (temp_s <= C) {

        for (int j = 0; j < M; j++) {
            if (order[j] == 1) {
                max_sum2 = max_sum2 + s[j] * s[j];
            }
        }
        if (max_sum2 > max_s) max_s = max_sum2;
    }

    int tempsum = max_s + max_f;
    if (tempsum > result) result = tempsum;
  
}


void dfs(int now, int depth) {
    if (now == depth) {
        find();
        return;
    }

    for (int i = 0; i < 2; i++) {
        order[now] = i;
        dfs(now + 1, depth);
    }
}

void simulate(int first, int second) {
    f.clear();
    s.clear();

    for (int i = first; i <= first + M - 1; i++) {
        f.push_back(board[i]);
    }
    for (int i = second; i <= second + M - 1; i++) {
        s.push_back(board[i]);
    }

    // C이하이면서 최대값인 조합 찾자
    dfs(0, M);
}

int main()
{
    cin >> T;

    while (T--) {
        cin >> N >> M >> C;

        for (int i = 1; i <= N * N; i++) {
            cin >> board[i];
        }
        result = 0;

        // 첫번째 꿀통의 시작 위치 i
        for (int i = 1; i <= N * N; i++) {
            if ((i - 1) % N > N - M)   continue;
            for (int j = i + M; j <= N * N; j++) {
                if ((j - 1) % N > N - M)   continue;
                max_f = 0;
                max_s = 0;
                simulate(i, j);
                cout << result << endl;
            }
        }
        cout << "#" << Tcnt << " " << result << endl;
        Tcnt++;
    }
}

