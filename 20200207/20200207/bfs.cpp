#include <iostream>
#include <queue>

using namespace std;

struct pos {
	int x;
	int y;
	int ck;
	pos(int x, int y, int ck) {
		this->x = x;
		this->y = y;
		this->ck = ck;
	};
};

int map[102][102] = { 0 };
int c[102][102] = { 0 };
int dx[] = { 1, -1, 0, 0 };
int dy[] = { 0, 0, 1, -1 };
int N, M, temp;

void bfs(int x, int y, int n) {
	queue<pos> q; // ť ���� 
	q.push(pos(x, y, n)); // ���۰� Ǫ�� 
	while (!q.empty()) {
		pos f = q.front(); //q.front ���� f�� ���� 
		int x = f.x; // f�� ù��° ��ǥ, x�� ���� 
		int y = f.y; // f�� �ι�° ��ǥ, y�� ���� 
		int ck = f.ck;
		temp = ck;
		if (x == N && y == M) break;
		q.pop(); // q�ϳ� ���� 
		for (int i = 0; i < 4; i++) {
			int mx = x + dx[i]; // �̵��� ���ο� x ��ǥ  mx 
			int my = y + dy[i]; // �̵��� ���ο� y ��ǥ  my 
			int mz = ck + 1;

			if (mx < 0 || my < 0) continue; // x�ຸ�� �۰ų�  y�ຸ�� ������ for�� out 
			if (mx > N || my > M) continue; // N���� ũ�ų�  M���� ũ�� for �� out 
			if (c[mx][my] == 1) continue; // �̹� ������ �����̸� for�� out 
			if (map[mx][my] == 1) { //���� �ƴҰ�� ����  
				q.push(pos(mx, my, mz)); //�̵���ǥ Ǫ�� 
				c[mx][my] = 1;
			}
		}
	}
	cout << temp;
}

int main(void) {
	cin >> N >> M;
	for (int i = 1; i <= N; i++) {
		for (int j = 1; j <= M; j++) {
			int num;
			scanf("%1d", &num);
			map[i][j] = num;
		}
	}
	bfs(1, 1, 1);
	return 0;
}