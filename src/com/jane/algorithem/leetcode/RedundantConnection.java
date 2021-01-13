package com.jane.algorithem.leetcode;

public class RedundantConnection {

    public int[] findRedundantConnection(int[][] edges) {
        int len = edges.length;
        int[] fa = new int[len + 1];
        for(int i = 0 ; i < len ; i++){
            fa[i] = i;
        }
        for(int i = 0 ; i < len ; i++){
            int pa = find(edges[i][0],fa);
            int pb = find(edges[i][1],fa);
            if(pa == pb){
                if(edges[i][0] < edges[i][1]){
                    return new int[]{edges[i][0],edges[i][1]};
                }else{
                    return new int[]{edges[i][1],edges[i][0]};
                }
            }
            union(edges[i][0],edges[i][1],fa);
        }
        return new int[0];
    }

    private int find(int x, int[] fa){
        if(x==fa[x]){
            return x;
        }else{
            int pa = find(fa[x],fa);
            fa[x] = pa;
            return pa;
        }
    }

    private void union(int x,int y,int[] fa){
        int xp = find(x,fa);
        int yp = find(y,fa);
        fa[xp] = yp;
    }
}
