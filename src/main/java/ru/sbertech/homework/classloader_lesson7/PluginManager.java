package ru.sbertech.homework.classloader_lesson7;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PluginManager extends ClassLoader {
    private final String pluginRootDirectory;

    public PluginManager(String pluginRootDirectory) {
        this.pluginRootDirectory = pluginRootDirectory;
    }

    public IPlugin load(String pluginName, String pluginClassName) throws ClassNotFoundException {
        try {
            Path p = Paths.get(this.pluginRootDirectory);
            String path = (p.resolve(pluginName)).toString() + ".class";

            FileInputStream fin = new FileInputStream(path);
            byte[] bbuf = new byte[(int) (new File(path).length())];

            fin.read(bbuf);
            fin.close();
            Class c = defineClass(pluginClassName, bbuf, 0, bbuf.length);

            return (IPlugin) c.newInstance();
        } catch (IOException e) {
            e.printStackTrace();
            throw new ClassNotFoundException(e.getMessage(), e);
        }
         catch (IllegalAccessException | InstantiationException e) {
             e.printStackTrace();
        }
        return null;
    }
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        try {
            String fileClassName = name.substring(name.lastIndexOf(".") + 1) + ".class";
            Path p = Paths.get(this.pluginRootDirectory);
            String fileName = (p.resolve(fileClassName)).toString();
            File file = new File(fileName);
            if (!file.exists()){
                return super.findSystemClass(name);
            }
            FileInputStream fin = new FileInputStream(fileName);

            byte[] bbuf = new byte[(int) (new File(fileName).length())];

            fin.read(bbuf);

            fin.close();

            return defineClass(name, bbuf, 0, bbuf.length);
        } catch (IOException e) {
            e.printStackTrace();
            throw new ClassNotFoundException(e.getMessage(), e);
        }
    }
}
