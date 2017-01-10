package boot.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import boot.dao.HarvestRepository;
import boot.model.Harvest;



@Service @Transactional
public class HarvestService {

	private final HarvestRepository harvestRepository;

	public HarvestService(HarvestRepository harvestRepository){
		super();
		this.harvestRepository= harvestRepository;
	}
	
	public List <Harvest> findAll(){
		List<Harvest> harvests = new ArrayList<Harvest>();
		for(Harvest harvest : harvestRepository.findAll() ){
			harvests.add(harvest);
		}
		return harvests;
	}
	
	public void save(Harvest harvest){
		harvestRepository.save(harvest);
	}
	
	public void delete(int id){
		harvestRepository.delete(id);
	}
	
	public  Harvest finOne(int id){
	return harvestRepository.findOne(id);
	}
}
