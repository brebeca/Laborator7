package org.example;

import java.util.*;

public class Player implements Runnable {
    String name;
    Board board;
    int k;
    List<Token> myTokens;
    Player(String name,Board b, int k)
    {
        board=b;
        this.name=name;
        myTokens=new ArrayList<Token>();
        this.k=k;
    }
    public void run() {

        while(true){
            Token tok=board.giveTok(null);
            if(tok==null){
                System.exit(0);
            }
            myTokens.add(tok);
            if(arithmP() ){
                System.out.println("player: "+name);
                /*for(Token token:myTokens)
                {
                    System.out.print(token.number+" ,");
                }*/
                System.exit(1);
            }


        }
    }


    boolean arithmP()
    {
        if(myTokens.size()<3)
            return false;
        Collections.sort(myTokens,new NumberComp());
        int d =  myTokens.get(1).number-myTokens.get(0).number;
        for (int i = 2; i <myTokens.size()-1 ; i++)
            if (myTokens.get(i).number-myTokens.get(i-1).number != d)
                return false;

        return true;
    }

}
class NumberComp implements Comparator<Token>
{
    public int compare(Token m1, Token m2)
    {
        if (m1.number < m2.number) return -1;
        if (m1.number > m2.number) return 1;
        else return 0;
    }
}