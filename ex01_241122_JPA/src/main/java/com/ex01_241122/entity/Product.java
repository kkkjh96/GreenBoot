package com.ex01_241122.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "tbl_product")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pno;
	@Column(nullable = false)
	private String pname;
	@Column(nullable = false)
	private int price;
	
	//양방향 관계를 설정 했을 때 외래키를 가지고 있는 컬럼을 주인으로 한다.
//	@OneToMany
//	@ToString.Exclude
	@OneToOne(mappedBy = "product")
	private ProductDetail productDetail;
	
	@ManyToOne
	@JoinColumn(name = "provider_id")
	private Provider provider;
	
}
