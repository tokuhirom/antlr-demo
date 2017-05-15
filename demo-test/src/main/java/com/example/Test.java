package com.example;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.IOException;
import java.util.List;

public class Test {
    public static void main(String[] args) throws IOException {
//        new org.antlr.runtime.ANTLRFileStream()
        ExprLexer lexer = new ExprLexer(CharStreams.fromString("3+2*4"));
        CommonTokenStream stream = new CommonTokenStream(lexer);
        ExprParser exprParser = new ExprParser(stream);
        ExprParser.ExprContext expr = exprParser.expr();
        System.out.println("toInfoString : " + expr.toInfoString(exprParser));
        System.out.println("toString : " + expr.toString());
        System.out.println("toStringTree : " + expr.toStringTree());
        System.out.println("\n");

        List<ExprParser.TermContext> term = expr.term();
        System.out.println(term.get(0).factor(0).INT());

        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(new ExprBaseListener(), expr);
    }
}
