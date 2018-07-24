package com.zy.shardingdb.datajpa.domain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
	
	@Query("select b from Order a,OrderItem b where b.orderId = a.orderId")
	List<OrderItem> findByOrderIdEq();

}
