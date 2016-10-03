package ru.sbertech.homework.jee_jdbc;


public class Client {
    private long id;
    private String name;

    public Client(long id, String name){
        this.id = id;
        this.name = name;
        this.insertToDataBase();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean insertToDataBase(){
        return DataConnection.insertClient(getId(), getName());
    }
    public boolean saveUpdateToDataBase(){
        return DataConnection.updateClient(getName());
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
