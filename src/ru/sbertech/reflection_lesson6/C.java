package ru.sbertech.reflection_lesson6;


public class C extends B implements I{
   // private final Object aC;
   @ValidLength(5)
   private String  str = "first";

    public B bc;


    public C(){
        //aC = new A();
       // str = "first";
    }

    @Override
    public void someMethod(String param){
        System.out.println(str + " " + param);
    }
}
