package model;

public abstract class Person {
    private String name;

    public Person(String name){
        this.name = name;
    }

    public abstract void whoYouAre();

    //Getter
    public String getName(){
        return name;
    }

    //Setter
    public void setName(String name){
        this.name = name;
    }

}
