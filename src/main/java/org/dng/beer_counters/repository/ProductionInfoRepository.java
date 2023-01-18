package org.dng.beer_counters.repository;

import org.dng.beer_counters.model.ProductionInfo;
import org.springframework.data.repository.CrudRepository;

public interface ProductionInfoRepository extends CrudRepository<ProductionInfo, Long> {
}
