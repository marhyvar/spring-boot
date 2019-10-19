package palvelinohjelmointi.setlist.web;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import palvelinohjelmointi.setlist.domain.Genre;
import palvelinohjelmointi.setlist.domain.GenreRepository;
import palvelinohjelmointi.setlist.domain.Song;
import palvelinohjelmointi.setlist.domain.SongRepository;

@Controller
public class SongController {

	@Autowired
	public SongRepository songRepo;
	
	@Autowired
	public GenreRepository genreRepo;
	
	@GetMapping("index")
	public String index() {
		return "index";
	}
	
	@GetMapping("songlist")
	public String songlist(Model model) {
		System.out.println("controller.songList");
		model.addAttribute("songs", songRepo.findAll());
		return "songlist";
	}
	
	//for saving the song with error checking
	@ModelAttribute
	private Song getSong() {
		return new Song();
	}
	
	@ModelAttribute
	private Genre getGenre() {
		return new Genre();
	}
	
	//add a song
	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping("addSong")
	public String addSong(Model model) {
		model.addAttribute("genres", genreRepo.findAll());
		model.addAttribute("song", new Song());
		return "addSong";
	}
	
	
	//save a song
	@PreAuthorize("hasAuthority('ADMIN')")
	@PostMapping("saveSong")
	public String saveSong(@Valid @ModelAttribute Song song, BindingResult bindingResult, @ModelAttribute Genre genre) {
		if (bindingResult.hasErrors()) {
			return "addSong";
		}
		songRepo.save(song);
		return "redirect:songlist";
	}
	
	//edit a song
	@PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping(value = "/editSong/{id}")
    public String updateSong(@PathVariable("id") Long id, Model model) {
    	Song song = songRepo.findById(id).get();
    	
    	model.addAttribute("song", song);
    	model.addAttribute("genres", genreRepo.findAll());
    	return "editSong";
}

	//delete a song
	@PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/deleteSong/{id}", method = RequestMethod.GET)
    public String deleteSong(@PathVariable("id") Long id, Model model) {
    	System.out.println("song "  + id);
    	songRepo.deleteById(id);
    	return "redirect:../songlist";
    }
	
	// RESTful get the song according to id
	@GetMapping(value="/song/{id}")
	public @ResponseBody Optional<Song> findSongRest(@PathVariable("id") long songId) {
		return songRepo.findById(songId);
	}
}
