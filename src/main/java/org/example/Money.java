package org.example;

import java.util.Objects;

public class Money implements Expression {

    protected int amount;
    protected String currency;

    public Money(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public static Money dollar(int amount){
        return new Money(amount,"USD");
    }

    public static Money frac(int amount){
        return new Money(amount,"CHF");
    }

    public String currency(){
        return currency;
    }

    @Override
    public Money reduce(Bank bank, String to) {
        return new Money(amount, to);
    }



    @Override
    public Expression plus(Expression addend) {
        return new Sum(this,addend);
    }

    public Expression times(int multiplier){
        return new Money(amount*multiplier, currency);
    }



    // 속성값 비교를 통한 동등성 비교
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return amount == money.amount && Objects.equals(currency, money.currency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, currency);
    }

    @Override
    public String toString() {
        return amount + " " + currency;
    }
}
