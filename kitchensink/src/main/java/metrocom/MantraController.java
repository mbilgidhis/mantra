package metrocom;

import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MantraController {
	@GetMapping("/")
	   public String redirect() {
	      return "redirect:greeting";
	   }
	
	@GetMapping("/greeting")
	public String showForm(Model model) {
		Greeting greeting = new Greeting();
		model.addAttribute("greeting", greeting);
		return "greeting";
	}
	
	@PostMapping("/greeting")
	public String resultGreeting(@ModelAttribute Greeting greeting) {
		Random generator = new Random();
		String mantra[] = {
				"Work smarter, not harder.", 
				"Progress, not perfection.", 
				"All is well.", 
				"Talk less, listen more.", 
				"See the good.", 
				"Do the things you love.", 
				"Enjoy today.", 
				"Make a difference.",
				"Be peaceful, happy and whole.",
				"Keep moving forward.",
				"Aim for excellence, not perfection.",
				"Every day is precious.",
				"Action expresses priorities.",
				"Be kind to yourself."
			};
		int index = generator.nextInt(mantra.length);
		greeting.setMantra(mantra[index]);
		return "result";
	}
}
