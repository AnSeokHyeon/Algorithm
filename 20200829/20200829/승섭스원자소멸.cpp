// [모의 SW 역량테스트] 보호 필름.cpp : 이 파일에는 'main' 함수가 포함됩니다. 거기서 프로그램 실행이 시작되고 종료됩니다.
//

#include <iostream>
#include <algorithm>
#include <vector>
#include <memory.h>
using namespace std;

int board[14][21];
int order[14];
bool check[14];
bool finish[21] = {};
int D, W, K, T, Tcnt = 1, t_ans = false, ans = 987654321;

void Init() {
    memset(board, 0, sizeof(board));
    memset(order, -1, sizeof(order));
    t_ans = false;
    ans = 987654321;
}

// 완료시 true 반환해준다
bool simulate(int brd[][21]) {
    memset(finish, false, sizeof(finish));
    bool go = true;

    for (int i = 1; i <= W; i++) {
        for (int j = 1; j <= D - K + 1; j++) {
            int c = 0;
            for (int m = j; m < j + K; m++) {
                if (brd[j][i] == brd[m][i]) {
                    c += 1;
                }
            }
            if (c == K) {
                finish[i] = true;
                go = true;
                break;
            }
            go = false;
        }
        if (go == false)
            return false;
    }

    //cout << " 색칠 공부 " << endl;
    //for (int i = 1; i <= D; i++) {
    //    for (int j = 1; j <= W; j++) {
    //        cout << brd[i][j] << " ";
    //    }
    //    cout << endl;
    //}

    for (int i = 1; i <= W; i++) {
        if (finish[i] == false)
            return false;
    }
    return true;
}

bool paint() {
    int tmap[14][21];
    memcpy(tmap, board, sizeof(board));
    for (int i = 1; i <= D; i++) {
        if (order[i] == -1) {
            continue;
        }
       //cout << i << " ,  " << order[i] << " / ";
        for (int j = 1; j <= W; j++) {
            tmap[i][j] = order[i];
        }
    }
    //cout << endl;
    bool result = simulate(tmap);
    return result;
}

void dfs(int now, int starting, int depth) {
    if (t_ans == true)
        return;
    if (now > depth) {
        if (paint())
            t_ans = true;
        return;
    }


    for (int i = starting; i <= D; i++) {
        if (check[i] == true)
            continue;
        for (int j = 0; j < 2; j++) {
            order[i] = j;
            check[i] = true;
            dfs(now + 1, i+1, depth);
            order[i] = -1;
            check[i] = false;
        }
    }
}


int main()
{
    cin >> T;

    while (T--) {
        Init();

        cin >> D >> W >> K;
        //if (Tcnt > 2) cout << D << " " << W << " " << K <<endl;

        for (int i = 1; i <= D; i++) {
            for (int j = 1; j <= W; j++) {
                cin >> board[i][j];
                //if (Tcnt > 2) cout << board[i][j] << " ";
            }
            //if (Tcnt > 2) cout << endl;
        }

        if (simulate(board)) {
            ans = 0;
        }

        else {
            for (int depth = 1; depth <= K; depth++) {
                dfs(1, 1, depth);
                if (t_ans) {
                    ans = min(ans, depth);
                    break;
                }
            }
        }

        cout << "#" << Tcnt++ << " " << ans << endl;
    }
}
