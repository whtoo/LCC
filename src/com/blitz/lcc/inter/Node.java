package com.blitz.lcc.inter;

import com.blitz.lcc.lexer.Lexer;

public class Node {
    int lexline = 0;
    int col = 0;
    Node() {
        lexline = Lexer.line;
        col = Lexer.col;
    }

    void error(String s) { throw new Error("near line"+lexline+",col"+col+": "+s);}
    static int labels = 0;
    public int newlabel() {return ++labels;}
    public void emitLabel(int i) { System.out.print("L"+i+":");}
    public void emit(String s) { System.out.println("\t"+s);}
}
