package com.zy.shardingdb.datajpa.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "t_order_item")
@SuppressWarnings("serial")
public class OrderItem implements Serializable {
	
	@Id
    @Column(name = "order_item_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long orderItemId;
    
    @Column(name = "order_id")
    private long orderId;
    
    @Column(name = "user_id")
    private int userId;
    
    @Version
	@Column(name = "jpa_version", nullable = false)
	private Integer jpaVersion;
    
    public long getOrderItemId() {
        return orderItemId;
    }
    
    public void setOrderItemId(final long orderItemId) {
        this.orderItemId = orderItemId;
    }
    
    public long getOrderId() {
        return orderId;
    }
    
    public void setOrderId(final long orderId) {
        this.orderId = orderId;
    }
    
    public int getUserId() {
        return userId;
    }
    
    public void setUserId(final int userId) {
        this.userId = userId;
    }
    
    @Override
    public String toString() {
        return String.format("order_item_id: %s, order_id: %s, user_id: %s", orderItemId, orderId, userId);
    }

}
