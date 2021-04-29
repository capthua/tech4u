package me.ffulauh.javalang.classloader;

public class ClassForNameDemo {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class<Han> clazz = (Class<Han>) Class.forName("me.ffulauh.javalang.classloader.Han",false
                ,Thread.currentThread().getContextClassLoader());
        Han han = clazz.newInstance();
    }

}

class Han {

    static {
        System.out.println("静态块");
    }

    private int age;
    private String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
