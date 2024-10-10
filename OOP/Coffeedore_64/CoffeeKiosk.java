import java.util.ArrayList;

class CoffeeKiosk {

    private ArrayList<Item> menu;
    private ArrayList<Order> orders;

    // Counstructor
    public CoffeeKiosk() {
        this.menu = new ArrayList<Item>(); // defaults to null
        this.orders = new ArrayList<Order>(); // defaults to null
    }

    // Methods
    // addMenuItem:
    public void addMenuItem(double price, String name) {
        Item newItem = new Item(name, price); 
        newItem.setIndex(menu.indexOf(newItem));
        menu.add(newItem); 

    }


    public void displayMenu() {
        System.out.println("\n");
        for (int i = 0; i < menu.size(); i++) {
            System.out.println(i + ":" + menu.get(i).getName() + "--" + menu.get(i).getPrice());

        }
    }

    // newOrder method

    public void newOrder() {

        System.out.println("Please enter customer name for new order:");
        String name = System.console().readLine();

      
        Order newOrder = new Order(name);

        displayMenu();
        System.out.println("Please enter a menu item index or q to quit:");
        String itemNumber = System.console().readLine();

        while (!itemNumber.equals("q")) {
            Item item = menu.get(Integer.parseInt(itemNumber));
            newOrder.addItem(item);
            System.out.println("You have just added: " + item.getName() + " To Your list");
            System.out
                    .println("If you'd like to continoue your orders, please press a number from the menu , or enter q to end");
            displayMenu();
            itemNumber = System.console().readLine();

        }

        newOrder.display();
    }

}