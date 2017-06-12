package br.com.pabloldias;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import br.com.pabloldias.api.Authenticator;

public class PlaylistShuffler {

	public void shuffle() {
		String authFile = "auth.properties";
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		Properties properties = new Properties();
		try(InputStream resourceStream = loader.getResourceAsStream(authFile)) {
		    properties.load(resourceStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Authenticator auth = new Authenticator(properties);
		auth.authenticate();
	}

}
