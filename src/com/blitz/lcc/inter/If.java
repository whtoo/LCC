package com.blitz.lcc.inter;

import com.blitz.lcc.symbol.Type;

public class If extends Stmt {
    Expr expr; Stmt stmt;
    public If(Expr x,Stmt s) {
        expr = x;
        stmt = s;
        if(expr.type != Type.Bool) expr.error("boolean required in if");
    }

    public void gen(int b,int a) {
        int label = newlabel();
        expr.jumping(0,a);//stmt 的代码标号
        emitLabel(label);//为真时控制流穿越，为假时转向a
        stmt.gen(label,a);
    }
}
