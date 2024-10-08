/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yumxpress.dao;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.imageio.ImageIO;
import yumxpress.dbutil.DBConnection;
import yumxpress.pojo.ProductPojo;

/**
 *
 * @author Swadesh Sharma
 */
public class ProductDao {
    public static String getNewProductId() throws SQLException{
        Connection conn=DBConnection.getConnection();
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery("select max(product_id) from products");
        rs.next();
        String id=rs.getString(1);
        String prodId="";
        if(id!=null){
            id=id.substring(4);
            prodId="PRD-"+(Integer.parseInt(id)+1);
        }else{
            prodId="PRD-101";
        }
        return prodId;
    }
    
    public static boolean addProduct(ProductPojo product)throws SQLException, IOException{
        BufferedImage bufferedImage = new BufferedImage(product.getProductImage().getWidth(null),product.getProductImage().getHeight(null),BufferedImage.TYPE_INT_RGB);
        Graphics gr=bufferedImage.getGraphics();
        gr.drawImage(product.getProductImage(), 0, 0, null);
    
        ByteArrayOutputStream baos= new ByteArrayOutputStream();
        ImageIO.write(bufferedImage, product.getProductImgType(),baos);
        byte[] imageData=baos.toByteArray();
        
        ByteArrayInputStream bais=new ByteArrayInputStream(imageData);
        
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("insert into products values(?,?,?,?,?)");
        ps.setString(1, getNewProductId());
        ps.setString(2, product.getCompanyId());
        ps.setString(3, product.getProductName());
        ps.setDouble(4, product.getProductPrice());
        ps.setBinaryStream(5, bais, imageData.length);
        int x=ps.executeUpdate();
        return x>0;
    }
    
    public static Map<String,ProductPojo> getProductDetailsByCompanyId(String companyId) throws SQLException,IOException{
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("select * from products where company_id=?");
        ps.setString(1, companyId);
        ResultSet rs=ps.executeQuery();
        Map<String,ProductPojo> productDetails=new HashMap<>();
        while(rs.next()){
            ProductPojo product=new ProductPojo();
            product.setProductName(rs.getString(3));
            product.setProductPrice(rs.getDouble(4));
            
            InputStream inputStream=rs.getBinaryStream("product_image");
            
            BufferedImage bufferedImage=ImageIO.read(inputStream);
            Image image=bufferedImage;
            
            product.setProductImage(image);
            productDetails.put(product.getProductName(), product);
            
        }
        return productDetails;
    }   
    
    public static List<ProductPojo> getAllProductsByCompanyId(String companyId)throws SQLException,IOException{
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps;
        if(companyId.equalsIgnoreCase("all")){
            ps=conn.prepareStatement("select * from products where company_id in(select distinct company_id from companies where status='Active')");            
        }
        else{
            ps=conn.prepareStatement("select * from products where company_id=?");
            ps.setString(1, companyId);
        }
        ResultSet rs=ps.executeQuery();
        List<ProductPojo> productDetails=new ArrayList<>();
        while(rs.next()){
            ProductPojo product=new ProductPojo();
            product.setProductName(rs.getString(3));
            product.setProductPrice(rs.getDouble(4));
            product.setCompanyId(rs.getString("company_id"));
            product.setProductId(rs.getString("product_id"));
                        
            InputStream inputStream=rs.getBinaryStream("product_image");
            
            BufferedImage bufferedImage=ImageIO.read(inputStream);
            Image image=bufferedImage;
            
            product.setProductImage(image);
            productDetails.add(product);
            
        }
        return productDetails;
    }
}
