package entity;

import java.math.BigDecimal;

import org.hibernate.annotations.Immutable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Immutable
@Table(name = "customer_order_summary")
public class CustomerOrderSummary {

    @Id
    @Column(name = "customer_id")
    private Long customerId;

    @Column(name = "customer_name")
    private String customerName;

    @Column(name = "total_orders")
    private Long totalOrders;

    @Column(name = "total_spent")
    private BigDecimal totalSpent;

    public CustomerOrderSummary() {}

	@Override
	public String toString() {
		return "CustomerOrderSummary [customerId=" + customerId + ",\t customerName=" + customerName + ",\t totalOrders="
				+ totalOrders + ",\t totalSpent=" + totalSpent + "]";
	}
    
}
