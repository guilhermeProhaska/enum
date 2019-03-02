package aplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Enter client data:");
		System.out.print("Name: ");
		String clientName = sc.nextLine();
		System.out.print("Email: ");
		String clientEmail = sc.nextLine();
		System.out.print("Birth date (DD/MM/YYYY): ");
		Date clientDate = sdf.parse(sc.next());
		
		Client client = new Client(clientName, clientEmail, clientDate);
		
		System.out.println("Enter order data:");
		System.out.print("Status: ");
		sc.nextLine();
		String orderStatus = sc.nextLine();
		System.out.print("How many itens to this order? ");
		int orderItens = sc.nextInt();

		Date productDate = new Date();
		sdf.format(productDate);
		
		Order order = new Order(productDate, OrderStatus.valueOf(orderStatus), client);
		
		for(int i = 1; i <= orderItens; i++) {
			System.out.print("Enter #" + i + " item data:");
			System.out.println();
			System.out.print("Product name: ");
			sc.nextLine();
			String productName = sc.nextLine();
			System.out.print("Product price: ");
			double productPrice = sc.nextDouble();
			System.out.print("Quantity: ");
			int productQuantity = sc.nextInt();
		
			OrderItem itens = new OrderItem(productQuantity, productPrice, new Product(productName, productPrice));
			
			order.addItem(itens);
			}
		
		System.out.println();
		System.out.println(order);
		
		sc.close();
	}

}
