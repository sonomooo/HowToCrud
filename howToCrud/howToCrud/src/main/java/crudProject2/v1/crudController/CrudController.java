package crudProject2.v1.crudController;

import crudProject2.v1.crudRepository.Schedule;
import crudProject2.v1.crudService.CrudService;
import crudProject2.v1.dto.ScheduleDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/crud")
public class CrudController {

    private final CrudService crudService;

    public CrudController(CrudService crudService) {
        this.crudService = crudService;
    }

    @PostMapping("/create")
        public void createMapping(
                @RequestBody ScheduleDto scheduleDto) {
        System.out.println("회원 생성 준비 완료");
        crudService.CreateSchedule(scheduleDto);
    }

    @GetMapping("/view")
    public List<Schedule> findMember(@RequestParam String authorName){
        return crudService.ReadSchedule(authorName);
    }

    @PostMapping("/update")
    public void updateSchedule(String beforeAuthorName,
                               String afterAuthorName,
                               String scheduleName){

        crudService.updateDate(beforeAuthorName, afterAuthorName, scheduleName);
    }

    @GetMapping("/delete")
    public void deleteSchedule(Long id,
                               String password){

        crudService.delete(id, password);
    }
}
