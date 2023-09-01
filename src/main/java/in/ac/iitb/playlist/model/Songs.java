package in.ac.iitb.playlist.model;

import java.util.List;

import javax.persistence.*;


@Entity
@Table(name="songs")
public class Songs {
	
	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private long id;
	  
	  @Column(name="title")  
	  private String title;
	  
	  
	  @Column(name="artists")  
	  private String artists;
	  
	  
	  @Column(name="composer")  
	  private String composer;
	
	  
	  @Column(name="year")  
	  private String year;
	  
	  
	  @Column(name="album")  
	  private String album;
	  
	  
	  @Column(name="url")  
	  private String url;
	  
	  
	  @OneToMany(mappedBy = "song",cascade = CascadeType.ALL)
	  private List<PlaylistSongMapping> playlistSongMapping;
	

	  public Songs() {}

	  public Songs(
			  String title,
			 String artists,
			 String composer,
			 String year,
			 String album,
			 String url
		) {
		  this.title = title;
		  this.artists = artists;
		  this.composer = composer;
		  this.year = year;
		  this.album = album;
		  this.url = url;
	  }

	  
		public long getId() {
			return id;
		}
	
		public void setId(long id) {
			this.id = id;
		}
	
		public String getTitle() {
			return title;
		}
	
		public void setTitle(String title) {
			this.title = title;
		}
	
		public String getArtists() {
			return artists;
		}
	
		public void setArtists(String artists) {
			this.artists = artists;
		}
	
		public String getComposer() {
			return composer;
		}
	
		public void setComposer(String composer) {
			this.composer = composer;
		}
	
		public String getYear() {
			return year;
		}
	
		public void setYear(String year) {
			this.year = year;
		}
	
		public String getAlbum() {
			return album;
		}
	
		public void setAlbum(String album) {
			this.album = album;
		}
	
		public String getUrl() {
			return url;
		}
	
		public void setUrl(String url) {
			this.url = url;
		}
		

		@Override
		public String toString() {
			return "Songs [id=" + id + ", title=" + title + ", artists=" + artists + ", composer=" + composer
					+ ", year=" + year + ", album=" + album + ", url=" + url + "]";
		}

		}
