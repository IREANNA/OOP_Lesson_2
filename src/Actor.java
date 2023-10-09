public abstract class Actor implements ActorBehavior, Comparable<Actor> {
    protected String name;
    protected boolean isMakeOrder;
    protected boolean isTakeOrder;
    static int count;
    protected int client;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getClient() {
        return client;
    }

    @Override
    public boolean isMakeOrder() {
        return isMakeOrder;
    }

    public void setMakeOrder(boolean makeOrder) {
        isMakeOrder = makeOrder;
    }

    @Override
    public boolean isTakeOrder() {
        return isTakeOrder;
    }

    public void setTakeOrder(boolean takeOrder) {
        isTakeOrder = takeOrder;
    }

    @Override
    public int compareTo(Actor o) {
        return this.client - o.getClient();
    }
}