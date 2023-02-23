package jpashop.home.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="ORDERS")  //ORDER DB 에서 예약어로 사용되는 경우 많아서 ORDERS 
public class Order {
  
	@Id @GeneratedValue
	@Column(name="ORDER_ID")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="MEMBER_ID")
	private Member member;	
	
	
	@OneToOne
	@JoinColumn(name="DELIVERY_ID")
	private Delivery delivery;
	
	
	
	@OneToMany(mappedBy = "order")
	private List<OrderItem> orderItems=new ArrayList<>();
	
	
	private LocalDateTime orderDate;
	
	//ORDINAL 숫자 타입으로 하면 순서가 꼬이므로 무저건 String 한다
	@Enumerated(EnumType.STRING)
	private OrderStatus status;

	//양방향 연관 관계 설정
	public void addOrderItem(OrderItem orderItem) {
		orderItems.add(orderItem);
		orderItem.setOrder(this);
	}
	
	
	
}
