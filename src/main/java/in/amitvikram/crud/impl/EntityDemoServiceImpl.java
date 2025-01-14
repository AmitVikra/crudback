package in.amitvikram.crud.impl;

import in.amitvikram.crud.entity.EntityDemoClass;
import in.amitvikram.crud.repository.EntityDemoRepo;
import in.amitvikram.crud.service.EntityDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EntityDemoServiceImpl implements EntityDemoService {

    @Autowired
    private EntityDemoRepo entityDemoRepo;

    @Override
    public EntityDemoClass createNew(EntityDemoClass entityDemoClass){
        return entityDemoRepo.save(entityDemoClass);
    }

    @Override
    public Optional<EntityDemoClass> getEntityById(Long id){
        return entityDemoRepo.findById(id);
    }

    @Override
    public List<EntityDemoClass> getAllEntity(){
        return entityDemoRepo.findAll();
    }

    @Override
    public EntityDemoClass updateEntity(Long id, EntityDemoClass entityDemoClass){
        EntityDemoClass updatedEntity = entityDemoRepo.findById(id)
                .orElseThrow(() ->new RuntimeException( "Data not found with given id: "+id));
        updatedEntity.setFirstName(entityDemoClass.getFirstName());
        updatedEntity.setLastName(entityDemoClass.getLastName());
        updatedEntity.setSalary(entityDemoClass.getSalary());

        return entityDemoRepo.save(updatedEntity);
    }

    @Override
    public void deleteEntity(Long id){
        entityDemoRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Data Not Found with given id: "+id));
        entityDemoRepo.deleteById(id);
    }
}
