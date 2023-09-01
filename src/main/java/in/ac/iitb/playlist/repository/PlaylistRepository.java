/**
 * 
 */
package in.ac.iitb.playlist.repository;
import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;

import in.ac.iitb.playlist.model.Playlist;
/**
 * NOTE:
 * - https://docs.spring.io/spring-data/jpa/docs/current/api/org/springframework/data/jpa/repository/JpaRepository.html
 * 
 */
public interface PlaylistRepository extends CrudRepository<Playlist, Serializable> {
}
