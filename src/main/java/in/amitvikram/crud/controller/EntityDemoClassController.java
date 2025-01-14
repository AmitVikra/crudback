package in.amitvikram.crud.controller;

import in.amitvikram.crud.entity.EntityDemoClass;
import in.amitvikram.crud.service.EntityDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/employee")
public class EntityDemoClassController {

    @Autowired
    private EntityDemoService entityDemoService;

    @PostMapping("/")
    public ResponseEntity<EntityDemoClass> createNew(@RequestBody EntityDemoClass entityDemoClass){
        return ResponseEntity.ok(entityDemoService.createNew(entityDemoClass));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<EntityDemoClass>> getById(@PathVariable Long id){
        return ResponseEntity.ok(entityDemoService.getEntityById(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<EntityDemoClass>>  getAllData(){
        return ResponseEntity.ok(entityDemoService.getAllEntity());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteData(@PathVariable Long id){
        entityDemoService.deleteEntity(id);
        return ResponseEntity.ok("Data deleted with id: " +id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EntityDemoClass> updateData(@PathVariable Long id, @RequestBody EntityDemoClass entityDemoClass){
        return ResponseEntity.ok(entityDemoService.updateEntity(id,entityDemoClass));
    }
}
