package org.example;

import java.util.ArrayList;
import java.util.List;

public class Game {
    Board board;
    List<Player> players;
    Game(int n, int nrPlayers , List<String> names,int k){
        players= new ArrayList<Player>();
        board=new Board(n);
        for(String name: names){
            Runnable newP=new Player(name,board,k);
            players.add((Player) newP);
        }

    }
    public void startGame(){

        new Thread(players.get(0)).start();
        new Thread(players.get(1)).start();
        if(board.winP!=null)
            System.out.println("A castigat "+ board.winP);
        else System.out.println("Nu a castigat nimeni");
    }
}
