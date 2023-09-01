package in.ac.iitb.playlist.service;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.Rollback;

import com.fasterxml.jackson.databind.Module.SetupContext;

import in.ac.iitb.playlist.model.Songs;
import in.ac.iitb.playlist.repository.SongsRepository;

@DataJpaTest
class SongsServiceTest {
	
	@Mock
	//@Autowired
    private SongsRepository songRepository ;

	
	@InjectMocks
	private SongsService songService= new SongsService();
	 
	
  @Test
  @DisplayName("Test creating a song")
  @Order(1)
  void testCreateASong() throws Exception {
      // Setup our mock repository
      Songs song = new Songs("Title 1","Artist 1","Composer 1","2001","Album 1","URL 1");
      song.setId(1L);
		System.out.println("SongId RRR 11111 :: "+song);

      doReturn(song).when(songRepository).save(any());
		System.out.println("SongId RRR 22222222222 :: "+song);

      // Execute the service call
      Long songId = songService.addSong(song);
      System.out.println("SongId RRR 33333333333 :: "+songId);
      Assertions.assertNotNull(songId,"Song Id is not null");
      
      /*
      Songs songN = songService.getSongById(1L);
      System.out.println("SongId RRR 444444444444 :: "+songN);
      Assertions.assertNotNull(songN, "Song was not null");
      assertEquals(songN.getTitle(),"Title 1" );
	  assertNotNull("Artist is not null", songN.getArtists());
	  assertThat(songN.getYear(),containsString("2001"));
	  */		
  }
	
	@Test
    @DisplayName("Test findByTitle Success")
	@Order(2)
    void testFindById() {
        // Setup our mock repository
        Songs song = new Songs("Title 1","Artist 1","Composer 1","2001","Album 1","URL 1");
        song.setId(1L);;
        doReturn(song).when(songRepository).findByTitle("Title 1");

        // Execute the service call
        Songs returnedSong = songService.getSongByTitle("Title 1");

        // Assert the response
        Assertions.assertNotNull(returnedSong, "Song was not null");
        Assertions.assertEquals("Album 1", returnedSong.getAlbum(), "The album should be same");
    }

    @Test
    @DisplayName("Test getAllSongs")
    @Order(3)
    void testFindAll() {
        // Setup our mock repository
        Songs song1 = new Songs("Title 1","Artist 1","Composer 1","2001","Album 1","URL 1");
        Songs song2 = new Songs("Title 2","Artist 2","Composer 2","2002","Album 2","URL 2");
        doReturn(Arrays.asList(song1, song2)).when(songRepository).findAll();
        
    	 
         List<Songs> songList = songService.getAllSongs();
    	 System.out.println("SIZEEEEEEEEEEEE  "+songList.size());
        // Assert the response
        Assertions.assertEquals(2, songList.size(), "getAllSongs should return 2");
    	
    }
	

}
