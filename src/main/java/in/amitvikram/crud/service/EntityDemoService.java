package in.amitvikram.crud.service;

import in.amitvikram.crud.entity.EntityDemoClass;

import java.util.List;
import java.util.Optional;

public interface EntityDemoService {
    EntityDemoClass createNew(EntityDemoClass entityDemoClass);

    Optional<EntityDemoClass> getEntityById(Long id);

    List<EntityDemoClass> getAllEntity();

    EntityDemoClass updateEntity(Long id, EntityDemoClass entityDemoClass);

    void deleteEntity(Long id);
}
