#include <iostream>
#include <algorithm>
#include <math.h>

using namespace std;
bool visited[100] = { false };
int chk[100] = {};
int N, M;
void find(int n, int count) {
    if (count == M) {
        for (int i = 0; i < M; i++) {
            cout << chk[i] << " ";
        }
        cout << endl;
        return;
    }

    for (int i = n; i <N; i++) {
        if (visited[i] == true) continue;
        visited[i] = true;
        chk[count] = i + 1;
        find(i + 1, count + 1);
        visited[i] = false;
    }
}
int main(void) {
    while (cin >> N >> M) {
        find(0, 0);
    }
}