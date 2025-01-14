package in.amitvikram.crud.repository;

import in.amitvikram.crud.entity.EntityDemoClass;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntityDemoRepo extends JpaRepository<EntityDemoClass, Long> {
}
