package com.blitz.lcc.main;

import java.io.*;
import com.blitz.lcc.lexer.*;
import com.blitz.lcc.parser.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Lexer lex = new Lexer();
        Parser parse = new Parser(lex);
        parse.program();
        System.out.write('\n');
    }
}
