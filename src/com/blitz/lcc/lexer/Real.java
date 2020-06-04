package com.blitz.lcc.lexer;

public class Real extends Token {
    public final float value;
    public Real(float v) { super(Tag.REAL);this.value = v;}

    @Override
    public String toString() {
        return ""+value;
    }
}
