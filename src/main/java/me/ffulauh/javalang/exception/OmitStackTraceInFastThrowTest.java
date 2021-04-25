package me.ffulauh.javalang.exception;

import java.util.concurrent.TimeUnit;

public class OmitStackTraceInFastThrowTest {
    public static void main(String[] args) throws InterruptedException {
        String test = null;
        int i = 0;
        while (true) {
            try {
                hehe();
            } catch (Exception e) {
                //TimeUnit.MILLISECONDS.sleep(1);
                e.printStackTrace();
            }
        }
    }

    private  static void hehe(){
        int a=3/0;
    }
}
