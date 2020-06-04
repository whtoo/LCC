package com.blitz.lcc.inter;

import com.blitz.lcc.lexer.Word;
import com.blitz.lcc.symbol.Type;

public class Temp extends Expr {
    static int count = 0;
    int number = 0;
    public Temp(Type p) {
        super(Word.temp,p);
        number=++count;
    }

    @Override
    public String toString() {
        return "t" + number;
    }
}
