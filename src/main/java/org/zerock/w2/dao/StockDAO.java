package org.zerock.w2.dao;

import lombok.Cleanup;
import org.zerock.w2.domain.StockVO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

public class StockDAO {

    public void insert(StockVO vo) throws Exception{

        String sql = "insert into stock_content (title, content) values (?, ?)";

        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1, vo.getTitle());
        preparedStatement.setString(2, vo.getContent());

        preparedStatement.executeUpdate();

    }
}
