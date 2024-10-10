public class Item {
    
    private String name;
    private double price;
    private int index;

    public Item(String name, double price) {
      this.name = name;
      this.price = price;
      this.index += 1; 
    }
  
    public String getName() {
      return name;
    }
  
    public void addName(String name) {
      this.name = name;
    }
  
    public double getPrice() {
      return price;
    }
  
    public void addPrice(double price) {
      this.price = price;
    }
  
    public int getIndex() {
      return index;
    }
  
    public void addIndex() {
      this.index += 1;
    }
  
    public void setIndex(int index) {
      this.index = index;
    }
  
  }