#include <string>
#include <iostream>
#include <vector>

using namespace std;
int chk[31][31] = {};
bool result = true;
void block(int m, int n, vector<string> board) {
    char a = board[m][n];
    char b = board[m + 1][n + 1];
    char c = board[m + 1][n];
    char d = board[m][n + 1];
    if (a == b) {
        if (b == c) {
            if (c == d) {
                chk[m][n] = 1;
                chk[m + 1][n + 1] = 1;
                chk[m][n + 1] = 1;
                chk[m + 1][n] = 1;
                result = false;
            }
        }
    }
}
int solution(int m, int n, vector<string> board) {
    int answer = 0;
    while (1) {
        result = true;
        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (board[i][j] == '0') continue;
                block(i, j, board);
                for (int k = 0; k < m; k++) {
                    for (int l = 0; l < n; l++) {
                    }
                    cout << endl;
                }
            }
        }

        if (result == true) break;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (chk[i][j] > 0) {
                    board[i][j] = '0';
                    chk[i][j] = 0;
                    answer++;
                }
            }
        }
        for (int j = 0; j < n; j++) {
            for (int i = m - 1; i > -1; i--) {
                if (board[i][j] == '0') continue;
                for (int k = m - 1; k > i; k--) {
                    if (board[k][j] == '0') {
                        char temp = board[k][j];
                        board[k][j] = board[i][j];
                        board[i][j] = temp;
                        break;
                    }
                }
            }
        }
    }
    return answer;
}