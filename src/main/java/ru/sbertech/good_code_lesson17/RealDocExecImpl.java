package ru.sbertech.good_code_lesson17;

/**
 * Created by Student on 05.09.2016.
 */
public class RealDocExecImpl implements ExecBehavior {
    @Override
    public void exec(Document document) {
        document.getAccA().setSaldo(document.getAccA().getSaldo() - document.getSumma());
        document.getAccB().setSaldo(document.getAccB().getSaldo() + document.getSumma());
        System.out.println("from Account A to Account B: " + document.getSumma());
    }
}
