package palvelinohjelmointi.setlist.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import palvelinohjelmointi.setlist.domain.Gig;
import palvelinohjelmointi.setlist.domain.GigRepository;

@Controller
public class GigController {

	@Autowired
	public GigRepository gigRepo;
	
	// show all the gigs
	@GetMapping("giglist")
	public String giglist(Model model) {
		System.out.println("controller.gigList");
		model.addAttribute("gigs", gigRepo.findAll());
		return "giglist";
	}
	@ModelAttribute
	private Gig getGig() {
		return new Gig();
	}
	
	//add a gig
	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping("addGig")
	public String addGig(Model model) {
		model.addAttribute("gig", new Gig());
		return "addGig";
	}
	
	//save a gig
	@PreAuthorize("hasAuthority('ADMIN')")
	@PostMapping("saveGig")
	public String saveGig(@Valid @ModelAttribute Gig gig, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			
			return "addGig";
		}
		gigRepo.save(gig);
		return "redirect:giglist";
	}
	
	//edit a gig
	@PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping(value = "/editGig/{id}")
    public String updateGig(@PathVariable("id") Long id, Model model) {
    	Gig gig = gigRepo.findById(id).get();
    	System.out.println("update gig " + gig.toString());
    	model.addAttribute("gig", gig);
    	return "editGig";
}

	//delete a gig
    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/deleteGig/{id}", method = RequestMethod.GET)
    public String deleteGig(@PathVariable("id") Long id, Model model) {
    	System.out.println("gig "  + id);
    	gigRepo.deleteById(id);
    	return "redirect:../giglist";
    }
}
