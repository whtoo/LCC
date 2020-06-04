package com.blitz.lcc.symbol;

import com.blitz.lcc.inter.Id;
import com.blitz.lcc.lexer.Token;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class Env {
    private Map<Token, Id> table;
    protected Env prev;

    protected Env(Env n) { table = new Hashtable(); prev = n;}
    public void put(Token w,Id id) { table.put(w,id);}
    public Id get(Token w) {
        for(Env e = this; e != null; e = e.prev){
            Id found = (Id)(e.table.get(w));
            if(found != null) return found;
        }
        return null;
    }
}
