package crudProject2.v1.crudRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CrudRepository extends JpaRepository<Schedule , Long> {

    Schedule findByAuthorName(String authorName);

    List<Schedule> findAllByAuthorName(String authorName);

    void deleteById(Long id);

    Optional<Schedule> findById(Long id);

}
