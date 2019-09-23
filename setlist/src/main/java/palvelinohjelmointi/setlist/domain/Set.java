package palvelinohjelmointi.setlist.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
public class Set {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne
	@JoinColumn(name="id")
	private Gig gig;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="set")
	private List<Song> setList;

	public Set(Gig gig) {
		super();
		this.gig = gig;

	}
	
}
