package br.com.pabloldias;

import br.com.pabloldias.api.Authenticator;

public class App {
	
	public static void main(String[] args) {
		Authenticator auth = new Authenticator();
		auth.authenticate();
	}

}
