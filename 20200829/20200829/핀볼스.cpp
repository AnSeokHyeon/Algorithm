// [모의 SW 역량테스트] 보호 필름.cpp : 이 파일에는 'main' 함수가 포함됩니다. 거기서 프로그램 실행이 시작되고 종료됩니다.
//

#include <iostream>
#include <algorithm>
#include <vector>
#include <memory.h>
using namespace std;

int board[14][21];
int order[14];
bool finish[21] = {};
int D, W, K, T, Tcnt = 1, t_ans = false, ans = 987654321;

void Init() {
    memset(board, 0, sizeof(board));
    memset(order, -1, sizeof(order));
    memset(finish, false, sizeof(finish));
    t_ans = false;
    ans = 987654321;
}

// 완료시 true 반환해준다
bool simulate(int  brd[][21]) {
    memset(finish, false, sizeof(finish));

    for (int i = 1; i <= W; i++) {
        for (int j = 1; j <= D; j++) {
            int cnt = 0;
            for (int k = j; k <= j + K; k++) {
                if (k > W)
                    break;
                if (brd[j][i] == brd[k][i]) {
                    cnt++;
                }
            }
            if (cnt == K)
                finish[i] = true;
        }
    }

    bool ret = true;

    for (int i = 1; i <= W; i++) {
        //cout << finish[i] << " ";
        if (finish[i] == false)
            ret = false;
    }
    return ret;
}

bool paint() {
    int tmap[14][21];
    memcpy(tmap, board, sizeof(board));

    for (int i = 1; i <= D; i++) {
        if (order[i] == -1) {
            continue;
        }

        for (int j = 1; j <= W; j++) {
            tmap[i][j] = order[i];
        }
    }



    bool result = simulate(tmap);
    if (simulate(tmap)) {
        for (int i = 1; i <= D; i++) {
            for (int j = 1; j <= W; j++) {
                cout << tmap[i][j];
            }
            cout << endl;
        }
        cout << endl;
    }

    return result;
}

void dfs(int now, int depth) {
    if (now == depth + 1) {
        if (paint())
            t_ans = true;
        return;
    }

    for (int i = 1; i <= D; i++) {
        for (int j = 0; j < 2; j++) {
            order[i] = j;
            dfs(now + 1, depth);
            order[i] = -1;
        }
    }
}


int main()
{
    cin >> T;


    while (T--) {
        Init();

        cin >> D >> W >> K;

        for (int i = 1; i <= D; i++) {
            for (int j = 1; j <= W; j++) {
                cin >> board[i][j];
            }
        }

        if (simulate(board)) {
            ans = 0;
        }

        else {
            for (int depth = 1; depth <= K; depth++) {
                memset(order, -1, sizeof(order));
                dfs(1, depth);
                if (t_ans) {
                    ans = min(ans, depth);
                    break;
                }
            }
        }
        cout << "#" << Tcnt++ << " " << ans << endl;
    }
}