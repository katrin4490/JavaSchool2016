package ru.sbertech.homework.jee_jdbc;


public class Client {
    private long id;
    private String name;

    public Client(){
    }

    public Client(long id, String name, boolean isAddToDB){
        this.id = id;
        this.name = name;
        if (isAddToDB)
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

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
