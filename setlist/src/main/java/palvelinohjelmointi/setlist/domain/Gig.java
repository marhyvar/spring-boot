package palvelinohjelmointi.setlist.domain;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
public class Gig {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private String location;
	
	private String comment;
	
	@NotNull
	private LocalDateTime pvm;
	
	@OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL,
            mappedBy = "gig")
	private Set set;
	
	public Gig(String location, String comment, LocalDateTime pvm) {
		super();
		this.location = location;
		this.comment = comment;
		this.pvm = pvm;
	}

	public Gig(String location, String comment, LocalDateTime pvm, Set set) {
		super();
		this.location = location;
		this.comment = comment;
		this.pvm = pvm;
		this.set = set;
	}
	
}
