package in.ac.iitb.playlist.model;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="playlist")
public class Playlist {
	
	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private long id;
	  
	  @Column(name="name")  
	  private String name;
	  
	  @OneToMany(mappedBy = "playlist",cascade = CascadeType.ALL)
	  private List<PlaylistSongMapping> playlistSongMapping;
	

	  public Playlist() {}

	  public Playlist(
			 String name
		) {
		  this.name = name;
	  }

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	  
}
