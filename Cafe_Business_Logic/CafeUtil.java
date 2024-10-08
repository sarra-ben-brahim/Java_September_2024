import java.util.ArrayList;

public class CafeUtil {


    int getStreakGoal() {
        int numWeeks = 10;
        int sum = 0;

        for (int i = 0; i <= numWeeks; i++){
            sum += i;
        }
         return sum;
    }

    double getOrderTotal(double[] prices){
        double sumPrice = 0;
        for (int i = 0; i < prices.length; i++){
            sumPrice += prices[i];
        }
        return sumPrice;
    }

    void displayMenu(ArrayList<String> menuItems){
        for (int i = 0; i < menuItems.size(); i++){
            System.out.println(i +" "+ menuItems.get(i));
        }
    }

    void addCustomer(ArrayList<String> customers){
        System.out.println("Please enter your name:");
        String username = System.console().readLine();
        System.out.println("Hello, "+ username+"!");
        customers.add(username);

    }

    void printPriceChart(String product, double price, int maxQuantity){
        System.out.println(product);
        for (int i = 1; i <= maxQuantity; i++){
            System.out.println(price*i);

        }

    }











}