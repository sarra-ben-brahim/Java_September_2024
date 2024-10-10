public class TestOrders {
    public static void main(String[] args) {
        
        Item item1 = new Item("mocha", 4.4); // item1
        Item item2 = new Item("lattee", 6); // item2
        Item item3 = new Item("drip coffee", 7); // item3
        Item item4 = new Item("cappuccino", 10); // item4

        Order order1 = new Order("Cindhuri");
        Order order2 = new Order("Jimmy");
        Order order3 = new Order("Noah");
        Order order4 = new Order("Sam");

        System.out.println(order1);

        System.out.println(order1.total);

        order2.items.add(item1);
        order2.total += item1.price;
        System.out.println(order2.name + "Your total is " + order2.total);

        order3.items.add(item4);
        order3.total += item3.price;
        System.out.println(order3.name + " Your total is " + order3.total);

        order4.items.add(item2);
        order4.total += item2.price;
        System.out.println(order4.name + " Your total is " + order4.total);

        order1.ready = true;
        if (order1.ready) {
            System.out.println("hey " + order1.name + " Your order is Ready!");
        } else {
            System.out.println("Sorry, Your order is not ready yet");
        }

        order4.items.add(item2);
        order4.items.add(item2);
        order4.total += item2.price;
        System.out.println(order4.name + " Your total is " + order4.total);

        order2.ready = true;
        if (order2.ready) {
            System.out.println("hey " + order2.name + " Your order is Ready!");
        } else {
            System.out.println("Sorry, Your order is not ready yet");
        }

    }
}