package org.example;

public class Token {
    Integer number;
    public Token(Integer number) {
        this.number = number;
    }

    public Token() {
        number= new Integer(null);

    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}
