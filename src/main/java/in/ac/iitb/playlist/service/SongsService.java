package in.ac.iitb.playlist.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ac.iitb.playlist.repository.PlaylistSongMappingRepository;
import in.ac.iitb.playlist.repository.SongsRepository;
import in.ac.iitb.playlist.model.Songs;

@Service
@Transactional
public class SongsService {

	@Autowired
	private SongsRepository songsRepository;
	
	@Autowired
	private PlaylistSongMappingRepository playlistSongMappingRepository;

	
	public long addSong(Songs song) throws Exception {
		Songs saved_song = songsRepository.save(song);
		return saved_song.getId();
	}
	
	public void deleteSongs(Long songId) {
		playlistSongMappingRepository.deleteAllSongMappingWithSongId(songId);
		songsRepository.deleteById(songId);
	}
	

	public List<Songs> getAllSongs() {
		List<Songs> songList = new ArrayList<>();
		songsRepository.findAll().forEach(songList::add);
		return songList;
	}
	
	public Songs getSongById(Long songId) {
		Optional<Songs> opt = songsRepository.findById(songId);
        if (opt.isPresent())
            return opt.get();
        else
            return null;
	}
	
	public Songs getSongByTitle(String title) {
    	
        Songs song = songsRepository.findByTitle(title);        
        return song;
    }
}
