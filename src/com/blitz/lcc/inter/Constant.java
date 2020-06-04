package com.blitz.lcc.inter;

import com.blitz.lcc.inter.Expr;
import com.blitz.lcc.lexer.Num;
import com.blitz.lcc.lexer.Token;
import com.blitz.lcc.lexer.Word;
import com.blitz.lcc.symbol.Type;

public class Constant extends Expr {
    public Constant(Token tok, Type p) { super(tok,p);}
    public Constant(int i) { super(new Num(i),Type.Int);}
    public static final Constant
    True = new Constant(Word.True,Type.Bool),
    False = new Constant(Word.False,Type.Bool);

    public void jumping(int t,int f){
        if(this == True && t != 0) emit("goto L" + t);
        else if(this == False && f != 0) emit("goto L"+f);
    }
}
