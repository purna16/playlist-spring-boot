package in.ac.iitb.playlist;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

import in.ac.iitb.playlist.model.Songs;
import in.ac.iitb.playlist.repository.SongsRepository;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.containsString;


@DataJpaTest
class PlayListTests {
  
	@Autowired
	  private SongsRepository songRepository ;
	
	
	 @Test
	 @Rollback(false)		
	 public void testAddNewSong() throws Exception {
			Songs song = new Songs("Title 1","Artist 1","Composer 1","2001","Album 1","URL 1");
			
			Songs songR = songRepository.save(song);
			System.out.println("SongId RRR :: "+songR);
			
			if(songR != null) {
				
				//songId = songService.addSong(song);
				//System.out.println("SongId :: "+songId);
	
				org.assertj.core.api.Assertions.assertThat(songR.getId()).isGreaterThan(0);
				//List<Songs> songNX = songService.getSongByTitle("Title 1");
				//System.out.println("SongNX:: "+songNX.toString());
				
				//Songs songN = songService.getSongById(songId);
				//System.out.println("SongN :: "+songN.toString());
				
				
				assertEquals(songR.getTitle(),"Title 1" );
				assertNotNull("Artist is not null", songR.getArtists());
				assertThat(songR.getYear(),containsString("2001"));
				
				
			}
					
		}
	 
	 @Test
	 public void testListofSongs() {
	     List<Songs> songs = (List<Songs>) songRepository.findAll();
	     assertThat(songs).size().isGreaterThan(0);
	 }
	 
	 @Test
	 public void testFindSongByTitle() {
	     Songs song = songRepository.findByTitle("Title 1");    
	     assertThat(song.getTitle()).isEqualTo("Title 1");
	 }

		@Test
		@Rollback(false)
		public void testDeleteSong() {
			Songs song = songRepository.findByTitle("Title 1");
			System.out.println("Song D :: "+song);   
			songRepository.deleteById(song.getId());
	     
			Songs deletedSong = songRepository.findByTitle("Title 1");
	     
			assertThat(deletedSong).isNull();  
		}

}
