// [SW Test 샘플문제] 프로세서 연결하기.cpp : 이 파일에는 'main' 함수가 포함됩니다. 거기서 프로그램 실행이 시작되고 종료됩니다.
//

#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>
#include <memory.h>

#define INF 987654321

using namespace std;

typedef struct Core {
    int x, y, dir;
}c;

vector <c> core;      //테두리 코어를 제외한 나머지 코어의 좌표

int board[13][13];
int check[13][13];      // 가지 못하는 경로 체크
int T, Tcnt = 1, N, ans = INF, c_ans = 0;
int rx[] = { 0, -1, 0, 1, 0 };
int cy[] = { 0,  0, 1, 0, -1 };

void Init() {
    memset(board, 0, sizeof(board));
    memset(check, false, sizeof(check));
    core.clear();
    ans = INF;
}

bool search(int i, int t_check[][13]) {
    queue <c> q;
    q.push(core[i]);
    t_check[core[i].x][core[i].y] = 1;

    while (!q.empty()) {
        c now = q.front();
        q.pop();

        c next = { now.x + rx[now.dir], now.y + cy[now.dir], now.dir };

        //종료
        if (next.x < 1 || next.x >N || next.y<1 || next.y>N) {
            return true;
        }

        // 이미 선이 설치되어있거나 칩이 있다면
        if (t_check[next.x][next.y] >= 1) {
            return false;
        }

        q.push(next);
        t_check[next.x][next.y] = 2;
    }
}

int find() {
    int r = 0;
//cout << " 박승섭 파이팅 " << endl;
    for (int i = 1; i <= N; i++) {
        for (int j = 1; j <= N; j++) {
           //cout << check[i][j] << " ";
            if (check[i][j] == 2)
                r++;
        }
       //cout << endl;
    }
    return r;
}

// 순열(완전탐색)
void dfs(int now, int finish, int core_cnt) {
    if (now == finish) {
        //탐색 시작
        if (c_ans <= core_cnt) {
            if (c_ans < core_cnt) ans = INF;
            ans = min(ans, find());
            c_ans = core_cnt;
        }
        return;
    }
    if (check[core[now].x + 1][core[now].y] == 1 && check[core[now].x - 1][core[now].y] == 1 && check[core[now].x][core[now].y + 1] == 1 && check[core[now].x][core[now].y - 1] == 1) {
        dfs(now + 1, finish, core_cnt );
    }
    else {

        for (int i = 1; i <= 4; i++) {
            int t_chk[13][13], back_chk[13][13];
            memcpy(t_chk, check, sizeof(check));
            memcpy(back_chk, check, sizeof(check));

            core[now].dir = i;

            if (search(now, t_chk) == true) {
                memcpy(check, t_chk, sizeof(t_chk));
                dfs(now + 1, finish, core_cnt + 1);
                memcpy(check, back_chk, sizeof(back_chk));
            }
        }
    }

    //0~4: 상하좌우 면
}

int main()
{
    cin >> T;

    while (T--) {

        Init();

        cin >> N;

        int t_core = 0;

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                cin >> board[i][j];
                if (board[i][j] == 1) {
                    check[i][j] = 1;
                    t_core++;

                    //구석탱이에 있는놈이 아닌 코어인 경우
                    if (i > 1 && i < N && j>1 && j < N) {
                        core.push_back({ i, j, -1 });
                    }
                }
            }
        }

        int c_cnt = core.size();
        int n_core = t_core - c_cnt;

        dfs(0, c_cnt, n_core);

        cout << "#" << Tcnt << " " << ans << endl;
        Tcnt++;
    }
}