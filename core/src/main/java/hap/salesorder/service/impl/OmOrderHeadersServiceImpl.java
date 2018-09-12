package hap.salesorder.service.impl;

import com.github.pagehelper.PageHelper;
import com.hand.hap.code.rule.exception.CodeRuleException;
import com.hand.hap.code.rule.service.ISysCodeRuleProcessService;
import com.hand.hap.core.IRequest;
import com.hand.hap.system.service.impl.BaseServiceImpl;
import hap.salesorder.dto.OmOrderLines;
import hap.salesorder.mapper.OmOrderHeadersMapper;
import hap.salesorder.mapper.OmOrderLinesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import hap.salesorder.dto.OmOrderHeaders;
import hap.salesorder.service.IOmOrderHeadersService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class OmOrderHeadersServiceImpl extends BaseServiceImpl<OmOrderHeaders> implements IOmOrderHeadersService {

    @Autowired
    private OmOrderHeadersMapper omOrderHeadersMapper;
    @Autowired
    private OmOrderLinesMapper omOrderLinesMapper;
    @Autowired
    private ISysCodeRuleProcessService sysCodeRuleProcessService;

    public List<OmOrderHeaders> mySelect(IRequest requestContext, OmOrderHeaders dto, int page, int pageSize) {
        PageHelper.startPage(page,pageSize);
        List<OmOrderHeaders> omOrderHeaders = omOrderHeadersMapper.myselect(dto);
        return omOrderHeaders;
    }

    public List<OmOrderHeaders> mybatchUpdate(IRequest requestCtx, List<OmOrderHeaders> dto) throws CodeRuleException {

        if (dto != null && !dto.isEmpty()) {
            for (int i = 0; i < dto.size(); i++) {
                OmOrderHeaders omOrderHeaders = dto.get(i);
                //新增
                if (omOrderHeaders.getHeaderId() == null) {

                    String orderNumber = sysCodeRuleProcessService.getRuleCode("OrderNumber").toString();
                    System.out.println(orderNumber);
                    omOrderHeaders.setOrderNumber(orderNumber);
                    Long orderHeaderId = Long.parseLong(sysCodeRuleProcessService.getRuleCode("OrderHeaderSequence"));
                    omOrderHeaders.setHeaderId(orderHeaderId);
                    //获取orderNumber和headerId序列
                    omOrderHeadersMapper.insertSelective(omOrderHeaders);
                    List<OmOrderLines> omOrderLinesList = omOrderHeaders.getOmOrderLinesList();
                    if (omOrderLinesList != null) {
                        for (int j = 0; j < omOrderLinesList.size(); j++) {
                            OmOrderLines omOrderLines = omOrderLinesList.get(j);
                            omOrderLines.setCompanyId(omOrderHeaders.getCompanyId());
                            omOrderLines.setHeaderId(omOrderHeaders.getHeaderId());
                            //获取lineId序列
                            Long orderLineId = Long.parseLong(sysCodeRuleProcessService.getRuleCode("OrderLinesSequence"));
                            omOrderLines.setLineId(orderLineId);
                            omOrderLinesMapper.insertSelective(omOrderLines);
                        }
                    } else {
                    }
                }
                //更新
                else {
                    omOrderHeadersMapper.updateByPrimaryKeySelective(omOrderHeaders);
                    List<OmOrderLines> omOrderLinesList = omOrderHeaders.getOmOrderLinesList();
                    if (omOrderLinesList != null) {
                        for (int j = 0; j < omOrderLinesList.size(); j++) {
                            OmOrderLines omOrderLines = omOrderLinesList.get(j);
                            omOrderLines.setCompanyId(omOrderHeaders.getCompanyId());
                            omOrderLines.setHeaderId(omOrderHeaders.getHeaderId());
                            Long lineId = omOrderLines.getLineId();
                            //判断是insert还是update
                            if (lineId != null) {
                                omOrderLinesMapper.updateByPrimaryKeySelective(omOrderLines);
                            } else {
                                //获取lineId序列
                                System.out.println(sysCodeRuleProcessService.getRuleCode("OrderLinesSequence"));
                                Long orderLineId = Long.parseLong(sysCodeRuleProcessService.getRuleCode("OrderLinesSequence"));
                                omOrderLines.setLineId(orderLineId);
                                omOrderLinesMapper.insertSelective(omOrderLines);
                            }
                        }
                    }
                }
            }
            return dto;
        }
        return null;
    }

    @Override
    public List<OmOrderHeaders> myOtherSelect(IRequest requestContext, OmOrderHeaders dto, int page, int pageSize) {
        List<OmOrderHeaders> omOrderHeaders = omOrderHeadersMapper.myselect(dto);
        return omOrderHeaders;
    }


}