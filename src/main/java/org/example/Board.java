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

    /**
     * ofera pereu rokenul de pe pozitia 0 apoi il sterge
     * atunci cand primeste un numa anuta castigatorul
     * atunci cand nu mai are tokenuri anunta ca nu a castigat nimeni
     * @param name atunci cand un castigator are o progresie aritm. apeleaza fuxntia cu numele sau transmitand astfel ca a "castigat"
     * @return null -> atunci cand nu mai sunt tokenuri sau cand variabila winP nu mai e numa( s a anuntat un castigator)
     */
    public synchronized Token giveTok(String name) {
        if(winP!=null)
            return null;
        if(name!= null)
        {
            winP=name;
            System.out.println("Castiga: "+winP);
            return null;
        }
        if(tokens.isEmpty()||tokens.size()==0){
            System.out.println("Nu castinga nimeni. S au terminat tokenurile");
            return null;
        }
        Token toGive= tokens.get(0);
        tokens.remove(0);
        return toGive;
    }
}
