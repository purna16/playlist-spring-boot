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

import in.ac.iitb.playlist.model.Songs;
import in.ac.iitb.playlist.service.SongsService;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api")
public class SongController {
	
	@Autowired
	SongsService songService;
	
	
	@PostMapping("/addSong")
	public long createSongs(@RequestBody Songs song) {
		try {
			return songService.addSong(song);
		} catch(Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	

	
	@DeleteMapping("/deleteSong/{id}")
	public ResponseEntity<Songs> deleteSongs(@PathVariable Long id) {
		try {
			songService.deleteSongs(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	} 
	
	
	@GetMapping("/getAllSongs")
	public List<Songs> getAllSongss() {
		return songService.getAllSongs();
	}
}
