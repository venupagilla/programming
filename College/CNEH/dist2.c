#include <stdio.h>
#define MAX_NODES 20
#define INF 999

int dist[MAX_NODES][MAX_NODES];
int next[MAX_NODES][MAX_NODES];
int adj[MAX_NODES][MAX_NODES];
int n;

void init() {
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            if (i == j) {
                dist[i][j] = 0;
                next[i][j] = i;
            } else if (adj[i][j]) {
                dist[i][j] = 1;
                next[i][j] = j;
            } else {
                dist[i][j] = INF;
                next[i][j] = -1;
            }
        }
    }
}

int update() {
    int changed = 0;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            if (adj[i][j]) {
                for (int k = 0; k < n; k++) {
                    int newDist = dist[j][k] + 1;
                    if (newDist < dist[i][k]) {
                        dist[i][k] = newDist;
                        next[i][k] = j;
                        changed = 1;
                    }
                }
            }
        }
    }
    return changed;
}

void print() {
    for (int i = 0; i < n; i++) {
        printf("\nNode %d:\n", i);
        for (int j = 0; j < n; j++) {
            if (dist[i][j] == INF)
                printf("  %d: unreachable\n", j);
            else
                printf("  %d: hops=%d, next=%d\n", j, dist[i][j], next[i][j]);
        }
    }
}

int main() {
    printf("Nodes: ");
    scanf("%d", &n);
    
    printf("Matrix:\n");
    for (int i = 0; i < n; i++)
        for (int j = 0; j < n; j++)
            scanf("%d", &adj[i][j]);
    
    init();
    while (update());
    print();
    
    return 0;
}
