package model.shop.service.product;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

import model.shop.dao.product.ProductDAO;
import model.shop.dto.product.ProductDTO;

@Service
public class ProductServiceImpl implements ProductSerivce {

	@Autowired
	ProductDAO productDao;
	
	@Autowired
	private DataSource datasource;
	
	@Override
	public List<ProductDTO> listProduct() {
		String sql="Select * from product";
		List<ProductDTO> list=new ArrayList<ProductDTO>();
		try {
			Connection con=datasource.getConnection();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			
			while(rs.next()) {
				int id=rs.getInt("PRODUCT_ID");
				String name= rs.getString("PRODUCT_NAME");
				int price=rs.getInt("price");
				String description=rs.getString("DESCRIPTION");
				String url=rs.getString("PICTURE_URL");
				list.add(new ProductDTO(id,name,price,description,url));
			
			}
			rs.close();
			st.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public ProductDTO detailProduct(int product_id) {
		String sql="Select * from product where product_id=?";
		ProductDTO pd=new ProductDTO();
		try {
			Connection con=datasource.getConnection();
			PreparedStatement st=con.prepareStatement(sql);
			st.setInt(1, product_id);
			ResultSet rs=st.executeQuery();
			
			rs.next();
			int id=rs.getInt("PRODUCT_ID");
			String name= rs.getString("PRODUCT_NAME");
			int price=rs.getInt("price");
			String description=rs.getString("DESCRIPTION");
			String url=rs.getString("PICTURE_URL");
			pd=new ProductDTO(id, name, price, description, url);
			
			rs.close();
			st.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return pd;
	}

	@Override
	public void updateProduct(ProductDTO product) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteProduct(int product_id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void insertProduct(ProductDTO product) {
		productDao.insertProduct(product);
	}

	@Override
	public String fileInfo(int product_id) {
		// TODO Auto-generated method stub
		return null;
	}

}
