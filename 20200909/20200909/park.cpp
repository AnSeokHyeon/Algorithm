// [13460] 구슬 탈출 2.cpp : 이 파일에는 'main' 함수가 포함됩니다. 거기서 프로그램 실행이 시작되고 종료됩니다.
//

#include <iostream>
#include <queue>
#include <algorithm>

using namespace std;

typedef struct Location {
    int x, y;
}loc;

int N, M, ans = 987654321;
char board[11][11];
loc R, B, O;
int dx[] = { -1, 1, 0, 0 };   // 상하좌우
int dy[] = { 0, 0, -1, 1 };

//방향대로 기울이자
int simulate(int dir) {
    queue <loc> q;

    // 방향부터 확인
    if (dir == 0) {
        if (R.x > B.x) {
            q.push(B);
            q.push(R);
        }
        else {
            q.push(R);
            q.push(B);
        }
    }
    else if (dir == 1) {
        if (R.x > B.x) {
            q.push(R);
            q.push(B);
        }
        else {
            q.push(B);
            q.push(R);
        }
    }
    else if (dir == 2) {
        if (R.y > B.y) {
            q.push(B);
            q.push(R);
        }
        else {
            q.push(R);
            q.push(B);
        }
    }
    else {
        if (R.y > B.y) {
            q.push(R);
            q.push(B);
        }
        else {
            q.push(B);
            q.push(R);
        }
    }

    int finish = 0; //0일때 진행중, 1일때 Red만빠짐, 2일때 Blue만빠짐, 3일때 다빠짐.

    while (!q.empty()) {
        loc now = q.front();
        char temp = board[now.x][now.y];

        q.pop();

        loc next = { now.x + dx[dir], now.y + dy[dir] };

        if (next.x == 0 || next.x == N - 1 || next.y == 0 || next.y == M - 1)
            continue;
        if (board[next.x][next.y] == '#' || board[next.x][next.y] == 'R' || board[next.x][next.y] == 'B')
            continue;
        //구멍에 빠졌을때
        if (board[next.x][next.y] == 'O') {
            if (temp == 'R') {
                finish = finish | (1 << 0);
                board[now.x][now.y] = '.';
                R = now;
            }
            if (temp == 'B') {
                finish = finish | (1 << 1);
                board[now.x][now.y] = '.';
                B = now;
            }
            continue;
        }

        //성공하면 끝날때마다 보드 좌표 바꿔야된다.
        if (temp == 'R') {
            board[next.x][next.y] = 'R';
            board[now.x][now.y] = '.';
            R = next;
        }
        else {
            board[next.x][next.y] = 'B';
            board[now.x][now.y] = '.';
            B = next;
        }
        q.push(next);
    }

    // 둘다들어갔으면
    if (finish == 1)
        return 1;
    //실패했다
    else if (finish == 2 || finish == 3)
        return 2;
    //계속해라
    else
        return 0;
}

void dfs(int now, int dir) {
    if (dir == 0) {
        if (R.x == 1) return;
    }
    else if (dir == 1) {
        if (R.x == N - 2) return;
    }
    else if (dir == 2) {
        if (R.y == 1)  return;
    }
    else {
        if (R.y == M - 2)  return;
    }

    //백트래킹을 위한 임시배열
    char t_board[11][11];
    loc t_R, t_B;
    for (int i = 1; i < N - 1; i++) {
        for (int j = 1; j < M - 1; j++) {
            t_board[i][j] = board[i][j];
        }
    }
    t_R = R;
    t_B = B;

    // 보드상태를 현재방향 dir대로 움직이자
    int finish = simulate(dir);

    // '0'에 들어가 끝났으면
    if (finish == 1) {
        ans = min(ans, now);
    }

    // 아직 안끝났으면
    if (finish == 0 && now < 10) {
        for (int i = 0; i < 4; i++) {
            dfs(now + 1, i);
        }
    }

    //백트래킹
    for (int i = 1; i < N - 1; i++) {
        for (int j = 1; j < M - 1; j++) {
            board[i][j] = t_board[i][j];
        }
    }
    R = t_R;
    B = t_B;
}

int main()
{
    cin >> N >> M;

    for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
            cin >> board[i][j];
            if (board[i][j] == 'B')
                B = { i, j };
            else if (board[i][j] == 'R')
                R = { i, j };
            else if (board[i][j] == 'O')
                O = { i, j };
        }
    }

    for (int i = 0; i < 4; i++)
        dfs(1, i);

    if (ans == 987654321)
        ans = -1;

    cout << ans;
    return 0;
}