// [���� SW �����׽�Ʈ] ���� ����.cpp : �� ���Ͽ��� 'main' �Լ��� ���Ե˴ϴ�. �ű⼭ ���α׷� ������ ���۵ǰ� ����˴ϴ�.
//

#include <iostream>
#include <queue>
#include <algorithm>
#include <memory.h>
using namespace std;
int N, W, H, ans = 987654321;
int board[16][13];
int tboard[16][13];
int check[16][13];
int order[13] = {};
int cnt = 0;

int dx[] = { -1, 0, 0, 1 };
int dy[] = { 0, -1, 1, 0 };

typedef struct bkdol {
	int x, y, s;
}bd;

queue <pair<int, int>> wq;


// 4�������� ������
void remove(pair<int, int> b, int dir, int now, bd f) {
	//����

	//cout << b.first << " / " << b.second << " " << endl;
	if (b.first<1 || b.first>H || b.second <1 || b.second >W) {
		return;
	}

	if (f.s < now) {
		return;
	}
	if (check[b.first][b.second] != 0) {
	
	}
	else {

		if (tboard[b.first][b.second] > 1) {
			wq.push({ b.first, b.second });
		}
		check[b.first][b.second] = 1;
	}

	remove({ b.first + dx[dir], b.second + dy[dir] }, dir, now + 1, f);
}


int fire(int order[]) {
	// tboard �ʱ�ȭ
	memcpy(tboard, board, sizeof(board));
	// 1~N������ ����
	for (int start = 1; start <= N; start++) {
		memset(check, 0, sizeof(check));
		// 1��°������ ����
		int now = order[start];
		bool f = true;

		//���� ���� ���� �˻�
		for (int i = 1; i <= H; i++) {
			// ���� ���� �� ã����
			if (tboard[i][now] >= 1) {
				wq.push({ i, now });
				f = false;
				break;
			}
		}

		// �ƹ��͵� ������
		if (f)
			continue;


		// start��° ���� ��
		while (!wq.empty()) {
			pair<int, int> n = wq.front();
			cnt++;
			check[n.first][n.second] = 1;
			wq.pop();

			//4���� check
			for (int j = 0; j < 4; j++) {
				//cout << n.first << n.second << j << endl;
				remove(n, j, 1, { n.first, n.second, tboard[n.first][n.second] });
			}
		}

		//cout << 4 << endl;

		//for (int ii = 1; ii <= H; ii++) {
		//    for (int jj = 1; jj <= W; jj++) {
		//        cout << check[ii][jj];
		//    }
		//    cout << endl;
		//}
		//cout << endl;


		// ������������
		for (int ii = 1; ii <= H; ii++) {
			for (int jj = 1; jj <= W; jj++) {
				if (check[ii][jj] == 1) {
					tboard[ii][jj] = 0;
				}
			}
		}


		// ������
		for (int ww = 1; ww <= W; ww++) {
			for (int ii = H; ii >= 1; ii--) {
				if (tboard[ii][ww] == 0) {
					for (int jj = ii - 1; jj >= 1; jj--) {
						if (tboard[jj][ww] != 0) {
							tboard[ii][ww] = tboard[jj][ww];
							tboard[jj][ww] = 0;
							break;
						}
					}
				}
			}
		}

		//for (int ii = 1; ii <= H; ii++) {
		//    for (int jj = 1; jj <= W; jj++) {
		//        cout << tboard[ii][jj];
		//    }
		//    cout << endl;
		//}
		//cout << endl;

	}

	int ret = 0;
	//1���� �ٳ�����
	//cout << " �� ����" << endl;
	for (int r = 1; r <= H; r++) {
		for (int c = 1; c <= W; c++) {
			//cout << tboard[r][c] << " ";
			if (tboard[r][c] > 0) {
				ret++;
			}
		}
		//cout << endl;
	}
	//cout << " �� :  " << ret << endl;
	return ret;
}


//���� ����
void dfs(int now, int finish) {
	if (now == finish + 1) {
		ans = min(ans, fire(order));
		return;
	}

	for (int i = 1; i <= W; i++) {
		order[now] = i;
		dfs(now + 1, finish);
	}
}

int main()
{
	int T, Tcnt = 1;
	cin >> T;
	while (T--) {

		cin >> N >> W >> H;

		ans = 987654321;

		for (int i = 1; i <= H; i++) {
			for (int j = 1; j <= W; j++) {
				cin >> board[i][j];
			}
		}
		for (int i = 1; i <= N; i++) {
			if (i == 1 || i == 2)
				order[i] = 3;
			else
				order[i] = 7;
		}
		dfs(1, N);

		//fire(order);

		cout << " �� ť : " << cnt << endl;
		cout << "#" << Tcnt++ << " " << ans << endl;
	}
}