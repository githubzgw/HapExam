package hap.salesorder.service;

import com.hand.hap.code.rule.exception.CodeRuleException;
import com.hand.hap.core.IRequest;
import com.hand.hap.core.ProxySelf;
import com.hand.hap.system.service.IBaseService;
import hap.salesorder.dto.OmOrderHeaders;

import java.util.List;

public interface IOmOrderHeadersService extends IBaseService<OmOrderHeaders>, ProxySelf<IOmOrderHeadersService>{

    List<OmOrderHeaders> mySelect(IRequest requestContext, OmOrderHeaders dto, int page, int pageSize);

    List<OmOrderHeaders> mybatchUpdate(IRequest requestCtx, List<OmOrderHeaders> dto) throws CodeRuleException;

    List<OmOrderHeaders> myOtherSelect(IRequest requestContext, OmOrderHeaders dto, int page, int pageSize);
}