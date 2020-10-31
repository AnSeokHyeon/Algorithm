// [9944] NxM 보드 완주하기.cpp : 이 파일에는 'main' 함수가 포함됩니다. 거기서 프로그램 실행이 시작되고 종료됩니다.
//

#include <iostream>
#include <algorithm>
#include <vector>
#include <memory.h>
using namespace std;

typedef struct Location {
    int x, y;
}loc;

int N, M, check_size, n_check = 0, cnt = 1, ans = 987654321;
char board[30][30];
bool check[30][30] = {};
int chk[30][30] = {};

int dx[] = { -1, 1, 0, 0 };
int dy[] = { 0, 0, -1, 1 };

void dfs(int depth, int dir, loc l) {
    if (depth >= ans)
        return;

    // 처음 시작할때
    check[l.x][l.y] = true;
    n_check++;

    // 이미 다체크했으면
    if (check_size == n_check) {
        ans = min(ans, depth);
        //다 체크했으면 종료
        check[l.x][l.y] = false;
        n_check--;
        return;
    }

    //이동할 방면이 없으면 종료
    for (int i = 0; i < 4; i++) {
        loc next = { l.x + dx[i % 4], l.y + dy[i % 4] };
        if (next.x<0 || next.x>N - 1 || next.y<0 || next.y>M - 1) continue;
        if (check[next.x][next.y] == true) continue;
        if (board[next.x][next.y] == '*') continue;
        if (dir == i) {
            dfs(depth, i, next);
            break;
        }
        if (dir != i)  dfs(depth + 1, i, next);
    }

    //다 체크했으면 종료(백트래킹)
    check[l.x][l.y] = false;
    n_check--;
}

int main()
{
    while (cin >> N >> M) {

        memset(board, 0, sizeof(board));
        memset(check, false, sizeof(check));

        vector<loc> go;
        int edge = 0;
        check_size = 0;
        ans = 987654321;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                cin >> board[i][j];
                if (board[i][j] == '.') {
                    check_size++;
                    go.push_back({ i, j });
                    //if (i == 0 || i == N - 1 || j == 0 || j == M - 1)
                      //  go.push_back({ i, j });
                }
            }
        }
        if (go.size() == 1) ans = 0;

        for (int i = 0; i < go.size(); i++) {
            for (int k = 0; k < 4; k++) {
                //if (go[i].x + dx[k]< 0 || go[i].x + dx[k]>N - 1 || go[i].y + dy[k]<0 || go[i].y + dy[k] > M - 1) continue;
                //if (board[go[i].x + dx[k]][go[i].y + dy[k]] == '*') continue;
                dfs(1, k, go[i]);
            }
        }

        if (ans == 987654321)
            ans = -1;

        cout << "Case " << cnt++ << ": " << ans << endl;
    }
}