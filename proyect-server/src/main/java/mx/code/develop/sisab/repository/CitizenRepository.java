package mx.code.develop.sisab.repository;

import mx.code.develop.sisab.model.Citizen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CitizenRepository extends JpaRepository<Citizen, Integer> {
    @Query("SELECT COUNT(*) FROM Citizen c " +
            "WHERE c.identifier=:identifier ")
    Integer isExistCitizen(String identifier);

    @Query("SELECT c FROM Citizen c " +
            "WHERE c.identifier=:identifier ")
    Citizen findCitizenById(String identifier);
}
