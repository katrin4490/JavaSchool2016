package ru.sbertech.collections_api_lesson3;

/**
 * Created by Student on 18.07.2016.
 */
public class Person{
    Long id;
    String name;
    String phoneNumber;

    public Person(Long id, String name, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String toString() {
        return "Person{id=" + this.getId() + "; name=" + this.getName() + "; phoneNumber=" + this.getPhoneNumber() + "}";
    }

    @Override
    public boolean equals(Object obj) {

        return this.getId().equals(((Person)obj).getId());

        //if (this == o) return true;
       // if (o == null || getClass() != o.getClass()) return false;

        //Person person = (Person) o;

        //if (id != null ? !id.equals(person.id) : person.id != null) return false;
       // if (name != null ? !name.equals(person.name) : person.name != null) return false;
       // return phoneNumber != null ? phoneNumber.equals(person.phoneNumber) : person.phoneNumber == null;

    }

}
