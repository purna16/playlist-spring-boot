package in.ac.iitb.playlist.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ac.iitb.playlist.repository.PlaylistRepository;
import in.ac.iitb.playlist.repository.PlaylistSongMappingRepository;
import in.ac.iitb.playlist.repository.SongsRepository;
import in.ac.iitb.playlist.model.PlaylistSongMapping;
import in.ac.iitb.playlist.model.Songs;

@Service
@Transactional
public class PlaylistSongMappingService {

	@Autowired
	private PlaylistSongMappingRepository playlistSongMappingRepository;
	
	@Autowired
	private SongsRepository songsRepository;
	
	@Autowired
	private PlaylistRepository playlistRepository;

	
	public void addPlaylistSongMapping(long playlist_id,long song_id) throws Exception {
		PlaylistSongMapping _playlistSongMapping = new PlaylistSongMapping();
		_playlistSongMapping.setSong(songsRepository.findById(song_id).get());
		_playlistSongMapping.setPlaylist(playlistRepository.findById(playlist_id).get());
		playlistSongMappingRepository.save(_playlistSongMapping);
	}
	
	public void deletePlaylistSongMapping(long playlist_id,long song_id) {
		playlistSongMappingRepository.deletePlaylistSongMappingWithPlaylistIdSongId(playlist_id, song_id);
	}
	

	public List<Songs> getAllSongsInPlaylist(long playlist_id) {
		List<Songs> playlistSongs = new ArrayList<>();
		playlistSongMappingRepository.findSongsWithPlaylistId(playlist_id).forEach(playlistSongs::add);
		return playlistSongs;
	}
}




