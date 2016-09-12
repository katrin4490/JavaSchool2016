package ru.sbertech.patterns_lesson18_19.observer;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        MeteoStation meteo = new MeteoStation();
        Observer cons = new ConsoleObserver();

        meteo.addObserver(cons);
        meteo.setData(30, 750);
    }
}

interface Observable {
    void notifyObservers(int temperature, int pressure);
    void addObserver(Observer o);
    void removeObserver(Observer o);
}

interface Observer {
    void  onChange(int temperature, int pressure);
}

class  MeteoStation implements Observable{
    List<Observer> observers = new ArrayList<>();
    int temperature;
    int pressure;

    public void setData(int temperature, int pressure){
        this.temperature = temperature;
        this.pressure = pressure;
        notifyObservers(temperature, pressure);
    }

    @Override
    public void notifyObservers(int temperature, int pressure) {
        for (Observer observer: observers){
            observer.onChange(temperature, pressure);
        }
    }

    @Override
    public void addObserver(Observer o) {
        this.observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        this.observers.remove(o);
    }
}

class  ConsoleObserver implements Observer {

    @Override
    public void onChange(int temperature, int pressure) {
        System.out.println("Temp: " + temperature + "; pressure: " + pressure);
    }
}

//class  FileObserver implements  Observer {
//
//    @Override
//    public void onChange(int temperature, int pressure) {
//        try(PrintWriter writer = new PrintWriter())
//        System.out.println("Temp: " + temperature + "; pressure: " + pressure);
//    }
//}