package crudProject2.v1.crudRepository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CrudRepository extends JpaRepository<Long, Schedule> {

    Schedule saveEntity(Schedule schedule);

    @Override
    void deleteById(Schedule schedule);

    Schedule findAllById(String author);

}
