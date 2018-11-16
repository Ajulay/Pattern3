package com.ajulay;

public abstract class Handler {
    private Handler next;

    public void handle(Client client) {
        if(next != null)
            next.handle(client);
    }

    Handler link(Handler next) {
        this.next = next;
        return next;
    }
}
