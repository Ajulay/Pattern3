package com.ajulay;



public class ControlHandler extends Handler{
    private Client client;

    @Override
    public void handle(Client client) {
        if(this.client == client)
            System.out.println("Все мастера заняты. Выберите другое время или подождите.");
        else
            this.client = client;

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        super.handle(client);
    }
}
