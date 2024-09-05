/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yumxpress.pojo;

import java.awt.Image;

/**
 *
 * @author Swadesh Sharma
 */
public class ProductPojo {
    
    private String productId;
    private String companyId;
    private String productName;
    private double productPrice;
    private Image productImage;
    private String productImgType;

    @Override
    public String toString() {
        return "ProductPojo{" + "productId=" + productId + ", companyId=" + companyId + ", productName=" + productName + ", productPrice=" + productPrice + ", productImage=" + productImage + ", productImgType=" + productImgType + '}';
    }
    
    public ProductPojo(){}

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public Image getProductImage() {
        return productImage;
    }

    public void setProductImage(Image productImage) {
        this.productImage = productImage;
    }

    public String getProductImgType() {
        return productImgType;
    }

    public void setProductImgType(String productImgType) {
        this.productImgType = productImgType;
    }

    public ProductPojo(String productId, String companyId, String productName, double productPrice, Image productImage, String productImgType) {
        this.productId = productId;
        this.companyId = companyId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productImage = productImage;
        this.productImgType = productImgType;
    }
    
    
}
