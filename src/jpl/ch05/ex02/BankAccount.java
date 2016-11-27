
package jpl.ch05.ex02;

import java.util.*;

public class BankAccount {
    private long number;
    private long balance;
    private Action lastAct;
    private static History history; /* 処理のヒストリー */

    public class Action {

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
    }
    public History history() {
        return history;
    }
}
