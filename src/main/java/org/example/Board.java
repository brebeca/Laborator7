package org.example;

import java.util.ArrayList;
import java.util.List;

public class Board {
    List<Token> tokens;
    int m;
    String winP=null;
    Board(int n)
    {
        tokens= new ArrayList<Token>();
        int i=1;
        while(i<=n)
        {
            tokens.add(new Token(i));
            i++;
        }
    }

    public synchronized Token giveTok(String name) {
        winP=name;
        if(winP!=null)
            return null;
        if(tokens.isEmpty()||tokens.size()==0)
            return null;
        Token toGive= tokens.get(0);
        tokens.remove(0);
        return toGive;
    }
}
