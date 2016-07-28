package ru.sbertech.reflection_lesson6;

import java.lang.reflect.Field;

/**
 * Created by Student on 28.07.2016.
 */
public class Test2 {
    public static void main(String[] args) {
       try {
           Field f = C.class.getDeclaredField("str");
           f.setAccessible(true);
           if (f.isAnnotationPresent(ValidLength.class)){
               System.out.println("Есть аннотация " + ValidLength.class.getTypeName());
               ValidLength vLen = f.getAnnotation(ValidLength.class);
               if (vLen.value() != ((String) f.get(C.class.newInstance())).length()){
                   System.out.println("Внимание длина некорректна");
               } else {
                   System.out.printf("ВСЕ ОК");
               }
           }
       } catch (NoSuchFieldException e){
           System.out.println("Нет поля: " + e.getMessage());
       } catch (InstantiationException e){
           System.out.println("Не можем создать экземпляр класса: " + e.getMessage());
       } catch (IllegalAccessException e){
           System.out.println("Доступ запрещен: " + e.getMessage());
       }
    }
}
