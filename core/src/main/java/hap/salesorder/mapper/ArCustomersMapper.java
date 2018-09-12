package hap.salesorder.mapper;

import com.hand.hap.mybatis.common.Mapper;
import hap.salesorder.dto.ArCustomers;

import java.util.List;

public interface ArCustomersMapper extends Mapper<ArCustomers> {

    List<ArCustomers> myselect();
}