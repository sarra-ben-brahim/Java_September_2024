import java.util.ArrayList;

public class Order {

  private String name;
  private double total;
  private boolean ready;
  private ArrayList<Item> items;


  public Order() {
    // this.name = name;
    this.total = 0.0;
    this.ready = false;
    this.items = new ArrayList<Item>(); 
  }

  public Order(String guest) {
    this.name = guest;
    this.total = 0.0;
    this.ready = false;
    this.items = new ArrayList<Item>(); 
  }

  public void addItem(Item... items) {
    for (Item item : items) {
      this.items.add(item);
      this.total += item.getPrice();
    }
  }

  // getStatusMessage
  public String getStatusMessage() {
    return ready == true ? "hello " + name + ". Your order is ready."
        : "Thank you for waiting. Your order will be ready soon.";
  }

  // getOrderTotal
  public double getOrderTotal() {
    return this.total;
  }

  // Change the ready status
  public boolean isReady() {
    return ready = true;
  }

  // display order details
  public void display() {
    System.out.println("You order details:");
    System.out.println("Customer name: " + name);
    for (int i = 0; i < items.size(); i++) {
      System.out.println(items.get(i).getName() + "--" + items.get(i).getPrice());
    }
    System.out.println("total :" + total);
  }

}