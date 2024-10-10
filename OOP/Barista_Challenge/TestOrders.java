public class TestOrders {
	public static void main(String[] args) {
		Order order1 = new Order();
		Order order2 = new Order();

		Order order3 = new Order("Sarra");
		Order order4 = new Order("Nour");
		Order order5 = new Order("Oumayma");

		Item item1 = new Item("Capucchino", 12);
		Item item2 = new Item("Americano", 14);
		Item item3 = new Item("Espresso", 17);
		Item item4 = new Item("Flat White", 16);
		Item item5 = new Item("Latte", 18);

		order1.addItem(item1, item2, item3, item4);
		order3.addItem(item1, item1, item1);

		order4.addItem(item5, item4);
		order5.addItem(item1);
		order2.addItem(item3, item3);

		// Changing the status of the order
		order5.isReady();
		order4.isReady();

		// Status messages
		System.out.println(order1.getStatusMessage());
		System.out.println(order2.getStatusMessage());
		System.out.println(order3.getStatusMessage());
		System.out.println(order4.getStatusMessage());
		System.out.println(order5.getStatusMessage());

		// order total
		System.out.println(order5.getOrderTotal());
		System.out.println(order4.getOrderTotal());
		System.out.println(order3.getOrderTotal());
		System.out.println(order2.getOrderTotal());
		System.out.println(order1.getOrderTotal());

		// display method
		order1.display();
		order2.display();
		order3.display();
		order4.display();
		order5.display();

	}
}