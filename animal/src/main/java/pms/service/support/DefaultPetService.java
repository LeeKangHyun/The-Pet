package pms.service.support;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pms.dao.PetDao;
import pms.domain.Pet;
import pms.service.PetService;

@Service
public class DefaultPetService implements PetService {
	
	@Autowired PetDao petDao;
	
	public List<Pet> getPetList(int mno) {	
		return petDao.petList(mno);
  }
	
  public Pet getOnePet(int pno) {
		return petDao.petSelectOne(pno);
  }
  
  public void addPet(Pet pet) {
  	petDao.insert(pet);
  }
  
  public int remove(int pno) {
  	return petDao.delete(pno);
  }
  
  public int change(Pet pet) {
  	return petDao.update(pet);
  }

}