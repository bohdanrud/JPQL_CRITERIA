package entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "country")
@NoArgsConstructor
@Getter
@Setter
public class Country extends BaseEntity{
	
	@Column(name = "country_name", length = 100)
	private String country_name;
	
	@OneToMany(mappedBy = "city_name")
	private List<City> cities = new ArrayList<City>(); 
	
	@Override
	public String toString() {
		return "Country [country_name=" + country_name + ", getId()=" + getId() + "]";
	}

	@OneToMany(mappedBy = "full_name")
	private List<User> users = new ArrayList<User>();

	

}
