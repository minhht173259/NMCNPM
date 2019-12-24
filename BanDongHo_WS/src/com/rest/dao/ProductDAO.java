package com.rest.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.rest.utils.model.ProductObject;

public class ProductDAO {
	private static SQLconnection factory = new SQLconnection();

	public static List<ProductObject> getListAllProduct() throws ClassNotFoundException {
		ResultSet res = null;
		List<ProductObject> products = new ArrayList<ProductObject>();
		PreparedStatement preStmt = null;
		String sqlQuery = "SELECT * FROM product";
		try {
			preStmt = factory.getConnectionDB().prepareStatement(sqlQuery);
			res = preStmt.executeQuery();
			while (res != null && res.next()) {
				ProductObject product = new ProductObject();
				product.setId(res.getObject("id").toString() != null ? Integer.valueOf(res.getObject("id").toString()) : null);
				product.setName(res.getObject("name").toString() != null ? res.getObject("name").toString() : "");
				product.setPrice(res.getObject("price").toString() != null ? Integer.valueOf(res.getObject("price").toString()) : 0);
				product.setImage(res.getObject("image").toString() != null ? res.getObject("image").toString() : "");
				product.setBrand(res.getObject("brand").toString() != null ? res.getObject("brand").toString() : "");
				product.setDetail(res.getObject("detail").toString() != null ? res.getObject("detail").toString() : "");
				product.setOrigin(res.getObject("origin").toString() != null ? res.getObject("origin").toString() : "");

				products.add(product);
			}
			preStmt.close();
		} catch (SQLException e) {
			System.out.print(e.toString());
		}
		return products;
	}

	public static int getTotalAll() throws ClassNotFoundException {
		ResultSet res = null;
		int total = 0;
		PreparedStatement preStmt = null;
		String sqlQuery = "SELECT COUNT(*) AS 'TOTAL' FROM product";
		try {
			preStmt = factory.getConnectionDB().prepareStatement(sqlQuery);
			res = preStmt.executeQuery();
			while (res != null && res.next()) {
				total = res.getInt("TOTAL");
			}
			preStmt.close();
		} catch (SQLException e) {
			System.out.print(e.toString());
		}
		return total;
	}

	public static List<ProductObject> getListProductByBrand(String brand) throws ClassNotFoundException {
		ResultSet res = null;
		List<ProductObject> products = new ArrayList<ProductObject>();
		PreparedStatement preStmt = null;
		String sqlQuery = "SELECT * FROM product where brand='" + brand + "'";
		try {
			preStmt = factory.getConnectionDB().prepareStatement(sqlQuery);
			res = preStmt.executeQuery();
			while (res != null && res.next()) {
				ProductObject product = new ProductObject();
				product.setId(res.getObject("id").toString() != null ? Integer.valueOf(res.getObject("id").toString()) : null);
				product.setName(res.getObject("name").toString() != null ? res.getObject("name").toString() : "");
				product.setPrice(res.getObject("price").toString() != null ? Integer.valueOf(res.getObject("price").toString()) : 0);
				product.setImage(res.getObject("image").toString() != null ? res.getObject("image").toString() : "");
				product.setBrand(res.getObject("brand").toString() != null ? res.getObject("brand").toString() : "");
				product.setDetail(res.getObject("detail").toString() != null ? res.getObject("detail").toString() : "");
				product.setOrigin(res.getObject("origin").toString() != null ? res.getObject("origin").toString() : "");

				products.add(product);
			}
			preStmt.close();
		} catch (SQLException e) {
			System.out.print(e.toString());
		}
		return products;
	}

	public static int getTotalAllByBrand(String brand) throws ClassNotFoundException {
		ResultSet res = null;
		int total = 0;
		PreparedStatement preStmt = null;
		String sqlQuery = "SELECT COUNT(*) AS 'TOTAL' FROM product where brand='" + brand + "'";
		try {
			preStmt = factory.getConnectionDB().prepareStatement(sqlQuery);
			res = preStmt.executeQuery();
			while (res != null && res.next()) {
				total = res.getInt("TOTAL");
			}
			preStmt.close();
		} catch (SQLException e) {
			System.out.print(e.toString());
		}
		return total;
	}

	public static ProductObject getDetailProductById(String id) throws ClassNotFoundException {
		ResultSet res = null;
		ProductObject product = new ProductObject();
		PreparedStatement preStmt = null;
		String sqlQuery = "SELECT * FROM product where id='" + id + "'";
		try {
			preStmt = factory.getConnectionDB().prepareStatement(sqlQuery);
			res = preStmt.executeQuery();
			while (res != null && res.next()) {
				product.setId(res.getObject("id").toString() != null ? Integer.valueOf(res.getObject("id").toString()) : null);
				product.setName(res.getObject("name").toString() != null ? res.getObject("name").toString() : "");
				product.setPrice(res.getObject("price").toString() != null ? Integer.valueOf(res.getObject("price").toString()) : 0);
				product.setImage(res.getObject("image").toString() != null ? res.getObject("image").toString() : "");
				product.setBrand(res.getObject("brand").toString() != null ? res.getObject("brand").toString() : "");
				product.setDetail(res.getObject("detail").toString() != null ? res.getObject("detail").toString() : "");
				product.setOrigin(res.getObject("origin").toString() != null ? res.getObject("origin").toString() : "");
			}
			preStmt.close();
		} catch (SQLException e) {
			System.out.print(e.toString());
		}
		return product;
	}

	public static String deleteProductById(String id) throws ClassNotFoundException {
		String result = "KO";
		PreparedStatement preStmt = null;
		String sqlQuery = "DELETE FROM sanpham WHERE id='" + id + "'";
		try {
			preStmt = factory.getConnectionDB().prepareStatement(sqlQuery);
			preStmt.executeUpdate();
			preStmt.close();
			result = "OK";
		} catch (SQLException e) {
			System.out.print(e.toString());
		}
		return result;
	}

	public static String updateProduct(ProductObject product) throws ClassNotFoundException {
		String result = "KO";
		PreparedStatement preStmt = null;
		String sqlQuery = "UPDATE sanpham SET name=?, price=?, image=?, xuatxu=? WHERE id = ?";
		try {
			preStmt = factory.getConnectionDB().prepareStatement(sqlQuery);
			preStmt.setString(1, product.getName());
			preStmt.setInt(2, product.getPrice());
			preStmt.setString(3, product.getImage());
			preStmt.setString(4, product.getOrigin());
			preStmt.setInt(5, product.getId());
			preStmt.executeUpdate();
			preStmt.close();
			result = "OK";
		} catch (Exception ex) {
		}
		return result;
	}

	public static String insertProduct(ProductObject product) throws ClassNotFoundException {
		String result = "KO";
		PreparedStatement preStmt = null;
		String sqlQuery = "insert into sanpham(name,price,image,thuonghieu,mota,xuatxu) values('" + product.getName() + "','" + product.getPrice() + "','"
				+ product.getImage() + "','" + product.getBrand() + "','" + product.getOrigin() + "','" + product.getDetail() + "')";
		try {
			preStmt = factory.getConnectionDB().prepareStatement(sqlQuery);
			preStmt.executeUpdate(sqlQuery);
			preStmt.close();
			result = "OK";
		} catch (Exception ex) {
		}
		return result;
	}

	public static List<ProductObject> getListProductByName(String name) throws ClassNotFoundException {
		ResultSet res = null;
		List<ProductObject> products = new ArrayList<ProductObject>();
		PreparedStatement preStmt = null;
		String sqlQuery = "SELECT * from sanpham where name = '" + name + "'";
		try {
			preStmt = factory.getConnectionDB().prepareStatement(sqlQuery);
			res = preStmt.executeQuery();
			while (res != null && res.next()) {
				ProductObject product = new ProductObject();
				product.setId(res.getObject("id").toString() != null ? Integer.valueOf(res.getObject("id").toString()) : null);
				product.setName(res.getObject("name").toString() != null ? res.getObject("name").toString() : "");
				product.setPrice(res.getObject("price").toString() != null ? Integer.valueOf(res.getObject("price").toString()) : 0);
				product.setImage(res.getObject("image").toString() != null ? res.getObject("image").toString() : "");
				product.setBrand(res.getObject("brand").toString() != null ? res.getObject("brand").toString() : "");
				product.setDetail(res.getObject("detail").toString() != null ? res.getObject("detail").toString() : "");
				product.setOrigin(res.getObject("origin").toString() != null ? res.getObject("origin").toString() : "");

				products.add(product);
			}
			preStmt.close();
		} catch (SQLException e) {
			System.out.print(e.toString());
		}
		return products;
	}

	public static int getNumberProductByName(String name) throws ClassNotFoundException {
		int number = 0;
		ResultSet res = null;
		PreparedStatement preStmt = null;
		String sqlQuery = "SELECT COUNT(*) AS 'TOTAL' FROM sanpham WHERE name = '" + name + "'";
		try {
			preStmt = factory.getConnectionDB().prepareStatement(sqlQuery);
			res = preStmt.executeQuery();
			if (res != null && res.next()) {
				number = res.getInt("TOTAL");
			}
			preStmt.close();
		} catch (SQLException e) {
			System.out.print(e.toString());
		}
		return number;
	}
	
	public static List<ProductObject> getAllProudctPage(String brand, int start, int display) throws ClassNotFoundException {
		ResultSet res = null;
		List<ProductObject> products = new ArrayList<ProductObject>();
		PreparedStatement preStmt = null;
		String sqlQuery = "";
		if ("".equalsIgnoreCase(brand)) {
			sqlQuery = "SELECT * FROM product ORDER BY id LIMIT " + start + "," + display + "";
		} else {
			sqlQuery = "SELECT * FROM product WHERE brand ='" + brand + "'ORDER BY id LIMIT " + start + "," + display + "";
		}
		try {
			preStmt = factory.getConnectionDB().prepareStatement(sqlQuery);
			res = preStmt.executeQuery();
			while (res != null && res.next()) {
				ProductObject product = new ProductObject();
				product.setId(res.getObject("id").toString() != null ? Integer.valueOf(res.getObject("id").toString()) : null);
				product.setName(res.getObject("name").toString() != null ? res.getObject("name").toString() : "");
				product.setPrice(res.getObject("price").toString() != null ? Integer.valueOf(res.getObject("price").toString()) : 0);
				product.setImage(res.getObject("image").toString() != null ? res.getObject("image").toString() : "");
				product.setBrand(res.getObject("brand").toString() != null ? res.getObject("brand").toString() : "");
				product.setDetail(res.getObject("detail").toString() != null ? res.getObject("detail").toString() : "");
				product.setOrigin(res.getObject("origin").toString() != null ? res.getObject("origin").toString() : "");

				products.add(product);
			}
			preStmt.close();
		} catch (SQLException e) {
			System.out.print(e.toString());
		}
		return products;
	}

}
