import org.example.Bank;
import org.example.Expression;
import org.example.Money;
import org.example.Sum;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MoneyTest {

    @Test
    @DisplayName("$5 X 2 = $10")
    void testMultiplication(){

        Money fiveUSD = Money.dollar(5);
        assertEquals(Money.dollar(10), fiveUSD.times(2));
        assertEquals(Money.dollar(15), fiveUSD.times(3));

        Money fiveCHF = Money.frac(5);
        assertEquals(Money.frac(10), fiveCHF.times(2));
        assertEquals(Money.frac(15), fiveCHF.times(3));

    }

    @Test
    @DisplayName("equals() ")
    void testEquality(){

        Assertions.assertTrue(Money.dollar(5).equals(Money.dollar(5)));
        Assertions.assertTrue(Money.frac(5).equals(Money.frac(5)));
        Assertions.assertFalse(Money.dollar(5).equals(Money.dollar(6)));
        Assertions.assertFalse(Money.dollar(5).equals(Money.frac(5)));
    }

    @Test
    @DisplayName("통화 ")
    void testCurrency(){

        assertEquals("USD",Money.dollar(5).currency());
        assertEquals("CHF",Money.frac(5).currency());
    }

    @Test
    @DisplayName("Sum.plus")
    void testPlusReturnSum(){
        Money five = Money.dollar(5);

        // Map m = new HashMap<>() 과 같은 스타일임
        Expression result = five.plus(five);

        Sum sum = (Sum) result;

        assertEquals(five, sum.addend);
        assertEquals(five, sum.addend);
    }

    @Test
    @DisplayName("$5 + $5에서 Money 반환하기")
    void testReduceSum(){

        Expression sum = new Sum(Money.dollar(5), Money.dollar(4));
        Bank bank = new Bank();

        Money result = bank.reduce(sum, "USD");
        assertEquals(Money.dollar(9), result );

    }


}
