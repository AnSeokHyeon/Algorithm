#include <iostream>
#include <queue>
#include <cstdio>
#include <vector>
#include <functional>
#include <deque>

using namespace std;

struct pos {
    int x;
    int y;
    int age;
    int year;
    pos(int year, int age, int x, int y) {
        this->year = year;
        this->age = age;
        this->x = x;
        this->y = y;
    }

    pos() {
        this->year = 0;
        this->age = 0;
        this->x = 0;
        this->y = 0;
    }
};
struct cmp {
    bool operator()(pos a, pos b) {
        if (a.year == b.year) {
            return a.age > b.age;
        }
        else
            return a.year > b.year;
    }
};
int dx[] = { 1,-1,0,0,1,1,-1,-1 };
int dy[] = { 0,0,1,-1,-1,1,1,-1 };
int A[11][11];
int map[11][11];
int chk[11][11];

int main(void) {
    int N, M, K;
    cin >> N >> M >> K;
    for (int i = 1; i <= N; i++) {
        for (int j = 1; j <= N; j++) {
            cin >> A[i][j];
            map[i][j] = 5;
        }
    }
    deque<pos> dq;
    for (int i = 0; i < M; i++) {
        int x, y, z;
        cin >> x >> y >> z;
        dq.push_back(pos(1,z, x, y));
    }
    int n = 1;
    while (K >= n) {
        //cout << n << "년 입니다@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@" << endl;
        queue<pos>fall;
        while (!dq.empty()) {
            pos f = dq.front();
            int x = f.x;
            int y = f.y;
            int age = f.age;
            int year = f.year;
            if (year > n) break;
            dq.pop_front();
            //cout << n << "년 " << x << " , " << y << " / " << age << " / " << year << endl;
            int food = map[x][y];
            if (age > food) {
                //cout << " 죽으러 감" << endl;
                chk[x][y] += int(age/2);
            }
            else
            {
                //cout << " 내년에 봅시다 " << endl;
                map[x][y] -= age;
                age++;
                year++;
                dq.push_back(pos(year,age, x, y));
                if (age % 5 == 0) {
                    fall.push(pos(year, age,x, y));
                }
            }

        }

        //while (!summer.empty()) {
        //   pos f = summer.front();
        //   summer.pop();
        //   int x = f.x;
        //   int y = f.y;
        //   int age = f.age;
        //   map[x][y] += age / 2;
        //}

        //cout << "여름이 지났습니다. " << endl;
        //for (int i = 1; i <= N; i++) {
        //   for (int j = 1; j <= N; j++) {
        //      printf("%3d", map[i][j]);
        //   }
        //   cout << endl;
        //}
        //cout << endl;

        while (!fall.empty()) {
           pos f = fall.front();
           fall.pop();
           int x = f.x;
           int y = f.y;
           int age = f.age;
           int year = f.year;

           for (int i = 0; i < 8; i++) {
              int mx = x + dx[i];
              int my = y + dy[i];

              if (mx > N || my > N || mx < 1 || my < 1) continue;
              dq.push_front(pos(year, 1, mx, my));

           }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                map[i][j] += chk[i][j];
                chk[i][j] = 0;
                map[i][j] += A[i][j];
            }
        }

        //cout << "겨울이 지났습니다. " << endl;
        //for (int i = 1; i <= N; i++) {
        //   for (int j = 1; j <= N; j++) {
        //      printf("%3d", map[i][j]);
        //   }
        //   cout << endl;

        //}
        //cout << endl;
        n++;
    }
    int result = dq.size();
    cout << result << endl;
}