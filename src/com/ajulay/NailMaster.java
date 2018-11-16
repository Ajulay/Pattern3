package com.ajulay;

import java.util.Random;

public class NailMaster extends Handler{
    private String name;
    private boolean busy;

    @Override
    public void handle(Client client) {
        if(isBusy()) {
            System.out.printf("Мастер %s занята\n", name);
            super.handle(client);
        }
        else {
            System.out.printf("Мастер %s работает с клиентом %s\n",
                    name, client.getName());
            setBusy(true);
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(4000);
                        setBusy(false);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }




    public NailMaster(String name) {
        this.name = name;
    }

    public boolean isBusy() {
        return busy;
    }

    public void setBusy(boolean busy) {
        this.busy = busy;
    }

}
