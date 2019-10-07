package palvelinohjelmointi.setlist.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Song {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@NotEmpty(message="name is mandatory")
	private String name;
	
	@Size(min=1, max=5)
	private String songkey;
	
	@Size(min=2, max=30)
	private String originalPerformer;
	
	@Pattern(regexp = "(^[0-5]?[0-9]):([0-5]?[0-9])$")
	private String totalLength;
	
	@ManyToOne
	@JsonIgnore
    @JoinColumn(name="genreid")
	private Genre genre;
	
	public Song(String name, String songkey, String originalPerformer, String totalLength) {
		super();
		this.name = name;
		this.songkey = songkey;
		this.originalPerformer = originalPerformer;
		this.totalLength = totalLength;
	}
	
	public Song(String name, String songkey, String originalPerformer, String totalLength, Genre genre) {
		super();
		this.name = name;
		this.songkey = songkey;
		this.originalPerformer = originalPerformer;
		this.totalLength = totalLength;
		this.genre = genre;
	}
		
}
