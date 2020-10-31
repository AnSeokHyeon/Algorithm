#include <iostream>
#include <stack>

using namespace std;

struct pos {
	int x;
	int y;
	int ck;
	pos(int x, int y, int ck) {
		this->x = x;
		this->y = y;
		this->ck = ck;
	}
};

int N, M;
int dx[] = { 1, -1, 0 , 0 };
int dy[] = { 0, 0, 1, -1 };
int c[102][102];
int map[102][102];
int temp=200000;

void dfs(int x, int y, int n) {
	stack<pos> st;
	st.push(pos(x, y, n));
	while (!st.empty()) {
		pos f = st.top();
		int x = f.x;
		int y = f.y;
		int ck = f.ck;
		st.pop();
		for (int i = 0; i < 4; i++) {
			int mx = x + dx[i];
			int my = y + dy[i];
			int mck = ck + 1;
			if (mx < 1 || my < 1) continue;
			if (mx > N || my > M) continue;
			if (c[mx][my] <= mck && c[mx][my] !=0 ) continue;
			if (map[mx][my] == 1) {
				st.push(pos(mx, my, mck));
				c[mx][my] = mck;
			}
		}
	}
}

int main(void) {
	cin >> N >> M;
	for (int i = 1; i <= N; i++) {
		for (int j = 1; j <= M; j++) {
			int num;
			scanf_s("%1d", &num);
			map[i][j] = num;
		}
	}
	dfs(1, 1, 1);
	cout << c[N][M];
	return 0;
}

