package com.coding.dojo.book.club.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.coding.dojo.book.club.models.Book;
import com.coding.dojo.book.club.models.LoginUser;
import com.coding.dojo.book.club.models.User;
import com.coding.dojo.book.club.services.BookService;
import com.coding.dojo.book.club.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class BookController {

	// Add once service is implemented:
	@Autowired
	private UserService users;
	@Autowired
	private BookService books;

	@GetMapping("/")
	public String index(Model model) {

		// Bind empty User and LoginUser objects to the JSP
		// to capture the form input
		model.addAttribute("newUser", new User());
		model.addAttribute("newLogin", new LoginUser());
		return "index.jsp";
	}

	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("newUser") User newUser, BindingResult result, Model model,
			HttpSession session) {

		// Call a register method in the service
		// to do some extra validations and create a new user!
		User user = users.register(newUser, result);

		if (result.hasErrors()) {
			// Be sure to send in the empty LoginUser before
			// re-rendering the page.
			model.addAttribute("newLogin", new LoginUser());
			return "index.jsp";
		}

		// No errors!
		// TO-DO Later: Store their ID from the DB in session,
		// in other words, log them in.
		session.setAttribute("userId", user.getId());

		return "redirect:/home";
	}

	@PostMapping("/login")
	public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, BindingResult result, Model model,
			HttpSession session) {

		// Add once service is implemented:
		User user = users.login(newLogin, result);

		if (result.hasErrors()) {
			model.addAttribute("newUser", new User());
			return "index.jsp";
		}

		// No errors!
		// Store their ID from the DB in session,
		// in other words, log them in.
		session.setAttribute("userId", user.getId());

		return "redirect:/home";
	}

	@GetMapping("/home")
	public String home(Model model, HttpSession session) {

		if (session.getAttribute("userId") == null) {
			return "redirect:/";
		}

		model.addAttribute("books", books.allBooks());
		model.addAttribute("user", users.findById((Long) session.getAttribute("userId")));
		return "home.jsp";
	}

	@GetMapping("/addPage")
	public String addPage(@ModelAttribute("book") Book book, Model model, HttpSession session) {

		User user = users.findById((Long) session.getAttribute("userId"));
		model.addAttribute("user", user);

		return "addPage.jsp";
	}

	@PostMapping("/books")
	public String createBook(@Valid @ModelAttribute("book") Book book, BindingResult result) {

		if (result.hasErrors()) {
			return "addPage.jsp";
		}

		books.createBook(book);

		return "redirect:/home";
	}

	@GetMapping("/books/{id}")
	public String showPage(Model model, @PathVariable("id") Long id, HttpSession session) {
		if (session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		Book book = books.findBook(id);
		model.addAttribute("book", book);
		model.addAttribute("user", users.findById((Long) session.getAttribute("userId")));

		return "book.jsp";
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	@GetMapping("/books/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model) {
        Book book = books.findBook(id);
        model.addAttribute("book", book);
        return "editPage.jsp";
    }
	
	@PutMapping(value="/books/{id}")
    public String update(@Valid @ModelAttribute("book") Book book, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("book", book);
            return "editPage.jsp";
        } else {
            books.updateBook(book);
            return "redirect:/home";
        }
    }
	
	@DeleteMapping("/books/{id}")
    public String destroy(@PathVariable("id") Long id) {
        books.deleteBook(id);
        return "redirect:/home";
    }
	
	@GetMapping("/books/{id}/borrow")
    public String borrowBook(@PathVariable("id") Long id, HttpSession session) {
    	if(session.getAttribute("userId") == null) {
    		return "redirect:/";
    	}
    	Book book = books.findBook(id);
    	book.setBorrower(users.findById((Long)session.getAttribute("userId")));
    	books.updateBook(book);
    	
    	return "redirect:/home";
    }
    
    @GetMapping("/books/{id}/return")
    public String returnBook(@PathVariable("id") Long id, HttpSession session) {
    	if(session.getAttribute("userId") == null) {
    		return "redirect:/";
    	}
    	Book book = books.findBook(id);
    	book.setBorrower(null);
    	books.updateBook(book);
    	
    	return "redirect:/home";
    }

}
