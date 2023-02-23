package jpashop.home.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Member {

	@Id @GeneratedValue
	@Column(name="MEMBER_ID")
	private Long id;
	private String name;
	private String city;
	private String street;
	private String zipcode;
	
	
	//mappedBy 는 연관 관계의 주인은 누구? member
	@OneToMany(mappedBy = "member")
	private List<Order> orderList=new ArrayList<>();
	
	
	
}
