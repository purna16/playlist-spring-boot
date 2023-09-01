package in.ac.iitb.playlist.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ac.iitb.playlist.repository.PlaylistRepository;
import in.ac.iitb.playlist.repository.PlaylistSongMappingRepository;
import in.ac.iitb.playlist.model.Playlist;

@Service
@Transactional
public class PlaylistService {

	@Autowired
	private PlaylistRepository playlistRepository;
	
	@Autowired
	private PlaylistSongMappingRepository playlistSongMappingRepository;

	
	public long addPlaylist(Playlist playlist) throws Exception {
		Playlist saved_playlist = playlistRepository.save(playlist);
		return saved_playlist.getId();
	}
	
	public void deletePlaylist(Long playlistId) {
		playlistSongMappingRepository.deleteAllSongMappingWithPlaylistId(playlistId);
		playlistRepository.deleteById(playlistId);
	}
	

	public List<Playlist> getAllPlaylist() {
		List<Playlist> playlistList = new ArrayList<>();
		playlistRepository.findAll().forEach(playlistList::add);
		return playlistList;
	}
}
