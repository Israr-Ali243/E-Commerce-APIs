package com.myproject01.myproject01;

import com.myproject01.myproject01.entity.Category;
import com.myproject01.myproject01.entity.Product;
import com.myproject01.myproject01.entity.User;
import com.myproject01.myproject01.repository.ProductRepository;
import com.myproject01.myproject01.repository.UserRepository;
import jakarta.persistence.Access;
import org.assertj.core.api.AssertionsForClassTypes;
//import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

@SpringBootTest
class Myproject01ApplicationTests {

	@Autowired
	ProductRepository productRepository;
	@Autowired
	UserRepository userRepository;

	@Test
	void contextLoads() {

	}

	@Test
	public void TestProduct(){
		Product product = new Product();
		product.setProductId(302);
		product.setProductDescription("This is a Mobile");
		product.setProductPrice(400);

		Category category = new Category();
		category.setCategoryId(1);
		category.setCategoryTitle("Mobile");
		category.setCategoryDescribtion("It is a Mobile");


		product.setCategory(category);

		User user = new User();
		user.setId(452);
		user.setUserAddress("karachi");
		user.setName("Iarar ALi");
		user.setPhoneNumber("03453991846");
		user.setUserPic("defult.png");
		user.setEmail("k213840@nu.edu.pk");
		user.setPassword("abcde");

		product.setUser(user);

		product.setAddDate(new Date());
		product.setInStock(true);
		product.setProducttitle("Samsung S20 Ultra");
//		product.setImageName("defult.png");
		this.productRepository.save(product);
//		Assert.assertNotNull(productRepository.findById(Long.valueOf(1)).get());

	}

	@Test
	public void testAllProduct(){
		List<Product> products = this.productRepository.findAll();
		AssertionsForClassTypes.assertThat(products);
	}


	@Test
	public void TestSingleProduct(){
		Product product =this.productRepository.findById(Long.valueOf(102)).get();
//		Assert.assertEquals(400, product.getProductPrice());
	}

	@Test
	public  void TestUser(){
		User user = new User();
		user.setId(1);
		user.setName("israr ali");
		user.setUserAddress("karachi");
		user.setUserPic("defult.png");
		user.setPhoneNumber("03453991846");
		user.setEmail("aisrar243@gmail.com");
		user.setPassword("Abc12");
		this.userRepository.save(user);
//		Assert.assertNotNull(userRepository.findById(Long.valueOf(302)).get());
	}

	@Test
	public void TestSingleUser(){
		User user =this.userRepository.findById(Long.valueOf(302)).get();
//		Assert.assertEquals("123", user.getPassword());
	}


	@Test
	public void testDeleteUser(){
		this.userRepository.deleteById(302L);
		AssertionsForClassTypes.assertThat(this.userRepository.existsById(1L)).isFalse();
	}

}
