package com.blitz.lcc.lexer;
import java.io.*;
import java.util.*;
import com.blitz.lcc.symbol.*;

public class Lexer {
    public static int line = 1;
    char peek = ' ';
    Map<String,Word> words = new Hashtable();
    void reserve(Word w) {words.put(w.lexeme,w);}

    public Lexer() {
        reserve(new Word("if", Tag.IF));
        reserve(new Word("else",Tag.ELSE));
        reserve(new Word("while",Tag.WHILE));
        reserve(new Word("do",Tag.DO));
        reserve(new Word("break",Tag.BREAK));
        reserve(Word.True);
        reserve(Word.False);
        reserve(Type.Int);
        reserve(Type.Char);
        reserve(Type.Bool);
        reserve(Type.Float);
    }
    /* 从输入缓冲区读入一个字符 */
    void readch() throws IOException { peek = (char)System.in.read();}
    /* 将输入缓冲区读入的字符和当前传入字符做比较 */
    boolean readch(char c) throws IOException {
        readch();
        if(peek != c ) return false;
        peek = ' ';
        return true;
    }

    public Token scan() throws IOException {
        for(;;readch()){
            if(peek == ' ' || peek == '\t') continue;
            else if(peek == '\n') line += 1;
            else break;
        }
        switch (peek){
            case '&':
                if(readch('&')) return Word.and; else new Token('&');
            case '|':
                if (readch('|')) return Word.or; else  new Token('|');
            case '=':
                if(readch('=')) return Word.eq; else new Token('=');
            case '!':
                if(readch('=')) return Word.ne; else new Token('!');
            case '<':
                if(readch('=')) return Word.le; else new Token('<');
            case '>':
                if(readch('=')) return Word.ge; else new Token('>');
        }
        /*数字的字符串转换*/
        if(Character.isDigit(peek)){
            int v = 0;
            /*整数的字符串转换*/
            do{
                v = 10 * v + Character.digit(peek,10);readch();
            } while (Character.isDigit(peek));
            if(peek != '.') return new Num(v);
            float x = v; float d = 10;
            /*浮点数的字符串转换*/
            for (;;){
                readch();
                if(!Character.isDigit(peek)) break;
                x = x + Character.digit(peek,10) / d; d = d*10;
            }
            return new Real(x);
        }
        /* 如果是ID类型，先判断是否和保留关键字相同，
        *  则认为是关键字；否则，将该字符串写入保留关键字表，
        *  然后返回。
        * */
        if (Character.isLetter(peek)){
            StringBuffer b = new StringBuffer();
            do {
                b.append(peek);readch();

            }while (Character.isLetterOrDigit(peek));
            String s = b.toString();
            Word w = words.get(s);
            if(w != null) return w;
            w = new Word(s,Tag.ID);
            words.put(s,w);
            return w;
        }

        Token tok = new Token(peek); peek = ' ';
        return tok;
    }
}
