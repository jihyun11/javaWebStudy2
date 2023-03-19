package org.zerock.w2.service;

import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.zerock.w2.dao.StockDAO;
import org.zerock.w2.domain.StockVO;
import org.zerock.w2.dto.StockDTO;
import org.zerock.w2.util.MapperUtil;

@Log4j2
public enum StockService {
    INSTANCE;

    private StockDAO dao;

    private ModelMapper modelMapper;

    StockService() {
        dao = new StockDAO();
        modelMapper = MapperUtil.INSTANCE.get();
    }

    public void register(StockDTO stockdto) throws Exception {
        StockVO stockVO = modelMapper.map(stockdto, StockVO.class);
        log.info(stockVO);
        dao.insert(stockVO);
    }
}
