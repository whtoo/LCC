package com.blitz.lcc.inter;

import com.blitz.lcc.lexer.Word;
import com.blitz.lcc.symbol.Type;

public class Id extends Expr {
    public int offset;
    public Id(Word id, Type p,int b) { super(id,p);offset = b;}
}
