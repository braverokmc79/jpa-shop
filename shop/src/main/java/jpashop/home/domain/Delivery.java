package jpashop.home.domain;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Getter;

@Entity
@Getter
public class Delivery extends BaseEntity{
	
	@Id @GeneratedValue
	@Column(name="DELIVERY_ID")
	private Long id;

	@Embedded
	private Address address;
	private DeliveryStatus status;
	
	@OneToOne(mappedBy = "delivery" ,fetch = FetchType.LAZY)
	private Order order;
}
