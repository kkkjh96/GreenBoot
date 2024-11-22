package com.ex01_241122.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "tbl_provider")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Provider {	// 공급업체

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String name;
	
	//부모 밑에는 여러자식(product)이 존재 할 수 있으나 자식은 부모(provider)가 여러명 존재 할 수 가 없다.
	//fetchtype 속성 : eager 즉시반영 lazy 지연반영
	@OneToMany(mappedBy = "provider", cascade = CascadeType.PERSIST)
	private List<Product> productList = new ArrayList<>();
	
	
}
