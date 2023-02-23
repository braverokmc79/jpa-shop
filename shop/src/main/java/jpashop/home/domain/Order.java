package jpashop.home.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
	
	private Long memberId;
	
	private LocalDateTime orderDate;
	
	
	//ORDINAL 숫자 타입으로 하면 순서가 꼬이므로 무저건 String 한다
	@Enumerated(EnumType.STRING)
	private OrderStatus status;
	
	
	
}
