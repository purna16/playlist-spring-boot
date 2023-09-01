/**
 * 
 */
package in.ac.iitb.playlist.repository;
import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;

import in.ac.iitb.playlist.model.Songs;
/**
 * NOTE:
 * - https://docs.spring.io/spring-data/jpa/docs/current/api/org/springframework/data/jpa/repository/JpaRepository.html
 * 
 */
public interface SongsRepository extends CrudRepository<Songs, Serializable> {
	
	Songs findByTitle(String title);
	

}
