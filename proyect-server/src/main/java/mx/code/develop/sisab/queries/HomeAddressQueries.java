package mx.code.develop.sisab.queries;

import mx.code.develop.sisab.repository.HomeAddressRepository;
import mx.code.develop.sisab.dto.HomeAddressData;
import mx.code.develop.sisab.model.Citizen_;
import mx.code.develop.sisab.model.HomeAddress;
import mx.code.develop.sisab.model.HomeAddress_;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class HomeAddressQueries {
    @Autowired EntityManager entityManager;
    @Autowired private HomeAddressRepository homeAddressRepository;

    public void save(List<HomeAddress> addressesList) {
        homeAddressRepository.saveAll(addressesList);
    }

    public List<HomeAddressData> getHomeAddress(Integer citizenId) {
        List<Predicate> predicates = new ArrayList<>();
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<HomeAddressData> criteriaQuery = builder.createQuery(HomeAddressData.class);

        Root<HomeAddress> address = criteriaQuery.from(HomeAddress.class);
        predicates.add(builder.equal(address.get(HomeAddress_.citizen).get(Citizen_.id), citizenId));

        criteriaQuery.select(builder.construct(
                HomeAddressData.class,
                address.get(HomeAddress_.id),
                address.get(HomeAddress_.nameAddress),
                address.get(HomeAddress_.location),
                address.get(HomeAddress_.status)
        ));
        criteriaQuery.where(builder.and(predicates.toArray(new Predicate[0])));
        TypedQuery<HomeAddressData> typedQuery = entityManager.createQuery(criteriaQuery);
        return typedQuery.getResultList();
    }

    public List<HomeAddress> searchCitizenById(Integer id) {
        return homeAddressRepository.findAll().stream().filter(row->row.getCitizen().getId().equals(id)).collect(Collectors.toList());
    }

    public void deleteAll(List<HomeAddress> addresses) {
        homeAddressRepository.deleteAll(addresses);
    }
}
