package com.shunyi.autoparts.factory;

import com.shunyi.autoparts.model.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Description:  创建JavaBeans数据源工厂
 * @Author: Shunyi
 * @CreateDate: 2020/5/23 13:28
 * @Version: 1.0
 */
@NoArgsConstructor
@Data
@ToString
public class JRDataSourceFactory {

    public static List<PurchaseOrderItem> createPurchaseOrderItemCollection() {
        Supplier supplier = new Supplier();
        supplier.setName("大连聚鑫伟业");
        PurchaseOrder po = new PurchaseOrder();
        po.setOrderDate(new Date());
        po.setOrderNo("CG00012312313123");
        po.setInvoiceNo("112233445");
        po.setSupplier(supplier);
        po.setOperator("陈顺谊");
        po.setUserName("无视了");

        Product product = new Product();
        Unit unit = new Unit();
        unit.setName("个");
        product.setUnit(unit);
        Car car = new Car();
        car.setCode("FKS");
        car.setName("福克斯");
        product.setCar(car);

        SKU sku = new SKU();
        sku.setSkuCode("05MDO2.0-GT");
        sku.setSkuName("缸套");
        sku.setProduct(product);

        List<PurchaseOrderItem> listItems = new ArrayList<>();
        for(int i = 0; i < 10; i++) {
            PurchaseOrderItem item = new PurchaseOrderItem();
            item.setPurchaseOrder(po);
            item.setSku(sku);
            item.setQuantity(2*i);
            item.setPriceExcludingTax(new BigDecimal(56.22+i).setScale(2, RoundingMode.HALF_UP));
            item.setAmountExcludingTax(new BigDecimal(112.4+i).setScale(2, RoundingMode.HALF_UP));
            item.setTaxAmount(new BigDecimal(i).setScale(2, RoundingMode.HALF_UP));
            item.setNotes("无备注"+i);
            listItems.add(item);
        }
        return listItems;
    }
}
