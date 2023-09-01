/**
 * 
 */
package in.ac.iitb.playlist.repository;
import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import in.ac.iitb.playlist.model.PlaylistSongMapping;
import in.ac.iitb.playlist.model.Songs;
/**
 * NOTE:
 * - https://docs.spring.io/spring-data/jpa/docs/current/api/org/springframework/data/jpa/repository/JpaRepository.html
 * 
 */
public interface PlaylistSongMappingRepository extends CrudRepository<PlaylistSongMapping, Serializable> {
	
	@Query("SELECT a.song FROM PlaylistSongMapping a WHERE a.playlist.id = ?1")
	List<Songs> findSongsWithPlaylistId(long playlist_id);
	
	
	@Modifying
	@Query("DELETE FROM PlaylistSongMapping a WHERE a.playlist.id = ?1 and a.song.id = ?2")
	void deletePlaylistSongMappingWithPlaylistIdSongId(long playlist_id,long song_id);
	
	
	@Modifying
	@Query("DELETE FROM PlaylistSongMapping a WHERE a.song.id = ?1")
	void deleteAllSongMappingWithSongId(long song_id);
	
	@Modifying
	@Query("DELETE FROM PlaylistSongMapping a WHERE a.playlist.id = ?1")
	void deleteAllSongMappingWithPlaylistId(long playlist_id);
}
