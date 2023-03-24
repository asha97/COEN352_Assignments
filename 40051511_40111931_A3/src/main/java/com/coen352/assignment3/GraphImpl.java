package com.coen352.assignment3;

public class GraphImpl implements Graph{

    protected static int def_size = 50;
    static final int UNVISITED = 0;
    static final int VISITED = 1;
    protected int[][] matrix;
    private int numEdge;
    public int[] Mark;

    public GraphImpl() {
    }
    public GraphImpl(int n) {                 // Constructor
        Init(n);
    }

    public void Init(int n) {
        Mark = new int[n];
        matrix = new int[n][n];
        numEdge = 0;
    }

    @Override
    public int n() {
        return Mark.length;
    }

    @Override
    public int e() {
        return numEdge;
    }

    @Override
    public int first(int v) {
        for (int i=0; i<Mark.length; i++)
            if (matrix[v][i] != 0) return i;
        return Mark.length;
    }

    @Override
    public int next(int v, int w) {
        for (int i=w+1; i<Mark.length; i++)
            if (matrix[v][i] != 0)
                return i;
        return Mark.length;
    }

    @Override
    public void setEdge(int i, int j, int wt) {
        assert wt!=0 : "Cannot set weight to 0";
        if (matrix[i][j] == 0) numEdge++;
        matrix[i][j] = wt;
    }

    @Override
    public void delEdge(int i, int j) {
        if (matrix[i][j] != 0) {
            matrix[i][j] = 0;
            numEdge--;
        }

    }

    @Override
    public boolean isEdge(int i, int j) {
        return matrix[i][j] != 0;
    }

    @Override
    public int weight(int i, int j) {
        if (i == j) return 0;
        if (matrix[i][j] == 0) return Integer.MAX_VALUE;
        return matrix[i][j];
    }

    @Override
    public void setMark(int v, int val) {
        Mark[v] = val;
    }

    @Override
    public int getMark(int v) {
        return Mark[v];
    }
}
