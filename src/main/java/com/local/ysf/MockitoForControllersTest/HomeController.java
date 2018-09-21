package com.local.ysf.MockitoForControllersTest;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mocking")
public class HomeController {

	private List<Books> listOfBooks;
	
	@GetMapping("/hello")
	public String sayHello() {
		return "hello world!";
	}
	
	@GetMapping("/Book")
	public Books findBook() {
		return new Books("title n ° 0", "auteur n ° 0");
	}
	
	@GetMapping("/Book/{bookTitle}")
	public Books findBookByTitle(@PathVariable String bookTitle) {
	List<Books> allBooks = allBooks();
		Books myBook = allBooks.stream().filter(book->book.equals(bookTitle))
		.findAny()                                      // If 'findAny' then return found
        .orElse(null);
			System.out.println(myBook.toString());// if not return null
		return myBook;
	}
	
	public List<Books> allBooks(){
		listOfBooks = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			listOfBooks.add(new Books("title"+i,"auteur"+i));
		}
		return listOfBooks;
	}
}
