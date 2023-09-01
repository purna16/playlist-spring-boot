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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ac.iitb.playlist.model.Playlist;
import in.ac.iitb.playlist.service.PlaylistService;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api")
public class PlaylistController {
	
	@Autowired
	PlaylistService playlistService;
	
	
	@PostMapping("/addPlaylist")
	public long createPlaylist(@RequestBody Playlist playlist) {
		try {
			return playlistService.addPlaylist(playlist);
		} catch(Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	

	
	@DeleteMapping("/deletePlaylist/{id}")
	public ResponseEntity<Playlist> deletePlaylist(@PathVariable Long id) {
		try {
			playlistService.deletePlaylist(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	} 
	
	
	@GetMapping("/getAllPlaylist")
	public List<Playlist> getAllPlaylists() {
		return playlistService.getAllPlaylist();
	}
}
