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
@Table(name = "t_order")
@SuppressWarnings("serial")
public class Order implements Serializable {
	
	@Id
    @Column(name = "order_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long orderId;
    
    @Column(name = "user_id")
    private int userId;
    
    @Column(name = "status")
    private String status;
    
    @Version
	@Column(name = "jpa_version", nullable = false)
	private Integer jpaVersion;

    
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
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(final String status) {
        this.status = status;
    }
    
    @Override
    public String toString() {
        return String.format("order_id: %s, user_id: %s, status: %s", orderId, userId, status);
    }

}
