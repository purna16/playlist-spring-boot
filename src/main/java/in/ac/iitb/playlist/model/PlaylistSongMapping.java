package in.ac.iitb.playlist.model;

import javax.persistence.*;

import in.ac.iitb.playlist.model.Songs;

@Entity
@Table(name="playlist_song_mapping")
public class PlaylistSongMapping {
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private long id;
		  
		@ManyToOne(cascade = CascadeType.ALL) 
		@JoinColumn(name = "song_id", referencedColumnName = "id")
		private Songs song;
		
		
		@ManyToOne(cascade = CascadeType.ALL) 
		@JoinColumn(name = "playlist_id", referencedColumnName = "id")
		private Playlist playlist;
		
		  
		public PlaylistSongMapping() {}
		
		
		public long getId() {
			return id;
		}
	
	
		public void setId(long id) {
			this.id = id;
		}
	
	
		public Songs getSong() {
			return song;
		}
	
	
		public void setSong(Songs song) {
			this.song = song;
		}


		public Playlist getPlaylist() {
			return playlist;
		}


		public void setPlaylist(Playlist playlist) {
			this.playlist = playlist;
		}

	  
	  
}
