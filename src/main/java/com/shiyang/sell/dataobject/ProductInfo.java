package com.shiyang.sell.dataobject;

import org.hibernate.annotations.DynamicUpdate;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @description: 商品信息
 * @author: W
 * @create: 2019-08-09 10:52
 **/
@Entity
@DynamicUpdate
public class ProductInfo {
    
    @Id
    private String productId;
    
    /** 商品名称 */
    private String productName;
    
    /** 商品单价 */
    private BigDecimal productPrice;
    
    /** 库存 */
    private Integer productStock;
    
    /** 描述 */
    private String productDescription;
    
    /** 小图 */
    private String productIcon;
    
    /** 商品状态, 0正常1下架 */
    private Integer productStatus;
    
    /** 类目编号 */
    private Integer categoryType;
    
    /** 创建时间 */
    private Date createTime;
    
    /** 更新时间 */
    private Date updateTime;
    
    public String getProductId() {
        return productId;
    }
    
    public void setProductId(String productId) {
        this.productId = productId;
    }
    
    public String getProductName() {
        return productName;
    }
    
    public void setProductName(String productName) {
        this.productName = productName;
    }
    
    public BigDecimal getProductPrice() {
        return productPrice;
    }
    
    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }
    
    public Integer getProductStock() {
        return productStock;
    }
    
    public void setProductStock(Integer productStock) {
        this.productStock = productStock;
    }
    
    public String getProductDescription() {
        return productDescription;
    }
    
    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }
    
    public String getProductIcon() {
        return productIcon;
    }
    
    public void setProductIcon(String productIcon) {
        this.productIcon = productIcon;
    }
    
    public Integer getProductStatus() {
        return productStatus;
    }
    
    public void setProductStatus(Integer productStatus) {
        this.productStatus = productStatus;
    }
    
    public Integer getCategoryType() {
        return categoryType;
    }
    
    public void setCategoryType(Integer categoryType) {
        this.categoryType = categoryType;
    }
    
    public Date getCreateTime() {
        return createTime;
    }
    
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    
    public Date getUpdateTime() {
        return updateTime;
    }
    
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
