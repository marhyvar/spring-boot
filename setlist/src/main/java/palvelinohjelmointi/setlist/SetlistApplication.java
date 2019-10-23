package palvelinohjelmointi.setlist;

import java.time.LocalDateTime;
import java.time.Month;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.thymeleaf.extras.java8time.dialect.Java8TimeDialect;

import palvelinohjelmointi.setlist.domain.Genre;
import palvelinohjelmointi.setlist.domain.GenreRepository;
import palvelinohjelmointi.setlist.domain.Gig;
import palvelinohjelmointi.setlist.domain.GigRepository;
import palvelinohjelmointi.setlist.domain.Song;
import palvelinohjelmointi.setlist.domain.SongRepository;
import palvelinohjelmointi.setlist.domain.User;
import palvelinohjelmointi.setlist.domain.UserRepository;

@SpringBootApplication
public class SetlistApplication {

	public static void main(String[] args) {
		SpringApplication.run(SetlistApplication.class, args);
	}
	
	@Bean
    public Java8TimeDialect java8TimeDialect() {
        return new Java8TimeDialect();
    }
	/*
	@Bean
	public CommandLineRunner demo(SongRepository songRepo, GigRepository gigRepo, UserRepository userRepo, GenreRepository genreRepo) { 
		return (args) -> { 
			
			LocalDateTime dateTime1 = LocalDateTime.of(2019, Month.NOVEMBER, 11, 16, 15, 00);
			LocalDateTime dateTime2 = LocalDateTime.of(2019, Month.DECEMBER, 19, 16, 15, 00);
			genreRepo.save(new Genre("Rock"));
			genreRepo.save(new Genre("Pop"));
			genreRepo.save(new Genre("Heavy"));
			genreRepo.save(new Genre("Jazz"));
			genreRepo.save(new Genre("Folk"));
			Song song1 = new Song("Every Breath You Take", "G", "The Police", "4:13", genreRepo.findByName("Rock").get(0));
			Song song2 = new Song("Take On Me", "G", "A-ha", "3:46", genreRepo.findByName("Pop").get(0));
			Song song3 = new Song("Holy Diver", "Em", "Dio", "5:51", genreRepo.findByName("Heavy").get(0));
			Gig gig1 = new Gig("Helsinki", "Esko's Birthday Party", dateTime1);
			Gig gig2 = new Gig("Turku", "Selma's and Pete's Wedding", dateTime2);
			
			
			
			// add some demo data to db 
			songRepo.save(song1);
			songRepo.save(song2);
			songRepo.save(song3);
			
			gigRepo.save(gig1);
			gigRepo.save(gig2);
			
			
			// Create users: admin/admin user/user
			User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
			userRepo.save(user1);
			userRepo.save(user2); 
		}; 
	} */
}
