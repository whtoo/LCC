package com.blitz.lcc.inter;

public class Stmt extends Node {
    public Stmt() {}
    public static Stmt Null = new Stmt();
    public void gen(int a,int b) {} //调用是参数是语句开始处的标号和下一条指令的标号
    int after = 0;
    public static Stmt Enclosing = Stmt.Null;//用于break
}
