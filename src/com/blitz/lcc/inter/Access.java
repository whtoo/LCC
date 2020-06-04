package com.blitz.lcc.inter;

import com.blitz.lcc.lexer.Tag;
import com.blitz.lcc.lexer.Word;
import com.blitz.lcc.symbol.Type;

public class Access extends Op {
    public Id array;
    public Expr index;
    public Access(Id a, Expr i, Type p) {
        super(new Word("[]", Tag.INDEX),p);
        array = a;
        index = i;
    }

    public Expr gen() {
        return new Access(array,index.reduce(),type);
    }

    @Override
    public void jumping(int t, int f) {
        emitjumps(reduce().toString(),t,f);
    }

    @Override
    public String toString() {
        return array.toString() + " [ "+index.toString() + " ] ";
    }
}
