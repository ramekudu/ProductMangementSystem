package com.lpg.prodmangsys.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "CATEGORIES")
public class Categories {

	@Id
	@GeneratedValue
	private UUID id;
	@Column(name = "CATEGORY_NAME", length = 100, nullable = false)
	private String categoryName;


}
