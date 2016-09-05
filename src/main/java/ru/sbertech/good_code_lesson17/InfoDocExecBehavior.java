package ru.sbertech.good_code_lesson17;

/**
 * Created by Student on 05.09.2016.
 */
public class InfoDocExecBehavior implements ExecBehavior {
    @Override
    public void exec(Document document) {
        System.out.println("This is InfoDoc");
    }
}
