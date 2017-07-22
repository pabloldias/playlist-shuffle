package br.com.pabloldias.playlist;

import java.util.Objects;

import com.wrapper.spotify.models.Track;

public class SortableTrack {

	private String title;
	private String uri;

	public SortableTrack(Track track) {
		this.title = track.getName();
		this.uri = track.getUri();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getUri() {
		return uri;
	}
	
	public void setUri(String uri) {
		this.uri = uri;
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.getUri(), this.getTitle());
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SortableTrack other = (SortableTrack) obj;
		return Objects.equals(this.getUri(), other.getUri())
				&& Objects.equals(this.getTitle(), other.getTitle());
	}

	@Override
	public String toString() {
		return "SortableTrack [title=" + title + "]";
	}

}
