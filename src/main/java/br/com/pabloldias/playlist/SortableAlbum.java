package br.com.pabloldias.playlist;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.wrapper.spotify.models.SimpleAlbum;

public class SortableAlbum {
	
	private List<SortableTrack> tracks = new ArrayList<>();
	private String uri;
	private String name;

	public SortableAlbum(SimpleAlbum simpleAlbum) {
		this.uri = simpleAlbum.getUri();
		this.name = simpleAlbum.getName();
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.getUri(), this.getName());
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SortableAlbum other = (SortableAlbum) obj;
		return Objects.equals(this.getUri(), other.getUri())
				&& Objects.equals(this.getName(), other.getName());
	}
	
	public void addTrack(SortableTrack track) {
		tracks.add(track);
	}

	public List<SortableTrack> getTracks() {
		return tracks;
	}

	public void setTracks(List<SortableTrack> tracks) {
		this.tracks = tracks;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "SortableAlbum [name=" + name + "]";
	}
	
	
}
