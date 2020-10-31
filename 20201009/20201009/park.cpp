// [19235] 모노미노도미노.cpp : 이 파일에는 'main' 함수가 포함됩니다. 거기서 프로그램 실행이 시작되고 종료됩니다.
//

#include <iostream>

using namespace std;

typedef struct Order {
    int t, x, y;
}order;

typedef struct B {
    int t, x, y, s;
}blk;

int block[4][2] = { {0,0} ,{0,0},{0,2},{0,3} };
int N;
int board1[6][4];
int board2[4][6];
blk state1[10001];
blk state2[10001];
order o[10001];
int dx[] = { 0, -1, 0, 1, 0 };
int dy[] = { 0, 0, 1, 0, -1 };

void block_pop1(int row) {
    //1칸씩 내리기
    for (int i = row; i >= 1; i--) {
        for (int j = 0; j < 4; j++) {
            //ㅣ일때
            if (i == row && state1[board1[i][j]].t == 3) {
                state1[board1[i][j]].t = 1;
                state1[board1[i][j]].s--;
                state1[board1[i][j]].x++;
                board1[i][j] = board1[i - 1][j];
                continue;
            }
            if (state1[board1[i][j]].x == i && state1[board1[i][j]].y == j) {
                state1[board1[i][j]].x++;
            }
            board1[i][j] = board1[i - 1][j];
        }
    }
    for (int i = 0; i < 4; i++) {
        board1[0][i] = 0;
    }

    cout << "Board1 삭제 이동 완료 " << endl;
    for (int i = 0; i < 6; i++) {
        for (int j = 0; j < 4; j++) {
            printf("%3d", board1[i][j]);
        }
        cout << endl;
    }
    cout << endl;
    // 1칸 다 내리고 또 내려지는 놈있니?
    for (int j = 0; j < 4; j++) {
        for (int i = 5; i >= 1; i--) {
            if (board1[i][j] == 0) {
                for (int k = i - 1; k >= 0; k--) {
                    if (board1[k][j] > 0) {
                        if (state1[board1[k][j]].t != 2) {
                            if (state1[board1[k][j]].t == 3) {
                                board1[i][j] = board1[k][j];
                                board1[i - 1][j] = board1[k][j];
                                state1[board1[k][j]].x++;
                                board1[i - 2][j] = 0;
                                break;
                            }
                            board1[i][j] = board1[k][j];
                            board1[k][j] = 0;
                            break;
                        }
                        else {
                            break;
                        }
                    }
                }
            }
        }
    }

    cout << "Board1 한번더 체크 " << endl;
    for (int i = 0; i < 6; i++) {
        for (int j = 0; j < 4; j++) {
            printf("%3d", board1[i][j]);
        }
        cout << endl;
    }
    cout << endl;
}

void block_pop2(int col) {
    for (int i = col; i >= 1; i--) {
        for (int j = 0; j < 4; j++) {
            //ㅣ일때
            if (i == col && state2[board2[j][i]].t == 2) {
                state2[board2[j][i]].t = 1;
                state2[board2[j][i]].s--;
                state2[board2[j][i]].y++;
                board2[j][i] = board2[j][i - 1];
                continue;
            }
            if (state2[board2[j][i]].x == i && state2[board2[j][i]].y == j) {
                state2[board2[j][i]].y++;
            }
            board2[j][i] = board2[j][i - 1];
        }
    }
    for (int i = 0; i < 4; i++) {
        board2[i][0] = false;
    }

    for (int j = 0; j < 4; j++) {
        for (int i = 5; i >= 1; i--) {
            if (board2[j][i] == 0) {
                for (int k = i - 1; k >= 0; k--) {
                    if (board2[j][k] > 0) {
                        if (state2[board2[j][k]].t != 3) {
                            if (state2[board2[j][k]].t == 2) {
                                board2[j][i] = board2[j][k];
                                board2[j][i - 1] = board2[j][k];
                                state2[board2[j][k]].y++;
                                board2[j][i - 2] = 0;
                                break;
                            }
                            board2[j][i] = board2[j][k];
                            board2[j][k] = 0;
                            break;
                        }
                        else {
                            break;
                        }
                    }
                }
            }
        }
    }
}


int main()
{
    cin >> N;

    for (int i = 1; i <= N; i++) {
        int t, x, y;
        cin >> t >> x >> y;
        o[i] = { t, x, y };
    }

    int start = 1;
    int score = 0;

    while (start <= N) {
        int sx = o[start].x;
        int sy = o[start].y;
        int sb = o[start].t;
        bool s = false;
        //밑에 놈부터 시작해보자(y위치가 제일 중요하다)
        int x1 = -1;
        int y1 = sy;
        for (int i = 0; i < 6; i++) {
            if (sb == 2) {
                if (board1[i][sy] > 0 || board1[i][sy + 1] > 0) {
                    x1 = i - 1;
                    break;
                }
            }
            else if (board1[i][sy] > 0) {
                x1 = i - 1;
                break;
            }
        }
        if (x1 == -1) x1 = 5;
        //만약 sb=3이면 ㅣ이므로 1개 더 빼준다
        if (sb == 3)
            x1 -= 1;

        //색칠하자
        int size1 = 1;
        if (sb == 2 || sb == 3) size1 = 2;

        state1[start] = { sb, x1, y1, size1 };

        for (int k = 0; k < 2; k++) {
            int nx = x1 + dx[block[sb][k]];
            int ny = y1 + dy[block[sb][k]];

            board1[nx][ny] = start;
        }

        cout << "Board1 이동 완료" << endl;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 4; j++) {
                printf("%3d", board1[i][j]);
            }
            cout << endl;
        }
        cout << endl;

        //부셔보자(아래부터 시작하자)
        bool go = false;

        while (!go) {
            bool t_go = false;
            for (int i = 2; i <= 5; i++) {
                if (board1[i][0] > 0 && board1[i][1] > 0 && board1[i][2] > 0 && board1[i][3] > 0) {
                    block_pop1(i);
                    t_go = true;
                    s = true;
                    score++;
                    break;
                }
            }
            //부실게 없으면 go = true
            if (!t_go) go = true;
        }


        // 다 부셨으면 연한 블록에 있는지 확인해서 있으면 부시자
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 4; j++) {
                if (board1[i][j] > 0) {
                    block_pop1(5);
                    break;
                }
            }
        }

        //옆에 놈부터 시작해보자(x 위치가 제일 중요하다)
        int x2 = sx;
        int y2 = -1;
        for (int i = 0; i < 6; i++) {
            if (sb == 3) {
                if (board2[x2][i] > 0 || board2[x2 + 1][i] > 0) {
                    y2 = i - 1;
                    break;
                }
            }
            else if (board2[sx][i] > 0) {
                y2 = i - 1;
                break;
            }
        }
        if (y2 == -1) y2 = 5;

        //만약 sb=2이면 ㅡ이므로 1개 더 빼준다
        if (sb == 2)
            y2 -= 1;


        //색칠하자
        int size2 = 1;
        if (sb == 2 || sb == 3) size2 = 2;

        state2[start] = { sb, x2, y2, size2 };

        for (int k = 0; k < 2; k++) {
            int nx = x2 + dx[block[sb][k]];
            int ny = y2 + dy[block[sb][k]];

            board2[nx][ny] = start;
        }

        //부셔보자(아래부터 시작하자)
        bool go1 = false;

        while (!go1) {
            bool t_go = false;
            for (int i = 2; i <= 5; i++) {
                if (board2[0][i] > 0 && board2[1][i] > 0 && board2[2][i] > 0 && board2[3][i] > 0) {
                    block_pop2(i);
                    t_go = true;
                    s = true;
                    score++;
                    break;
                }
            }
            //부실게 없으면 go = true
            if (!t_go) go1 = true;
        }


        // 다 부셨으면 연한 블록에 있는지 확인해서 있으면 부시자
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 4; j++) {
                if (board2[j][i] > 0) {
                    block_pop2(5);
                    break;
                }
            }
        }

        cout << start << endl;
        cout << " SB :" << sb << "SX : " << sx << " SY :" << sy << endl;

        cout << "Board1 완료 " << endl;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 4; j++) {
                printf("%3d", board1[i][j]);
            }
            cout << endl;
        }
        cout << endl;

        cout << "Board2 완료  " << endl;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 6; j++) {
                printf("%3d", board2[i][j]);
            }
            cout << endl;
        }
        cout << endl;

        start++;
    }

    int cnt = 0;
    for (int i = 0; i < 6; i++) {
        for (int j = 0; j < 4; j++) {
            if (board1[i][j] > 0) cnt++;
        }
    }

    for (int i = 0; i < 4; i++) {
        for (int j = 0; j < 6; j++) {
            if (board2[i][j] > 0) cnt++;
        }
    }

    cout << score << endl;
    cout << cnt << endl;
}