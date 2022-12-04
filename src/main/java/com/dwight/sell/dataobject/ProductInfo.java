package com.dwight.sell.dataobject;

import com.dwight.sell.enums.ProductStatusEnum;
import com.dwight.sell.utils.EnumUtil;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
public class ProductInfo implements Serializable {
    private static final long serialVersionUID = 6741802979515372892L;
    @Id
    private String productId;

    private String productName;

    private BigDecimal productPrice;

    private Integer productStock;

    private String productDescription;

    private String productIcon;

    /*0 for sale, 1 off sale*/
    private Integer productStatus=ProductStatusEnum.UP.getCode();

    private Integer categoryType;

    @JsonIgnore
    public ProductStatusEnum getProductStatusEnum(){
        return EnumUtil.getByCode(productStatus, ProductStatusEnum.class);
    }

}
