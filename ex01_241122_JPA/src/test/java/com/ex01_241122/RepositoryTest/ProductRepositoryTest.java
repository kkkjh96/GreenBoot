package com.ex01_241122.RepositoryTest;

import java.util.Optional;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ex01_241122.entity.Product;
import com.ex01_241122.entity.ProductDetail;
import com.ex01_241122.entity.Provider;
import com.ex01_241122.repository.ProductDetailRepository;
import com.ex01_241122.repository.ProductRepository;
import com.ex01_241122.repository.ProviderRepository;

@SpringBootTest
class ProductRepositoryTest {

	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	ProductDetailRepository productDetailRepository;
	
	@Autowired
	ProviderRepository providerRepository;
	
//	@Test
	void saveAndReadTest1() {
		// 생성 및 등록
		Product product = new Product();
		product.setPname("스프링부트 JPA");
		product.setPrice(5000);
		
		productRepository.save(product);
		
		ProductDetail productDetail = new ProductDetail();
		productDetail.setDescription("스프링부트와 JPA를 함께 볼 수 있는 책");
		productDetail.setProduct(product);
		
		productDetailRepository.save(productDetail);
		
		// 조회
		Optional<ProductDetail> result = productDetailRepository.findById(productDetail.getId());
		
		ProductDetail pd = result.get();
		
		System.out.println("saveProduct : " + pd.getProduct());
		System.out.println("saveProductDetail : " + 
							productDetailRepository.findById(productDetail.getId()).get());
		System.out.println("saveProductName : " + 
				pd.getProduct().getPname());
		
	}

//	@Test
	void relationshipTest1() {
		//테스트 데이터 생성
		Provider provider = new Provider();
		provider.setName("OO 물산");
		
		providerRepository.save(provider);
		
		Product product = new Product();
		product.setPname("가위");
		product.setPrice(1000);
		product.setProvider(provider);
		
		productRepository.save(product);
		
		System.out.println("product : " + productRepository.findById(1).get());
		
		System.out.println("provider : " + productRepository.findById(1).get().getProvider());
		
	}

	@Test
	void cascadeTest() {
		Provider provider = savedProvider("새로운 공급업체");
		
		Product product1 = savedProduct("상품1", 1000);
		Product product2 = savedProduct("상품2", 2000);
		Product product3 = savedProduct("상품3", 3000);
		
		//연관관계 설정
		product1.setProvider(provider);
		product2.setProvider(provider);
		product3.setProvider(provider);
		
		provider.getProductList().addAll(Lists.newArrayList(product1, product2, product3));
		
		providerRepository.save(provider);
		
		
		
	}

	private Provider savedProvider(String name) {
		Provider provider = new Provider();
		provider.setName(name);
		
		return provider;
	}
	
	private Product savedProduct(String name, int price) {
		Product product = new Product();
		product.setPname(name);
		product.setPrice(price);
		
		return product;
	}
	
}
