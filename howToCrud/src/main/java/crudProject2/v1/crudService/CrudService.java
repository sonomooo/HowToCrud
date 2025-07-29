package crudProject2.v1.crudService;

import crudProject2.v1.crudRepository.CrudRepository;
import crudProject2.v1.crudRepository.Schedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CrudService {

    @Autowired
    CrudRepository crudRepository;

    public Schedule ReadSchedule(String author){
        return crudRepository.findAllById(author);

    }

    public void CreateSchedule(Schedule schedule){
        crudRepository.saveEntity(schedule);
    }


}
