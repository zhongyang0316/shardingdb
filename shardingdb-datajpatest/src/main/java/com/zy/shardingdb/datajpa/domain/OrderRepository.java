package com.zy.shardingdb.datajpa.domain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
	
	List<Order> findByUserIdIn(List<Integer> userIds);

}
