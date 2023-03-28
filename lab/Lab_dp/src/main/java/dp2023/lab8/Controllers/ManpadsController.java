package dp2023.lab8.Controllers;
import dp2023.lab8.Entities.Manpads;
import dp2023.lab8.Repositories.ManpadsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.ResourceAccessException;

import java.util.List;

@RestController
@RequestMapping("Lab_dp/api/manpads")
@CrossOrigin(origins = "*")
@Slf4j
public class ManpadsController {

    @Autowired
    ManpadsRepository manpadsRepository;

    @PostMapping("/post")
    @ResponseStatus(HttpStatus.CREATED)
    public Manpads postEntity(@RequestBody Manpads manpads){
        log.info("[MANPADS CONTROLLER] : POST request received");
        manpadsRepository.save(manpads);
        log.info("[MANPADS CONTROLLER] : Mandpad - {} was pushed", manpads.getName());
        return manpads;
    }

    @GetMapping("/get")
    public List<Manpads> getEntities(){
        List<Manpads> list;
        log.info("[MANPADS CONTROLLER] : GET request received");
        list = manpadsRepository.findAll();
        log.info("[MANPADS CONTROLLER] : GET response consist of {} manpads",list.size());
        return list;
    }

    @PutMapping("/update/{id}")
    public Manpads putEntity(@PathVariable int id, @RequestBody Manpads newManpad){
        log.info("[MANPADS CONTROLLER] : UPDATE request received");
        Manpads updatedManpad = manpadsRepository.findById(id)
                .orElseThrow(() -> {
                    log.error("[MANPADS CONTROLLER] : UPDATE request failed. Id {} not found", id);
                    return new ResourceAccessException("Not found Manpads with id: " + id);
                });
        updatedManpad.setWeight(newManpad.getWeight());
        updatedManpad.setName(newManpad.getName());
        updatedManpad.setPhoto(newManpad.getPhoto());
        manpadsRepository.save(updatedManpad);
        log.info("[MANPADS CONTROLLER] : Mandpad - {} with id - {} was updated",updatedManpad.getName(),id);
        return updatedManpad;
    }

    @DeleteMapping("/delete/{id}")
    public void deleteEntity(@PathVariable int id){
        log.info("[MANPADS CONTROLLER] : DELETE request received");
        manpadsRepository.deleteById(id);
        log.info("[MANPADS CONTROLLER] : Mandpad with id - {} was deleted",id);
    }
}