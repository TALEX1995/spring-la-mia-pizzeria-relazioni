package org.java.spring;

import org.java.spring.db.serv.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringLaMiaPizzeriaCrudApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringLaMiaPizzeriaCrudApplication.class, args);
	}

	@Autowired
	private PizzaService pizzaService;
	
	@Override
	public void run(String... args) throws Exception {
		
		pizzaService.save(new Pizza("Pizza Margherita", "Una normale pizza", "https://upload.wikimedia.org/wikipedia/commons/c/c8/Pizza_Margherita_stu_spivack.jpg", 5.99f));
		pizzaService.save(new Pizza("Pizza Crostino", "Una pizza con prosciutto e mozzarella", "https://hallopizza.it/wp-content/uploads/2015/03/IMG_0109.jpg", 6.99f));
		pizzaService.save(new Pizza("Pizza Boscaiola", "Una pizza con funghi", "https://media-cdn.tripadvisor.com/media/photo-s/1c/67/4a/a9/pizza-boscaiola.jpg", 7.99f));
		pizzaService.save(new Pizza("Pizza Rossa", "Una pizza con pomodoro", "https://media-cdn.tripadvisor.com/media/photo-s/1c/67/4a/a9/pizza-boscaiola.jpg", 7.99f));
		pizzaService.save(new Pizza("Pizza alici", "Una pizza con alici", "https://media-cdn.tripadvisor.com/media/photo-s/1c/67/4a/a9/pizza-boscaiola.jpg", 7.99f));
		pizzaService.save(new Pizza("Pizza Wurstel e patatine", "Una pizza wurstel e patatine", "https://i0.wp.com/www.piccolericette.net/piccolericette/wp-content/uploads/2017/11/3244_Pizza.jpg?resize=895%2C616&ssl=1", 7.99f));
	}

}
