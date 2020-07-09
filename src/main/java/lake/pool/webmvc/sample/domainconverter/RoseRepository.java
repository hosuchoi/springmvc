package lake.pool.webmvc.sample.domainconverter;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RoseRepository extends JpaRepository<Rose, Long> {
}
