package org.example;

public class Bank {

    public Money reduce(Expression source, String to){

        return source.reduce(this,to);



    }


}
