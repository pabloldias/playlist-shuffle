package br.com.pabloldias.playlist;

import java.util.Objects;

import com.wrapper.spotify.models.SimpleAlbum;

public class Album extends SimpleAlbum {

	@Override
	public int hashCode() {
		return Objects.hashCode(this.getUri());
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
		return Objects.equals(this.getUri(), other.getUri());
	}
}
