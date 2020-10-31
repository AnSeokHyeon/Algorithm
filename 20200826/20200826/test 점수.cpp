#include <stdio.h>
#include <memory.h>
int N;
int score[100];
char Fscore[10001];
int id[10001];
int main()
{
    int T;
    scanf("%d", &T);
    for (int i = 0; i < T; i++)
    {
        scanf("%d", &N);
        for (int j = 0; j < N; j++)
        {
            scanf("%d", &score[j]);
        }
        id[1] = score[0];
        Fscore[score[0]] = 1;
        register int k, cur, a, aa;
        cur = 2;
        for (register int i = 1; i < N; i++)
        {
            k = 0;
            aa = score[i];
            for (register int j = 0; j < cur; j++)
            {
                a = aa + id[j];
                if (!(Fscore[a]))
                {
                    Fscore[a]++;
                    id[k + cur] = a;
                    k++;
                }
            }
            cur += k;
        }
        printf("#%d %d\n", i + 1, cur);
        for (int j = 0; j < cur; j++)
        {
            Fscore[id[j]] = 0;
            id[j] = 0;
        }
    }
    return 0;
}