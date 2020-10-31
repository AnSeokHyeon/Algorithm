// [19238] ��ŸƮ �ý�.cpp : �� ���Ͽ��� 'main' �Լ��� ���Ե˴ϴ�. �ű⼭ ���α׷� ������ ���۵ǰ� ����˴ϴ�.
//

#include <iostream>
#include <queue>
#include <algorithm>
#include<memory.h>
#include <vector>

using namespace std;

typedef struct Taxi {
    int x, y, fuel;
}T;
typedef struct Client {
    int sx, sy, fx, fy;
    bool fns;
}C;

Taxi t;
Client c[401];
int N, M, F;
int board[21][21];
int chk[21][21];

int dx[] = { 0,0,-1,1 };
int dy[] = { -1,1,0,0 };

int main()
{
    cin >> N >> M >> F;

    for (int i = 1; i <= N; i++) {
        for (int j = 1; j <= N; j++) {
            cin >> board[i][j];
            if (board[i][j] == 1)
                board[i][j] = -1;
        }
    }

    cin >> t.x >> t.y;
    t.fuel = F;

    for (int i = 1; i <= M; i++) {
        cin >> c[i].sx >> c[i].sy >> c[i].fx >> c[i].fy;
        board[c[i].sx][c[i].sy] = i;   //�����ġ�� ǥ��
    }

    int total = M;

    // �ý� ���� ���� ����� �� ã��
    while (1) {
        //�� ã��
       // cout << " ���� ����!!!!@!@!@!@!@!@!@!@" << endl;
        pair<int, int> now = { t.x, t.y };
        memset(chk, -1, sizeof(chk));
        //cout << "���� �ý� ��ġ : " << t.x << " , " << t.y << endl;

        queue <pair<int, int>> q;
        q.push(now);
        chk[now.first][now.second] = 0;

        int s_dis = 987654321;

        vector<int> sd_idx;

        if (board[now.first][now.second] >= 1 && c[board[now.first][now.second]].fns == false) {
            sd_idx.push_back(board[now.first][now.second]);
            s_dis = 0;
        }

        else {
            //cout << " ã���� �� " << endl;
            while (!q.empty()) {
                pair<int, int> n = q.front();
                q.pop();

                for (int k = 0; k < 4; k++) {
                    int nx = n.first + dx[k];
                    int ny = n.second + dy[k];

                    if (nx<1 || nx>N || ny<1 || ny>N) continue;
                    if (board[nx][ny] == -1) continue;
                    if (chk[nx][ny] >= 0) continue;
                    if (board[nx][ny] >= 1) {
                        if (c[board[nx][ny]].fns) continue;
                        if (s_dis == chk[n.first][n.second] + 1) {
                            sd_idx.push_back(board[nx][ny]);
                        }
                        if (s_dis == 987654321) {
                            s_dis = chk[n.first][n.second] + 1;
                            sd_idx.push_back(board[nx][ny]);
                        }
                    }
                    q.push({ nx, ny });
                    chk[nx][ny] = chk[n.first][n.second] + 1;
                }
            }
        }

        //���� ������ ã��
        //���� �� ������
        if (s_dis == 987654321) {
            t.fuel = -1;
            break;
        }

        int first = sd_idx[0];
        if (sd_idx.size() > 1) {
            for (int i = 1; i < sd_idx.size(); i++) {
                if (c[first].sx == c[sd_idx[i]].sx) {
                    if (c[first].sy > c[sd_idx[i]].sy) {
                        first = sd_idx[i];
                    }
                }
                else if (c[first].sx > c[sd_idx[i]].sx) {
                    first = sd_idx[i];
                }
            }
        }

        //���� �ý���ġ �ʱ�ȭ �� ���� �ʱ�ȭ
        t.fuel -= s_dis;
        if (t.fuel < 0) {
            t.fuel = -1;
            break;
        }
        t.x = c[first].sx;
        t.y = c[first].sy;
        /*cout << "�ý���ġ : " << t.x << " " << t.y << endl;
        cout << first << "�� ������� ���µ� �ʿ� ����" << s_dis << endl;
        cout << "���翬��" << t.fuel << endl;

        cout << " ���� ���� !@@!@" << endl;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                cout << board[i][j] << " ";
            }
            cout << endl;
        }

        cout << " ���� ���� " << endl;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                cout << chk[i][j] << " ";
                chk[i][j] = 0;
            }
            cout << endl;
        }*/
        //first�� finish �������� �̵�����
        memset(chk, -1, sizeof(chk));
        queue <pair<int, int>> q2;
        q2.push({ t.x, t.y });
        chk[t.x][t.y] = 0;

        int need_f = 0;
        bool finish = false;
        if (t.x == c[first].fx && t.y == c[first].fy)
            finish = true;

        if (!finish) {
            while (!q2.empty()) {
                pair<int, int> n = q2.front();
                q2.pop();

                for (int k = 0; k < 4; k++) {
                    int nx = n.first + dx[k];
                    int ny = n.second + dy[k];

                    if (nx<1 || nx>N || ny<1 || ny>N) continue;
                    if (board[nx][ny] == -1) continue;
                    //if (board[nx][ny] > 0) continue;
                    if (chk[nx][ny] >= 0) continue;
                    //��������
                    if (nx == c[first].fx && ny == c[first].fy) {
                        need_f = chk[n.first][n.second] + 1;
                        finish = true;
                        board[t.x][t.y] = 0;
                        break;
                    }
                    q2.push({ nx, ny });
                    chk[nx][ny] = chk[n.first][n.second] + 1;
                }
                if (finish)
                    break;
            }
        }

        //cout << " ���� ���� !@!@!@!@!@!@" << endl;
        //for (int i = 1; i <= N; i++) {
        //	for (int j = 1; j <= N; j++) {
        //		cout << board[i][j] << " ";
        //	}
        //	cout << endl;
        //}

        //cout << " ���� ���� " << endl;
        //for (int i = 1; i <= N; i++) {
        //	for (int j = 1; j <= N; j++) {
        //		cout << chk[i][j] << " "; 
        //		chk[i][j] = 0;
        //	}
        //	cout << endl;
        //}


        //cout << first << "�� �������� ���µ� �ʿ� ����" << need_f << endl;

        //�� �����Ҷ�
        if (finish == false) {
            t.fuel = -1;
            break;
        }

        if (t.fuel < need_f) {
            t.fuel = -1;
            break;
        }
        else {
            t.fuel += need_f;
            c[first].fns = true;
            t.x = c[first].fx;
            t.y = c[first].fy;
            total--;
        }

        //cout << "���翬��" << t.fuel << endl;
        //cout << "�°� �¿��ְ� �ý���ġ : " << t.x << " " << t.y << endl;

        // ��ü size�� 0�̸� ����
        if (total == 0)
            break;
    }
    cout << t.fuel;
}