package hap.salesorder.mapper;

import com.hand.hap.mybatis.common.Mapper;
import hap.salesorder.dto.OmOrderHeaders;
import hap.salesorder.dto.OmOrderLines;

import java.util.List;

public interface OmOrderHeadersMapper extends Mapper<OmOrderHeaders> {

    List<OmOrderHeaders> myselect(OmOrderHeaders dto);

}