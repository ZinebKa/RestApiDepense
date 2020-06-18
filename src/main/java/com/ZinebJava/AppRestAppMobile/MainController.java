package com.ZinebJava.AppRestAppMobile;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ZinebJava.AppRestAppMobile.data.Depense;
import com.ZinebJava.AppRestAppMobile.data.Dette;
import com.ZinebJava.AppRestAppMobile.model.DepenseRepositrory;
import com.ZinebJava.AppRestAppMobile.model.DetteRepository;

@Controller 
@RequestMapping(path="/api")
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class MainController {
	@Autowired
	private DepenseRepositrory depenseRepository;
	@Autowired
	private DetteRepository detteRepository;
	// Pour les dépenses
	 @PostMapping(path="/depense/add") 
	  public @ResponseBody String addNewDepense (@RequestParam String libele,@RequestParam float montant,
			  @RequestParam String note,@RequestParam String date) {

		  Depense n = new Depense();
	    n.setLibele(libele);
	    n.setMontant(montant);
	    n.setNote(note);
	    n.setDate(date);
	    depenseRepository.save(n);
	    return "Saved";
	  }

	  @GetMapping(value = "/depense/{id}")
	  @ResponseBody
	  public Optional<Depense> GetDepenseById(@PathVariable int id){
	      return depenseRepository.findById(id);
	  }


	  
	  @GetMapping(path="/depenses")
	  public @ResponseBody Iterable<Depense> getAllDepense() {
	    
	    return depenseRepository.findAll();
	  }
	 
	 



	@PutMapping("/depense/{id}")
	Depense replaceDepense(@RequestBody Depense newDepense, @PathVariable int id) {

	  return depenseRepository.findById(id).map(x -> {
	      x.setLibele(newDepense.getLibele());
	      x.setMontant(newDepense.getMontant());
	      x.setNote(newDepense.getNote());
	      x.setDate(newDepense.getDate());
	      return depenseRepository.save(x);
	    })
	    .orElseGet(() -> {
	    	newDepense.setId(id);
	      return depenseRepository.save(newDepense);
	    });
	}


	  
	  @DeleteMapping("/depense/{id}")
	  void deleteDepense(@PathVariable int id) {
		  depenseRepository.deleteById(id);
	  }
// Pour les dettes

	 @PostMapping(path="/dette/add") 
		  public @ResponseBody String addNewDette (@RequestParam String personne,@RequestParam String delai, @RequestParam float montant,
				  @RequestParam String note) {

			  Dette n = new Dette();
		    n.setPersonne(personne);
		    n.setDelai(delai);
		    n.setMontant(montant);
		    n.setNote(note);
		    detteRepository.save(n);
		    return "Saved";
		  }

		  @GetMapping(value = "/dette/{id}")
		  @ResponseBody
		  public Optional<Dette> GetDetteById(@PathVariable int id){
		      return detteRepository.findById(id);
		  }


		  
		  @GetMapping(path="/dettes")
		  public @ResponseBody Iterable<Dette> getAllDette() {
		    
		    return detteRepository.findAll();
		  }
		  
		 		@PutMapping("/dette/{id}")
		Dette replaceDette(@RequestBody Dette newDette, @PathVariable int id) {

		  return detteRepository.findById(id).map(x -> {
		      x.setPersonne(newDette.getPersonne());
		      x.setMontant(newDette.getMontant());
		      x.setNote(newDette.getNote());
		      x.setDelai(newDette.getDelai());
		      return detteRepository.save(x);
		    })
		    .orElseGet(() -> {
		    	newDette.setId(id);
		      return detteRepository.save(newDette);
		    });
		}


		  
		  @DeleteMapping("/dette/{id}")
		  void deleteDette(@PathVariable int id) {
			  detteRepository.deleteById(id);
		  }


}
