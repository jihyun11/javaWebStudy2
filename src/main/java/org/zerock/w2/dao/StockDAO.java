package org.zerock.w2.dao;

import lombok.Cleanup;
import org.zerock.w2.domain.StockVO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StockDAO {

    public void insert(StockVO vo) throws Exception{

        String sql = "insert into stock_content (title, content) values (?, ?)";

        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1, vo.getTitle());
        preparedStatement.setString(2, vo.getContent());

        preparedStatement.executeUpdate();

    }

    public List<StockVO> selectAll() throws Exception {

        String sql = "select * from stock_content";

        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);
        @Cleanup ResultSet resultSet = preparedStatement.executeQuery();

        List<StockVO> list = new ArrayList<>();

        while (resultSet.next()) {
            StockVO vo = StockVO.builder()
                    .title(resultSet.getString("title"))
                    .content(resultSet.getString("content"))
                    .build();
            list.add(vo);
        }
        return list;
    }
}
