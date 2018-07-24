package com.zy.shardingdb.datajpa;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.zy.shardingdb.datajpa.domain.Order;
import com.zy.shardingdb.datajpa.domain.OrderItem;
import com.zy.shardingdb.datajpa.domain.OrderItemRepository;
import com.zy.shardingdb.datajpa.domain.OrderRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShardingDbDataJpaApplicationTests {
	
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private OrderItemRepository orderItemRepository;
	
	@Test
	public void contextLoads() {
		this.logger.info("只是测试。。。。");
		
		for (int i = 1; i < 11; i ++) {
			Order order = new Order();
			order.setStatus("Finish");
			order.setUserId(i);
			order = this.orderRepository.save(order);
			
			OrderItem orderItem = new OrderItem();
			orderItem.setOrderId(order.getOrderId());
			orderItem.setUserId(i);
			orderItem = this.orderItemRepository.save(orderItem);
			
		}
		
		List<Order> orders = this.orderRepository.findAll();
		this.logger.info("orders:{}", orders);
		List<OrderItem> orderItems = this.orderItemRepository.findAll();
		this.logger.info("orderItems:{}", orderItems);
		
		//In测试
		List<Integer> userIds = new ArrayList<>();
		userIds.add(1);
		userIds.add(7);
		userIds.add(2);
		userIds.add(8);
		List<Order> ordersIn = this.orderRepository.findByUserIdIn(userIds);
		this.logger.info("ordersIn:{}", ordersIn);
		
		this.orderRepository.delete(ordersIn);
		
		//两表关联查询
		List<OrderItem> orderItemsEq = this.orderItemRepository.findByOrderIdEq();
		this.logger.info("orderItemsEq:{}", orderItemsEq);
		
		this.orderRepository.deleteAll();
		this.orderItemRepository.deleteAll();
		
	}

}
