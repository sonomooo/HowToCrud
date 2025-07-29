package crudProject2.v1.crudController;

import crudProject2.v1.crudRepository.Schedule;
import crudProject2.v1.crudService.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/crud")
public class CrudController {

    @Autowired
    CrudService crudService;

    @GetMapping("/create")
    public void createMapping(Schedule schedule) {
        crudService.CreateSchedule(schedule);


    }

    @GetMapping("/find")
    public Schedule findMember(@RequestParam String name){
        return crudService.ReadSchedule(name);
    }

}
