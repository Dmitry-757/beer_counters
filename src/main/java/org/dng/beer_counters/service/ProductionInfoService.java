package org.dng.beer_counters.service;


import org.dng.beer_counters.model.ProductionInfo;
import org.dng.beer_counters.repository.ProductionInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductionInfoService {
    private final ProductionInfoRepository repository;

    @Autowired
    public ProductionInfoService( ProductionInfoRepository repository) {
        this.repository = repository;
    }

    public List<ProductionInfo> getAll(){
        return repository.findAll();
    }

    public Page<ProductionInfo> getAllWithPagination(Pageable paging){
        return repository.findAll(paging);
    }
    public long getCountOfEntities(){
        return repository.count();
    }


    public Optional<ProductionInfo> getById(long id){
        return repository.findById(id);
    }

    public void saveOrUpdate(ProductionInfo item){
        if ((item.getId() != null) && (item.getId() != 0)){ //item already exists
            Optional<ProductionInfo> optionalItem = repository.findById(item.getId());
            if (optionalItem.isPresent()){
                ProductionInfo editedItem = optionalItem.get();

                if (!editedItem.equals(item)){
//                    editedItem.setComment(item.getComment());
                    repository.save(item);
                }
            }
        } else{
            repository.save(item);
        }
    }

    public void delete(long id){
//        if (repository.existsById(id)){
            repository.findById(id).ifPresent(repository::delete);
//        }
    }
}
