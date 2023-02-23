package jpashop.home.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Cartegory {
	
	@Id @GeneratedValue
	@Column(name="CARTEGORY_ID")
	private Long id;
	
	private String name;
	
	@ManyToOne
	@JoinColumn(name="PARENT_ID")
	private Cartegory parent;

	@OneToMany(mappedBy = "parent")
	private List<Cartegory> child=new ArrayList<>();
	
	
	@ManyToMany
	//중간 테이블 생성
	@JoinTable(name="CATEGORY_ITEM",
			joinColumns = @JoinColumn(name="CATEGOYR_ID"),
			inverseJoinColumns = @JoinColumn(name="ITEM_ID")
		)
	private List<Item> items=new ArrayList<>();
	
}
