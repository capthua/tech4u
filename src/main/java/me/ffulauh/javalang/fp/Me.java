package me.ffulauh.javalang.fp;

public class Me {
    private String name;
    private Integer age;

    public void printMe(Me me){
        System.out.println(me.toString());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Me{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public Me(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}
