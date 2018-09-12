package hap.salesorder.mapper;

import com.hand.hap.mybatis.common.Mapper;
import hap.salesorder.dto.OrgCompanys;

import java.util.List;

public interface OrgCompanysMapper extends Mapper<OrgCompanys> {

    List<OrgCompanys> myselect();

}