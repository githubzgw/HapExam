package hap.salesorder.dto;

/**
 * Auto Generated By Hap Code Generator
 **/

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.hand.hap.mybatis.annotation.ExtensionAttribute;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Table;

import com.hand.hap.system.dto.BaseDTO;

import java.util.Date;

import org.hibernate.validator.constraints.NotEmpty;

@ExtensionAttribute(disable = true)
@Table(name = "hap_inv_inventory_items")
public class InvInventoryItems extends BaseDTO {

    public static final String FIELD_INVENTORY_ITEM_ID = "inventoryItemId";
    public static final String FIELD_ITEM_CODE = "itemCode";
    public static final String FIELD_ITEM_UOM = "itemUom";
    public static final String FIELD_ITEM_DESCRIPTION = "itemDescription";
    public static final String FIELD_ORDER_FLAG = "orderFlag";
    public static final String FIELD_START_ACTIVE_DATE = "startActiveDate";
    public static final String FIELD_END_ACTIVE_DATE = "endActiveDate";
    public static final String FIELD_ENABLED_FLAG = "enabledFlag";


    @Id
    @GeneratedValue
    private Long inventoryItemId; //物料ID

    @NotEmpty
    @Length(max = 60)
    private String itemCode; //物料编码

    @NotEmpty
    @Length(max = 60)
    private String itemUom; //物料单位

    @NotEmpty
    @Length(max = 240)
    private String itemDescription; //物料描述

    @NotEmpty
    @Length(max = 1)
    private String orderFlag; //是否能用于销售

    private Date startActiveDate; //生效起始时间

    private Date endActiveDate; //生效结束时间

    @NotEmpty
    @Length(max = 1)
    private String enabledFlag; //启用标识


    public void setInventoryItemId(Long inventoryItemId) {
        this.inventoryItemId = inventoryItemId;
    }

    public Long getInventoryItemId() {
        return inventoryItemId;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemUom(String itemUom) {
        this.itemUom = itemUom;
    }

    public String getItemUom() {
        return itemUom;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setOrderFlag(String orderFlag) {
        this.orderFlag = orderFlag;
    }

    public String getOrderFlag() {
        return orderFlag;
    }

    public void setStartActiveDate(Date startActiveDate) {
        this.startActiveDate = startActiveDate;
    }

    public Date getStartActiveDate() {
        return startActiveDate;
    }

    public void setEndActiveDate(Date endActiveDate) {
        this.endActiveDate = endActiveDate;
    }

    public Date getEndActiveDate() {
        return endActiveDate;
    }

    public void setEnabledFlag(String enabledFlag) {
        this.enabledFlag = enabledFlag;
    }

    public String getEnabledFlag() {
        return enabledFlag;
    }

}
