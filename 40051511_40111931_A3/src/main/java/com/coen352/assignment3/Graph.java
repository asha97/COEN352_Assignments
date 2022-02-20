package com.coen352.assignment3;

public interface Graph {
    public void Init(int n);
    public int n();
    public int e();
    public int first(int v);
    public int next(int v, int w);
    public void setEdge(int i, int j, int wght);
    public void delEdge(int i, int j);
    public boolean isEdge(int i, int j);
    public int weight(int i, int j);
    public void setMark(int v, int val);
    public int getMark(int v);
}
