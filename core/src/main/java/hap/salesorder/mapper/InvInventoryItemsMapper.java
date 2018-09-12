package hap.salesorder.mapper;

import com.hand.hap.mybatis.common.Mapper;
import hap.salesorder.dto.InvInventoryItems;

import java.util.List;

public interface InvInventoryItemsMapper extends Mapper<InvInventoryItems> {
    List<InvInventoryItems> myselect();
}