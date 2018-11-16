package com.ajulay;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        Handler handler = new ControlHandler();
        NailMaster[] masters = {new NailMaster("Юлия"), new NailMaster("Марина"), new NailMaster("Ольга")};
        Handler tmp = handler;
        for (int i = 0; i < masters.length; i++) {
            tmp = tmp.link(masters[i]);
//            if(i%2!=0){
//                masters[i].setBusy(true);
//            }

        }
                tmp.link(handler);


        for (int i = 0;i<10;i++) {
            System.out.println("Новый клиент...");
            try {
                Thread.sleep(800);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            final int temp = i;
            handler.handle(new Client() {

                @Override
                public String getName() {
                    return Integer.toString(temp);
                }
            });

        }

    }
}
