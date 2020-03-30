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

    /**
     * se porneste executia firelor de executie pentru fiecare jucator
     * se verifica la safarsit daca s a inregistrat vreun castigator in variabila winP din board(resursa partajata a thredurilor)
     * sau e remiza
     */
    public void startGame(){
        for(Player player: players)
        new Thread(player).start();

    }
}
