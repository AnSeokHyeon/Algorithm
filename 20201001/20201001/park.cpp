// [19236] û�ҳ� ���.cpp : �� ���Ͽ��� 'main' �Լ��� ���Ե˴ϴ�. �ű⼭ ���α׷� ������ ���۵ǰ� ����˴ϴ�.
//

#include <iostream>
#include <algorithm>

using namespace std;

typedef struct Shark {
	int x, y, dir;
}S;
typedef struct Fish {
	int x, y, dir;
	bool dead;
}F;

S s;
F f[17];

pair<int, int> board[5][5]; //��ȣ�� ������ ����
int ans = -1;
int dx[] = { 0, -1, -1, 0, 1, 1, 1, 0, -1 };
int dy[] = { 0, 0, -1, -1, -1, 0, 1, 1, 1 };

void fish() {
	//���� ��ȣ���� �ű���
	cout << " �ű�� �� " << endl;

	cout << " �̵� �� ��Ȳ ~!@#!@#@!#@!#@!#@!#@!#!@ " << endl;
	for (int k = 1; k <= 4; k++) {
		for (int j = 1; j <= 4; j++) {
			cout << board[k][j].first << ' ';
		}
		cout << endl;
	}
	for (int i = 1; i <= 16; i++) {
		if (f[i].dead) continue;

		int x = f[i].x;
		int y = f[i].y;
		int dir = f[i].dir;

		for (int k = dir; k < dir + 8; k++) {
			//�̵��� �� ���� ��� ����� �ʿ� ����
			k = k % 8;
			if (k == 0)
				k = 8;

			int nx = x + dx[k];
			int ny = y + dy[k];

			if (nx < 1 || nx> 4 || ny < 1 || ny> 4) continue;   // ��� �Ѵ� ���
			if (board[nx][ny].first == -1) continue;   // ��� �ִ� ���
			//����Ⱑ ������
			if (board[nx][ny].first > 0) {
				pair<int, int> change = board[nx][ny];
				board[nx][ny] = { i, k };
				f[i] = { nx, ny, k, false };

				board[x][y] = change;
				f[change.first] = { x, y, change.second, false };
				break;
			}
			//��ĭ�̸�
			else if (board[nx][ny].first == 0) {
				board[nx][ny] = { i, k };
				f[i] = { nx, ny, k ,false };

				board[x][y] = { 0, 0 };
				break;
			}
		}
		cout << i <<"  : "  << " �̵� ��Ȳ " << endl;
		for (int k = 1; k <= 4; k++) {
			for (int j = 1; j <= 4; j++) {
				cout << board[k][j].first << ' ';
			}
			cout << endl;
		}
	}
}

void dfs(int feed) {

	//����� �ѹ� �̵�
	fish();

	// ���� board ����
	pair<int, int> t_board[5][5];
	for (int i = 1; i <= 4; i++) {
		for (int j = 1; j <= 4; j++) {
			t_board[i][j] = board[i][j];
		}
	}

	//���� ��� ��ġ, ����
	int x = s.x;
	int y = s.y;
	int dir = s.dir;

	//������ �̵�
	for (int k = 1; k <= 3; k++) {
		int nx = s.x + k * dx[s.dir];
		int ny = s.y + k * dy[s.dir];

		//������ �Ѿ��
		if (nx < 1 || nx>4 || ny < 1 || ny>4) continue;
		if (board[nx][ny].first <= 0) continue; //����Ⱑ ������

		//cout << "��������: " << s.dir << endl;

		//for (int i = 1; i <= 4; i++) {
		//    for (int j = 1; j <= 4; j++) {
		//        cout << board[i][j].first << ' ';
		//    }
		//    cout << endl;
		//}

		//����Ⱑ ������ �԰� ��ġ �ֽ�ȭ����
		s.x = nx;
		s.y = ny;
		s.dir = board[nx][ny].second;
		int t = board[nx][ny].first;

		f[t].dead = true; //����� ���̱�
		board[nx][ny] = { -1, s.dir };
		board[x][y] = { 0, 0 };


		/*  cout << t + feed << endl;
		  cout << "�ٲ� ����: " << s.dir << endl;
		  for (int i = 1; i <= 4; i++) {
			  for (int j = 1; j <= 4; j++) {
				  cout << board[i][j].first << ' ';
			  }
			  cout << endl;
		  }*/

		  // ���� ���� + t
		dfs(feed + t);

		s.x = x;
		s.y = y;
		s.dir = dir;
		f[t].dead = false;

		for (int i = 1; i <= 4; i++) {
			for (int j = 1; j <= 4; j++) {
				board[i][j] = t_board[i][j];
			}
		}
	}

	cout << "����feed" << feed << endl;
	ans = max(ans, feed);
}

int main()
{
	for (int i = 1; i <= 4; i++) {
		for (int j = 1; j <= 4; j++) {
			int t_n, t_dir;
			cin >> t_n >> t_dir;
			board[i][j] = { t_n, t_dir };
			f[t_n] = { i, j, t_dir, false };
		}
	}
	int now_feed = 0;

	// ��� ����~!
	f[board[1][1].first].dead = true;
	now_feed += board[1][1].first;

	s = { 1, 1, board[1][1].second };
	board[1][1].first = -1;
	board[1][1].second = s.dir;

	dfs(now_feed);

	cout << ans;
}