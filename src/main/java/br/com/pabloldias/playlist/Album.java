package br.com.pabloldias.playlist;

import java.util.List;

public class Album {
	
	private Artist artist;

	private List<Track> trackList;

	public Album(Artist artist, List<Track> trackList) {
		this.artist = artist;
		this.trackList = trackList;
	}

	public Artist getArtist() {
		return artist;
	}
	
	public void setArtist(Artist artist) {
		this.artist = artist;
	}
	
	public List<Track> getTrackList() {
		return trackList;
	}
	
	public void setTrackList(List<Track> trackList) {
		this.trackList = trackList;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((artist == null) ? 0 : artist.hashCode());
		result = prime * result + ((trackList == null) ? 0 : trackList.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Album other = (Album) obj;
		if (artist == null) {
			if (other.artist != null)
				return false;
		} else if (!artist.equals(other.artist))
			return false;
		if (trackList == null) {
			if (other.trackList != null)
				return false;
		} else if (!trackList.equals(other.trackList))
			return false;
		return true;
	}
}
