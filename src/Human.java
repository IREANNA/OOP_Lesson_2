public class Human extends Actor {


    public Human(){
        this.name = "Human";
        this.isMakeOrder = false;
        this.isTakeOrder = false;
        this.client = count++;
    }

    public Human(String name) {
        this.name = name;
        this.isMakeOrder = false;
        this.isTakeOrder = false;
        this.client = count++;
    }

    @Override
    public void setMakeOrder() {
        this.isMakeOrder = true;
    }

    @Override
    public void setTakeOrder() {
        this.isTakeOrder = true;
    }

    @Override
    public String toString() {
        return String.format("Клиент: " + name + ", Заказ принят: " + isMakeOrder + ", Заказ выдан " + isTakeOrder + ";");
    }

}