package br.com.pabloldias;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {
	
	//@Autowired
	//private PlaylistShuffler playlistShuffler;
	
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

	/*@Override
	public void run(ApplicationArguments args) throws Exception {
		playlistShuffler.shuffle();
	}*/

}
