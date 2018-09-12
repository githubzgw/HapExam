package hap.salesorder.service;

import com.hand.hap.core.IRequest;
import com.hand.hap.core.ProxySelf;
import com.hand.hap.system.service.IBaseService;
import hap.salesorder.dto.OmOrderLines;

import java.util.List;

public interface IOmOrderLinesService extends IBaseService<OmOrderLines>, ProxySelf<IOmOrderLinesService>{

    List<OmOrderLines> myselect(IRequest requestContext, OmOrderLines dto, int page, int pageSize);

    List<OmOrderLines> selectLineNumberMax(IRequest requestContext,Integer headerId);

    int deleteAll(IRequest requestContext,Integer headerId);
}