package ru.sbertech.exception_lesson5;

class Ok implements AutoCloseable{

    private String message;
    public  Ok(String message){
        this.message=message;
        System.err.println("I'm message " + message);
    }

    @Override
    public void close() throws Exception {
        System.err.println("Все ресурсы освобождены " + message);
    }
}
class FailCreated implements AutoCloseable{

    private String message;
    public  FailCreated(String message){
        this.message=message;
        System.err.println("I'm message " + message);
        throw  new NullPointerException();
    }

    @Override
    public void close() throws Exception {
        System.err.println("Все ресурсы освобождены " + message);
    }
}

class FailClose implements AutoCloseable{

    private String message;
    public  FailClose(String message){
        this.message=message;
        System.err.println("I'm created " + message);
    }

    @Override
    public void close() throws Exception {
        throw  new NullPointerException();
    }
}

public class MyAutoclosable {
    public static void main(String[] args) throws Exception{
        try (FailClose x = new FailClose("x");
             FailClose y = new FailClose("y") ){
            throw new Error();

            //System.err.println("Business logic");
        }
    }
}
