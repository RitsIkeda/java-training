package jpl.ch05.ex02;

import java.util.*;

public class BankAccount {
    private long number;
    private long balance;
    private Action lastAct;
    private History history = new History(); /* 処理のヒストリー */

    public class Action {
        private String act;
        private long amount;
        Action(String act, long amount) {
            this.act = act;
            this.amount = amount;
        }
        public String toString() {
            return number + ": " + act + " " + amount;
        }
        public String actName() {
            return act;
        }
        public long amount() {
            return amount;
        }

    }
    public void deposit(long amount) {
        balance += amount;
        lastAct = new Action("deposit",amount);
        history.addAction(lastAct);
    }
    public void withdraw(long amount) {
        balance -= amount;
        lastAct = new Action("withdraw",amount);
        history.addAction(lastAct);
    }
    public void transfer(BankAccount other, long amount) {
        other.withdraw(amount);
        deposit(amount);
        lastAct = this.new Action("transfer", amount);
        this.history.setAction(0, lastAct); /* widthdrawでプッシュされているものを上書き */
        other.lastAct = other.new Action("transfer", amount);
        other.history.setAction(0, other.lastAct);/* プッシュされているものを上書き */
    }
    public long balance() {
        return balance;
    }
    /* Actionをメンバとしてもつ BankAccount専用のヒストリークラスであるため、
      BankAccountのネストしたクラスで提供する。
      エンクロージングクラスにアクセスすることがないため、staticとする。
      */
     public static class History  {
        LinkedList <Action> actions = new LinkedList <Action>();
        private void addAction(Action action) {
            actions.push(action);
             if( actions.size() > 10) {
                 actions.pollLast();
             }
         }
         public Action getAction(int index) {
             if(index < 10) {
                 return actions.get(index);
             } else {
                 return null;
             }
         }
         public Action next() {
             return getAction(1);
         }
         public void setAction(int index, Action action) {
             actions.set(index,action);
         }
    }
    public History history() {
        return history;
    }
}
