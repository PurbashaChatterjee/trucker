package io.egen.repository;

import io.egen.entity.Reading;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReadingsRepository extends CrudRepository<Reading, String> {
	
	Iterable<Reading> findByVin(String vin);

}
