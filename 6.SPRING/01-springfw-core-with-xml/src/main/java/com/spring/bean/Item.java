package com.spring.bean;

import java.util.List;

/**
 * Plain Object
 * 
 * @author Oanhpv1008
 *
 */
public class Item {
	private Integer id;
	private String name;
	private List<String> providers;
	private ItemGroup itemGroup;

	public Item() {
	}

	public Item(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getProviders() {
		return providers;
	}

	public void setProviders(List<String> providers) {
		this.providers = providers;
	}

	public ItemGroup getItemGroup() {
		return itemGroup;
	}

	public void setItemGroup(ItemGroup itemGroup) {
		this.itemGroup = itemGroup;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", providers=" + providers + ", itemGroup=" + itemGroup + "]";
	}

}
