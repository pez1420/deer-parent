package com.longlydeer.deer.common.entity;


import com.longlydeer.deer.common.annotation.Meaning;
import org.apache.commons.lang.builder.CompareToBuilder;


public abstract class OrderEntity extends BaseEntity implements
	Comparable<OrderEntity>{

	private static final long serialVersionUID = 9118161094390008961L;

	@Meaning("排序")
	private Integer orders;

	public Integer getOrders() {
		return orders;
	}

	public void setOrders(Integer orders) {
		this.orders = orders;
	}
	
	public int compareTo(OrderEntity orderEntity) {
		return new CompareToBuilder()
				.append(getOrders(), orderEntity.getOrders())
				.append(getId(), orderEntity.getId()).toComparison();
	}

}
