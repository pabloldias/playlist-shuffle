package br.com.pabloldias.playlist;

public class PlaylistInfo {

	private String name;
	private String originalPlaylist;
	private String authenticationCode;
	
	public PlaylistInfo() {}
	public PlaylistInfo(String code) {
		this.authenticationCode = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOriginalPlaylist() {
		return originalPlaylist;
	}
	public void setOriginalPlaylist(String originalPlaylist) {
		this.originalPlaylist = originalPlaylist;
	}
	public String getAuthenticationCode() {
		return authenticationCode;
	}
	public void setAuthenticationCode(String authenticationCode) {
		this.authenticationCode = authenticationCode;
	}
	@Override
	public String toString() {
		return "PlaylistInfo [name=" + name + ", originalPlaylist=" + originalPlaylist + ", authenticationCode="
				+ authenticationCode + "]";
	}
	
}
