package com.blitz.lcc.inter;

import com.blitz.lcc.lexer.Token;
import com.blitz.lcc.symbol.Type;

public class Unary extends Op {
    public Expr expr;
    public Unary(Token tok, Expr x) {
        super(tok,null);
        type = Type.max(Type.Int,expr.type);
        if(type == null) error("type error");
    }
    public Expr gen() { return  new Unary(op,expr.reduce());}

    @Override
    public String toString() {
        return op.toString() + " " + expr.toString();
    }
}
