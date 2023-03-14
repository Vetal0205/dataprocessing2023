package dp2023.lab6.Controllers;
import dp2023.lab6.Entities.Manpads;
import dp2023.lab6.Repositories.ManpadsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.ResourceAccessException;

import java.util.List;

@RestController
@RequestMapping("Lab_dp/api/manpads")
@CrossOrigin(origins = "*")
public class ManpadsController {

    @Autowired
    ManpadsRepository manpadsRepository;

    @PostMapping("/post")
    @ResponseStatus(HttpStatus.CREATED)
    public Manpads postEntity(@RequestBody Manpads manpads){
        return manpadsRepository.save(manpads);
    }

    @GetMapping("/get")
    public List<Manpads> getEntities(){
        return manpadsRepository.findAll();
    }

    @PutMapping("/update/{id}")
    public Manpads putEntity(@PathVariable int id, @RequestBody Manpads newManpad){
        Manpads updatedManpad = manpadsRepository.findById(id)
                .orElseThrow(()-> new ResourceAccessException("Not found Manpads with id: "+id));
        updatedManpad.setWeight(newManpad.getWeight());
        updatedManpad.setName(newManpad.getName());
        updatedManpad.setPhoto(newManpad.getPhoto());
        return manpadsRepository.save(updatedManpad);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteEntity(@PathVariable int id){
        manpadsRepository.deleteById(id);
    }
}
