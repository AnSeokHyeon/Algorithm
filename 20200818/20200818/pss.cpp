// [모의 SW 역량테스트] 무선 충전.cpp : 이 파일에는 'main' 함수가 포함됩니다. 거기서 프로그램 실행이 시작되고 종료됩니다.
//

#include <iostream>
#include<memory.h>
#include <algorithm>
#include <vector>
#include <queue>

using namespace std;

typedef struct Cell {
    int cx, cy, cc, cp;
    bool use;

}cell;

typedef struct People {
    int x, y;
}people;

int M, A, T, Tcnt = 1;      // M: 이동시간, A: BC개수
bool board[11][11][9];
int ans = 0;
cell ap[9];
vector<int> user_move[2];
people user[2];

int r[5] = { 0, 0, 1, 0, -1 };      //이동x, 상, 우, 하, 좌
int c[5] = { 0, -1, 0, 1, 0 };

void Init() {
    user_move[0].clear();
    user_move[1].clear();
    memset(board, false, sizeof(board));
    memset(board, false, sizeof(board));
    memset(ap, NULL, sizeof(ap));
    memset(user, NULL, sizeof(user));
    ans = 0;
}

void charge_loc(int no, int x, int y, int ch, int p) {

    queue <pair<int, int>> q;
    q.push(make_pair(x, y));
    int visited[11][11];
    visited[y][x] = 0;

    while (!q.empty()) {
        pair<int, int> tq = q.front();
        q.pop();

        int nowx = tq.first;
        int nowy = tq.second;
        board[nowy][nowx][no] = true;


        for (int i = 1; i < 5; i++) {
            int nextx = nowx + r[i];
            int nexty = nowy + c[i];

            if (nextx < 1 || nextx  > 10 || nexty < 1 || nexty > 10)
                continue;
            if (board[nexty][nextx][no])
                continue;
            if (visited[nowy][nowx] < ch) {
                q.push(make_pair(nextx, nexty));
                visited[nexty][nextx] = visited[nowy][nowx] + 1;
                board[nowy][nowx][no] = true;
            }
        }
    }
}

//near_BC (근처에 있는 BC 판단)
int near_BC(int x1, int y1, int x2, int y2) {
    int max_pv = 0;
    int index1 = 0, index2 = 0;
    //완전 탐색 (최대 8*8=64) -> 1번 사람을 중심으로
    for (int i = 1; i <= A; i++) {
        for (int j = 1; j <= A; j++) {
            int temp_sum = 0;
            int t1 = 0; int t2 = 0;
            if (board[y1][x1][i] == true) {
                temp_sum += ap[i].cp;
                ap[i].use = true;
                t1 = i;
            }
            if (ap[j].use == false && board[y2][x2][j] == true) {
                temp_sum += ap[j].cp;
                ap[j].use = true;
                t2 = j;
            }

            max_pv = max(max_pv, temp_sum);

            // 초기화
            if (t1 != 0) {
                ap[t1].use = false;
            }
            // 초기화
            if (t2 != 0) {
                ap[t2].use = false;
            }
        }
    }
    return max_pv;
}

// 사람 움직이자
void move() {
    int time = 0;

    ans += near_BC(user[0].y, user[0].x, user[1].y, user[1].x);

    while (time < M) {
        time++;

        for (int i = 0; i < 2; i++) {
            user[i].x = user[i].x + c[user_move[i][time - 1]];
            user[i].y = user[i].y + r[user_move[i][time - 1]];
        }

        ans += near_BC(user[0].y, user[0].x, user[1].y, user[1].x);
    }
}

int main()
{
    // user_move, board, ap 초기화 해야된다
    //freopen("input.txt", "r", stdin);

    cin >> T;

    while (T--) {
        cin >> M >> A;

        Init();

        user[0].x = 1, user[0].y = 1;
        user[1].x = 10, user[1].y = 10;

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < M; j++) {
                int temp;
                cin >> temp;
                user_move[i].push_back(temp);
            }
        }

        for (int i = 1; i <= A; i++) {
            cin >> ap[i].cx >> ap[i].cy >> ap[i].cc >> ap[i].cp;
            ap[i].use = false;
            charge_loc(i, ap[i].cx, ap[i].cy, ap[i].cc, ap[i].cp);   //충전소 위치 및 범위 설정
        }

        move();
        cout << "#" << Tcnt << " " << ans << endl;
        Tcnt++;
    }

    return 0;
}