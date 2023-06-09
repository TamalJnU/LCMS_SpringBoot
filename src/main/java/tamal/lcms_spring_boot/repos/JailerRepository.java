package tamal.lcms_spring_boot.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import tamal.lcms_spring_boot.domain.Jailer;


public interface JailerRepository extends JpaRepository<Jailer, Long> {
}
