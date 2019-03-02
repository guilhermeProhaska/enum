package entities;

public class OrderItem {

	private Integer quantity;
	private Double orderPrice;
	
	private Product product;
	
	public OrderItem() {
	}

	public OrderItem(Integer quantity, Double orderPrice, Product product) {
		this.quantity = quantity;
		this.orderPrice = orderPrice;
		this.product = product;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getOrderPrice() {
		return orderPrice;
	}

	public void setOrderPrice(Double orderPrice) {
		this.orderPrice = orderPrice;
	}
	
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Double subTotal() {
		return quantity * orderPrice;
	}
	
	public String toString() {
		return product.getName()
				+", $"
				+orderPrice
				+", Quantity: "
				+quantity
				+", Subtotal: $"
				+subTotal();
	}
}
