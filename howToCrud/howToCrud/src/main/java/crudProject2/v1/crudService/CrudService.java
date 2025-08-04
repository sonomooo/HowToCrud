package crudProject2.v1.crudService;

import crudProject2.v1.crudRepository.CrudRepository;
import crudProject2.v1.crudRepository.Schedule;
import crudProject2.v1.dto.ScheduleDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CrudService {

    private final CrudRepository crudRepository;

    @Transactional
    public  List<Schedule> ReadSchedule(String author){


        return crudRepository.findAllByAuthorName(author)
               .stream()
               .sorted(Comparator.comparing(Schedule::getCreatedAt).reversed())
               .toList();
    }

    @Transactional
    public Schedule save(Schedule schedule){
        return crudRepository.save(schedule);
    }

    @Transactional
    public void updateDate(String beforeAuthorName,
                           String afterAuthorName,
                           String scheduleName){
        Schedule update = crudRepository.findByAuthorName(beforeAuthorName);

        update.setAuthorName(afterAuthorName);
        update.setScheduleName(scheduleName);
    }

//    @Transactional
//    public Schedule find(Schedule schedule){
//        return crudRepository.findAllById(schedule.getScheduleName());
//    }

    @Transactional
    public void CreateSchedule(ScheduleDto schedule){

        Schedule entity = new Schedule(
                schedule.getScheduleName(),
                schedule.getScheduleInfo(),
                schedule.getPassword(),
                schedule.getAuthorName());

        crudRepository.save(entity);
    }

    public void delete(Long id,
                       String password){
        Optional<Schedule> scheduleOptional = crudRepository.findById(id);

        if (scheduleOptional.isPresent()) {
            Schedule schedule = scheduleOptional.get();

            if (schedule.getPassword().equals(password)) {
                crudRepository.deleteById(id);
                System.out.println("삭제가 완료되었습니다.");
            } else {
                System.out.println("비밀번호가 일치하지 않습니다.");
            }

        } else {
            System.out.println("해당 ID의 스케줄이 존재하지 않습니다.");
        }
    }

}
