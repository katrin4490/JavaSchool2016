package ru.sbertech.exception_lesson5;


class Engine {
    void startEngine(){
        System.out.println("Engine start");
    }
}

class Vehicle {

    private Engine engine;
    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public  void StartEngine() {
        engine.startEngine();
    }
}

public class NPETest {
    public static void main (String[] args) {
        Engine engine = new Engine();
        Vehicle car = new Vehicle();
        car.setEngine(engine);

        Vehicle bike = new Vehicle();
        bike.setEngine(engine);

        car.StartEngine();
        bike.StartEngine();

        System.out.println("All engine starts");
    }
}
