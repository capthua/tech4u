package me.ffulauh.cleancode.args;

public class Main {
    public static void main(String[] args) {
        try {
//            args: -l -p 8080 -d /usr/capthua
            Args arg=new Args("l,p#,d*",args);
            boolean logging=arg.getBoolean('l');
            int port=arg.getInt('p');
            String directory=arg.getString('d');
            System.out.println("logging:"+logging+", port:"+port+", directory:"+directory);
        } catch (ArgsException e) {
            System.out.printf("Argument error:%s\n",e.errorMessage());
        }
    }
}
