package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {
	
	private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	private Date moment;
	private OrderStatus status;
	
	private List<OrderItem> itens = new ArrayList<>();
	private Client client;
	
	public Order() {
	}

	public Order(Date moment, OrderStatus status, Client client) {
		this.moment = moment;
		this.status = status;
		this.client = client;
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	public List<OrderItem> getItem() {
		return itens;
	}

	public void addItem(OrderItem item) {
		itens.add(item);
	}
	
	public void removeItem(OrderItem item) {
		itens.remove(item);
	}
	
	public Double total() {
		double sum = 0.00;
		
		for (OrderItem i : itens) {
			sum += i.subTotal();
		}
		return sum;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		 sb.append("ORDER SUMMARY:" + "\n");
		 sb.append("Order moment: ");
		 sb.append(sdf.format(moment) + "\n");
		 sb.append("Order status: ");
		 sb.append(status + "\n");
		 sb.append("Client: ");
		 sb.append(client.toString() + "\n");
		 sb.append("Order Itens:" + "\n");
		 for (OrderItem o : itens) {
			 sb.append(o + "\n");
			}		
		sb.append("Total price: $");
		sb.append(total());
		return sb.toString();
	}
	
}
