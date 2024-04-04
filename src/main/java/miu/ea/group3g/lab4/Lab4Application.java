package miu.ea.group3g.lab4;

import lombok.RequiredArgsConstructor;
import miu.ea.group3g.lab4.entity.Product;
import miu.ea.group3g.lab4.entity.Review;
import miu.ea.group3g.lab4.entity.User;
import miu.ea.group3g.lab4.repository.ProductRepository;
import miu.ea.group3g.lab4.repository.ReviewRepository;
import miu.ea.group3g.lab4.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@SpringBootApplication
@RequiredArgsConstructor
public class Lab4Application implements CommandLineRunner {

	private final UserRepository userRepository;
	private final ProductRepository productRepository;
	private final ReviewRepository reviewRepository;

	private static final int NUM_USERS = 100;
	private static final int NUM_PRODUCTS = 1000;
	private static final int NUM_REVIEWS_PER_PRODUCT = 1000;

	@Override
	public void run(String... args) throws Exception {
		/*
		// Populate users
		List<User> users = new ArrayList<>();
		for (int i = 0; i < NUM_USERS; i++) {
			User user = new User();
			user.setName("User " + i);
			users.add(user);
		}
		userRepository.saveAll(users);

		// Populate products and reviews
		Random random = new Random();
		for (int i = 0; i < NUM_PRODUCTS; i++) {
			Product product = new Product();
			product.setName("Product " + i);
			product.setPrice(BigDecimal.valueOf(random.nextDouble() * 1000)); // Random price

			List<Review> reviews = new ArrayList<>();
			for (int j = 0; j < NUM_REVIEWS_PER_PRODUCT; j++) {
				Review review = new Review();
				review.setComment("Review " + j + " for product " + i);
				review.setUser(users.get(random.nextInt(NUM_USERS))); // Assign random user
				review.setProduct(product);
				reviews.add(review);
			}

			product.setReviews(reviews);
			productRepository.save(product);

			reviewRepository.saveAll(reviews);
		}
		 */
	}

	public static void main(String[] args) {
		SpringApplication.run(Lab4Application.class, args);
	}

}
