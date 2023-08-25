package mx.code.develop.sisab.repository;

import mx.code.develop.sisab.model.HomeAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HomeAddressRepository extends JpaRepository<HomeAddress, Integer> {
}
