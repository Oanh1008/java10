package view;

import java.sql.Connection;
import java.util.List;
import java.util.Properties;

import connection.DbProvider;
import connection.Dbconnection;
import persistence.ItemGroup;
import service.ItemGroupService;

public class App {
	private static ItemGroupService itemGroupService;
	static {
		itemGroupService=new ItemGroupService();
	}
	public static void main(String[] args) {
		
		
		Connection connection=Dbconnection.getConnection();
		System.out.println(connection);
		// get all item group 
		List<ItemGroup>igrs= itemGroupService.getItemGroup();
		igrs.forEach(System.out::println);
		System.out.println("========================");
		ItemGroup igrsId= itemGroupService.getItemGroup(3);
		System.out.println(igrsId);
		
		System.out.println("========================");
		List<ItemGroup>igrsName= itemGroupService.getItemGroup("banh keo");
		igrsName.forEach(System.out::println);
		
		System.out.println("========================");
		boolean save= itemGroupService.save(new ItemGroup(22, "ItemGroup22"));
		System.out.println("inserted: "+save);
		
		itemGroupService.getItemGroup().forEach(System.out::println);
		
		
	}
}
