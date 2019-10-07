package palvelinohjelmointi.setlist.domain;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;
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
	
	@NotEmpty(message="Location is mandatory")
	@Size(min=2, max=40)
	private String location;
	
	@Size(min=2, max=40)
	private String comment;
	
	@NotNull(message="Date and time is mandatory: dd.mm.yyyy mm.ss")
	private LocalDateTime pvm;
	


	
	public Gig(String location, String comment, LocalDateTime pvm) {
		super();
		this.location = location;
		this.comment = comment;
		this.pvm = pvm;
	}

	
}
