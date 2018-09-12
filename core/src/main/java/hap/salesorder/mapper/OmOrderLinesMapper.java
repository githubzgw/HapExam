package hap.salesorder.mapper;

import com.hand.hap.mybatis.common.Mapper;
import hap.salesorder.dto.OmOrderLines;

import java.util.List;

public interface OmOrderLinesMapper extends Mapper<OmOrderLines> {

    List<OmOrderLines> myselect(OmOrderLines dto);

    List<OmOrderLines> selectLineNumberMax(Integer headerId);

    int deleteAll(Integer headerId);
}