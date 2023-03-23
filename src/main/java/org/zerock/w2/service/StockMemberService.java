package org.zerock.w2.service;

import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.zerock.w2.dao.StockMemberDAO;
import org.zerock.w2.domain.MemberVO;
import org.zerock.w2.domain.StockMemberVO;
import org.zerock.w2.dto.MemberDTO;
import org.zerock.w2.dto.StockMemberDTO;
import org.zerock.w2.util.MapperUtil;

@Log4j2
public enum StockMemberService {
    INSTANCE;

    private StockMemberDAO dao;

    private ModelMapper modelMapper;

    StockMemberService() {
        dao = new StockMemberDAO();
        modelMapper = MapperUtil.INSTANCE.get();
    }

    public StockMemberDTO login (String sid, String spw) throws Exception {
        StockMemberVO vo = dao.getWithLogin(sid, spw);

        StockMemberDTO stockMemberDTO = modelMapper.map(vo, StockMemberDTO.class);

        return stockMemberDTO;
    }

    public void StockuUpdateUuid (String sid, String uuid) throws Exception {
        dao.getWithUpdateUuid(sid, uuid);
    }

    public StockMemberDTO StockGetByUUID (String uuid) throws Exception {
        StockMemberVO vo = dao.getWithSelectUUID(uuid);
        StockMemberDTO stockMemberDTO = modelMapper.map(vo, StockMemberDTO.class);

        return stockMemberDTO;
    }
}
