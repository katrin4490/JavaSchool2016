package ru.sbertech.good_code_lesson17;

import java.util.concurrent.locks.Lock;

public class Document {

    private Client clientA;
    private Account accA;

    private Client clientB;
    private Account accB;

    private Long summa;

    private String user;


    public ExecBehavior getExecBehavior() {
        return execBehavior;
    }

    public void setExecBehavior(ExecBehavior execBehavior) {
        this.execBehavior = execBehavior;
    }

    private ExecBehavior execBehavior;
    public Document(ExecBehavior execBehavior) {
        this.execBehavior = execBehavior;
    }

    public Client getClientA() {
        return clientA;
    }

    public void setClientA(Client clientA) {
        this.clientA = clientA;
    }

    public Account getAccA() {
        return accA;
    }

    public void setAccA(Account accA) {
        this.accA = accA;
    }

    public Client getClientB() {
        return clientB;
    }

    public void setClientB(Client clientB) {
        this.clientB = clientB;
    }

    public Account getAccB() {
        return accB;
    }

    public void setAccB(Account accB) {
        this.accB = accB;
    }

    public Long getSumma() {
        return summa;
    }

    public void setSumma(Long summa) {
        this.summa = summa;
    }

    public void print(){
        System.out.println("summa: " + summa);
    }

    public void printUserInfo(){
        System.out.println("Document User: " + user);
    }

    public void savetoDB(){
        System.out.println("Save document in DataBase");
    }
}
