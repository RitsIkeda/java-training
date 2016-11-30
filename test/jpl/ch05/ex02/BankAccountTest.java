package jpl.ch05.ex02;

import static org.junit.Assert.*;
import org.junit.Test;

public class BankAccountTest {

    @Test
    public void test1 () {
        BankAccount account = new BankAccount();
        account.deposit(100);
        assertEquals(100,account.balance());
        account.withdraw(50);
        assertEquals(50,account.balance());
    }
    @Test
    public void test2 () {
        BankAccount bigAccount = new BankAccount();
        bigAccount.deposit(10000);
        BankAccount smallAccount = new BankAccount();
        smallAccount.deposit(10);

        smallAccount.transfer(bigAccount,10);
        assertEquals(20,smallAccount.balance());
        assertEquals(9990,bigAccount.balance());
    }
    @Test
    public void test3 () {
        BankAccount account = new BankAccount();
        BankAccount other = new BankAccount();

        account.deposit(1);
        account.withdraw(2);
        account.transfer(other,3);
        account.deposit(4);
        account.withdraw(5);
        account.transfer(other,6);
        account.deposit(7);
        account.withdraw(8);
        account.transfer(other,9);
        account.deposit(10);
        account.withdraw(11);

        assertEquals(11, account.history().getAction(0).amount() );
        assertEquals("withdraw", account.history().getAction(0).actName() );
        assertEquals(10, account.history().next().amount() );
        assertEquals("deposit", account.history().next().actName() );
        assertEquals(2, account.history().getAction(9).amount() );
        assertNull(account.history().getAction(10) );
    }


}
