package org.dng.beer_counters.service;

import org.dng.beer_counters.model.Nomenclature;
import org.dng.beer_counters.repository.NomenclatureRepository;
import org.dng.beer_counters.repository.ProductionInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NomenclatureService {
    private final NomenclatureRepository repository;
    private final ProductionInfoRepository productionInfoRepository;

    @Autowired
    public NomenclatureService(NomenclatureRepository repository, ProductionInfoRepository productionInfoRepository) {
        this.repository = repository;
        this.productionInfoRepository = productionInfoRepository;
    }

    public List<Nomenclature> getAll(){
        return (List<Nomenclature>) repository.findAll();
    }

    public Optional<Nomenclature> getById(long id){
        return repository.findById(id);
    }

    public void saveOrUpdate(Nomenclature item){
        if ((item.getId() != null) && (item.getId() != 0)){ //item already exists
            Optional<Nomenclature> optionalItem = repository.findById(item.getId());
            if (optionalItem.isPresent()){
                Nomenclature editedItem = optionalItem.get();

                if (!editedItem.equals(item)){
                    editedItem.setName(item.getName());
                    repository.save(editedItem);
                }
            }
        } else{
            repository.save(item);
        }
    }

    public void delete(long id){
        if (!productionInfoRepository.existsById(id)){
            repository.findById(id).ifPresent(repository::delete);
        }
    }
}
