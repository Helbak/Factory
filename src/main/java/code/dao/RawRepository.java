package code.dao;

import code.domain.Raw;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RawRepository extends JpaRepository<Raw, Long> {
}
