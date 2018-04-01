package entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "city")
@NoArgsConstructor
@Getter
@Setter
public class City extends BaseEntity{
	
	@Column(name = "city_name", length = 100)
	private String city_name;

	@ManyToOne
	@JoinColumn(name = "country_id")
	private Country country;
	
	@OneToMany(mappedBy = "full_name")
	private List<User> users = new ArrayList<User>();
}
