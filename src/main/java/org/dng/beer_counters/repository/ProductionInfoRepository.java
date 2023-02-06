package org.dng.beer_counters.repository;

import org.dng.beer_counters.model.Nomenclature;
import org.dng.beer_counters.model.ProductionInfo;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ProductionInfoRepository extends CrudRepository<ProductionInfo, Long> {
    List<ProductionInfo> findProductionInfoByNomenclature(Nomenclature item);

    @Query("select p from ProductionInfo p where p.nomenclature = ?1")
    List<ProductionInfo> findByNomenclature(Nomenclature item);

    @Transactional
    @Modifying
    @Query(value = "UPDATE production_info SET nomenclature_id=NULL WHERE nomenclature_id=?1", nativeQuery = true)
    int clearNomenclatureInProductionByNomencl(long id);

}
