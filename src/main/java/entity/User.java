package entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "user")
@NoArgsConstructor
@Getter
@Setter
public class User extends BaseEntity{
	
	@Column(name = "full_name", length = 100)
	private String full_name;
	
	@Column(name = "age")
	private int age;
	
	@ManyToOne
	@JoinColumn(name = "country_id")
	private Country country;
	
	@ManyToOne
	@JoinColumn(name = "city_id")
	private City city;

	@Override
	public String toString() {
		return "User [full_name=" + full_name + ", age=" + age + ", getId()=" + getId() + "]";
	}

	

	

	
}
