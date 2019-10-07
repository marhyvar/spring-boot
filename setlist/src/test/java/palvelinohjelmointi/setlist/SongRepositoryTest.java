package palvelinohjelmointi.setlist;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import palvelinohjelmointi.setlist.domain.Genre;
import palvelinohjelmointi.setlist.domain.Song;
import palvelinohjelmointi.setlist.domain.SongRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class SongRepositoryTest {
	
	@Autowired
	private SongRepository songRepo;
	
	@Test
	public void findByTitleShouldReturnSong() {
		List<Song> songs = songRepo.findByName("Every Breath You Take");
		
		assertThat(songs).hasSize(1);
		assertThat(songs.get(0).getOriginalPerformer()).isEqualTo("The Police");
	}
	
	@Test
	public void createNewSong() {
		Song song = new Song("Hocus Pocus", "E", "Focus", "5:32", new Genre("Proge"));
		songRepo.save(song);
		assertThat(song.getId()).isNotNull();
	}
}
