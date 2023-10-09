import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Market implements QueueBehaviour, MarketBehaviour{
    List<Actor> clients;
    PriorityQueue<Actor> que;

    public Market(){
        this.clients = new ArrayList<>();
        this.que =new PriorityQueue<>();
    }

    @Override
    public void takeInQueue(Actor actor) {
        this.que.offer(actor);
        System.out.println(actor.getName() + " добавлен в очередь");
    }

    @Override
    public void takeOrders() {
        System.out.println("Клиент забрал заказ");
    }

    public void takeOrders(Actor actor) {
        actor.setTakeOrder();
        System.out.println(actor.getName()+ " изменил статус заказа");
    }

    @Override
    public void giveOrders() {
        System.out.println("Клиент забрал заказ");
    }

    public void giveOrders(Actor actor) {
        actor.setMakeOrder();
        System.out.println(actor.getName() + " изменил статус заказа");
    }

    @Override
    public void releaseFromQueue() {
        System.out.println("Готов заказ клиента " + this.que.remove().getName());
    }

    public void releaseFromQueue(Actor actor) {
        this.que.remove(actor);
        System.out.println(actor.getName() + " покинул очередь");
    }

    @Override
    public void acceptToMarket(Actor actor) {
        this.clients.add(actor);
        System.out.println(actor.getName() + " посетил магазин");
    }

    @Override
    public void releaseFromMarket(List<Actor> actors) {
        this.clients.removeAll(actors);
    }

    public void releaseFromMarket(Actor actor) {
        this.clients.remove(actor);
        System.out.println(actor.getName() + " покинул магазин");
    }

    @Override
    public void update() {
    }

    public void update(Actor actor) {
        acceptToMarket(actor);
        System.out.println(this.clients);
        giveOrders(actor);
        takeInQueue(actor);
        takeOrders(actor);
        System.out.println(this.clients);
        releaseFromQueue(actor);
        releaseFromMarket(actor);
        System.out.println(this.clients);
    }

    @Override
    public String toString() {
        return String.format("Посетители: " + clients + "Очередь: " + que);
    }
}