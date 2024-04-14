package tu.sofia.travel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tu.sofia.travel.model.entity.Consumer;

public interface ConsumerRepository
        extends JpaRepository<Consumer, Long> {}