package ru.sbertech.homework.classloader_lesson7;

public class Main {
    public static void main(String[] args) {
        try {

            IPlugin plugin1 = new Plugin1();
            plugin1.doUsefull();


            PluginManager pluginManager = new PluginManager("plugins\\Plugin1");
            IPlugin newPl = pluginManager.load("Plugin1", "ru.sbertech.homework.classloader_lesson7.Plugin1");
            newPl.doUsefull();

            IPlugin plugin2 = new Plugin1();
            plugin2.doUsefull();

            PluginManager pluginManager2 = new PluginManager("plugins\\Plugin2");
            IPlugin newPl2 = pluginManager2.load("Plugin1", "ru.sbertech.homework.classloader_lesson7.Plugin1");
            newPl2.doUsefull();

        } catch (Exception e){
            System.out.println("Error " + e.getMessage());
        }
    }
}
