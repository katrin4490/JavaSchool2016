package ru.sbertech.homework.patterns_lesson18.proxy;


public class ProxyImage implements IImage {

    private String source;
    private String dest;
    private Image image;

    public ProxyImage(String source, String dest) {
        this.source = source;
        this.dest = dest;
        this.image = null;
    }
    @Override
    public void show() throws InterruptedException {
        if (this.image == null){
            this.image = new Image(this.source, this.dest);
        }
        image.show();
    }
}
