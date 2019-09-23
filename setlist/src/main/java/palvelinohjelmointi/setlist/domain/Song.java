package palvelinohjelmointi.setlist.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
public class Song {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String name, key, originalPerformer, totalLength;
	
	@ManyToOne
	@JsonIgnore
    @JoinColumn(name="setid")
	private Set set;
	
	
	public Song(String name, String key, String originalPerformer, String totalLength) {
		super();
		this.name = name;
		this.key = key;
		this.originalPerformer = originalPerformer;
		this.totalLength = totalLength;
	}
		
}
