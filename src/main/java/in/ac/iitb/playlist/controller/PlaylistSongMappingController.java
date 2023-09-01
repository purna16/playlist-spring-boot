/**
 * 
 */
package in.ac.iitb.playlist.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ac.iitb.playlist.model.Playlist;
import in.ac.iitb.playlist.model.Songs;
import in.ac.iitb.playlist.service.PlaylistSongMappingService;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api")
public class PlaylistSongMappingController {
	
	@Autowired
	PlaylistSongMappingService playlistSongMappingService;
	
	
	@PostMapping("/addPlaylistSongMapping/{playlist_id}/{song_id}")
	public void createPlaylist(@PathVariable Long playlist_id,@PathVariable Long song_id) {
		try {
			playlistSongMappingService.addPlaylistSongMapping(playlist_id, song_id);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@DeleteMapping("/deletePlaylistSongMapping/{playlist_id}/{song_id}")
	public ResponseEntity<Playlist> deletePlaylist(@PathVariable Long playlist_id,@PathVariable Long song_id) {
		try {
			playlistSongMappingService.deletePlaylistSongMapping(playlist_id, song_id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	} 
	
	
	@GetMapping("/getAllPlaylistSongs/{playlist_id}")
	public List<Songs> getAllPlaylists(@PathVariable Long playlist_id) {
		return playlistSongMappingService.getAllSongsInPlaylist(playlist_id);
	}
}
