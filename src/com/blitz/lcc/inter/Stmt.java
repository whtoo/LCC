package com.blitz.lcc.inter;

public class Stmt extends Node {
    public Stmt() {}
    public static Stmt Null = new Stmt();

    /**
     * 生成三地址码入口
     * @param b 语句开始处的标号
     * @param a 下一条指令的标号
     */
    public void gen(int b,int a) {}
    int after = 0;
    public static Stmt Enclosing = Stmt.Null;//用于break
}
