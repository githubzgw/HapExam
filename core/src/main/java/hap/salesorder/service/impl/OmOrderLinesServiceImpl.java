package hap.salesorder.service.impl;

import com.github.pagehelper.PageHelper;
import com.hand.hap.core.IRequest;
import com.hand.hap.system.service.impl.BaseServiceImpl;
import hap.salesorder.mapper.OmOrderHeadersMapper;
import hap.salesorder.mapper.OmOrderLinesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import hap.salesorder.dto.OmOrderLines;
import hap.salesorder.service.IOmOrderLinesService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class OmOrderLinesServiceImpl extends BaseServiceImpl<OmOrderLines> implements IOmOrderLinesService {

    @Autowired
    private OmOrderLinesMapper omOrderLinesMapper;

    @Override
    public List<OmOrderLines> myselect(IRequest requestContext, OmOrderLines dto, int page, int pageSize) {
        if (dto.getHeaderId() == null) {
            return null;
        } else {
            PageHelper.startPage(page,pageSize);
            return omOrderLinesMapper.myselect(dto);
        }
    }

    @Override
    public List<OmOrderLines> selectLineNumberMax(IRequest requestContext, Integer headerId) {
        return omOrderLinesMapper.selectLineNumberMax(headerId);
    }

    @Override
    public int deleteAll(IRequest requestContext, Integer headerId) {
        System.out.println(omOrderLinesMapper.deleteAll(headerId));
        return omOrderLinesMapper.deleteAll(headerId);
    }

}