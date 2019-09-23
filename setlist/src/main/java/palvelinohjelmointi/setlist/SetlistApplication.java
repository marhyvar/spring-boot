package palvelinohjelmointi.setlist;

import java.time.LocalDateTime;
import java.time.Month;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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
	public CommandLineRunner demo(SongRepository songRepo, GigRepository gigRepo, UserRepository userRepo) { 
		return (args) -> { 
			
			LocalDateTime dateTime1 = LocalDateTime.of(2019, Month.SEPTEMBER, 11, 16, 15, 15);
			LocalDateTime dateTime2 = LocalDateTime.of(2019, Month.OCTOBER, 19, 16, 15, 15);
			
			// add some demo data to db 
			songRepo.save(new Song("Every Breath You Take", "G", "The Police", "4:32"));
			songRepo.save(new Song("Take On Me", "G", "A-HA", "4:03"));
			songRepo.save(new Song("Holy Diver", "Em", "Dio", "5:12"));
			
			gigRepo.save(new Gig("Helsinki", "Esko's Birthday Party", dateTime1));
			gigRepo.save(new Gig("Turku", "Selma's and Pete's Wedding", dateTime2));
			
			// Create users: admin/admin user/user
			User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
			userRepo.save(user1);
			userRepo.save(user2);
		}; 
	}
}
