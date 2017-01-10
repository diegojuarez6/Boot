package boot.dao;

import org.springframework.data.repository.CrudRepository;

import boot.model.Harvest;


public interface HarvestRepository extends CrudRepository<Harvest,Integer> {

}
