package org.zerock.w2.dao;

import lombok.Cleanup;
import org.zerock.w2.domain.StockVO;
import org.zerock.w2.domain.TodoVO;

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

    public StockVO StockSelectOne(String title) throws Exception {
        String sql = "select * from stock_content where title = ?";

        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1, title);

        @Cleanup ResultSet resultSet = preparedStatement.executeQuery();

        resultSet.next();
        StockVO vo = StockVO.builder()
                .title(resultSet.getString("title"))
                .content(resultSet.getString("content"))
                .build();
        return vo;
    }

    public void StockDeleteOne(String title) throws Exception {
        String sql = "delete from stock_content where title = ?";

        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1, title);
        preparedStatement.executeQuery();
    }

    public void StockUpdateOne(StockVO stockVO) throws Exception {
        String sql = "update stock_content set title = ?, content = ? where title = ?";

        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1, stockVO.getTitle());
        preparedStatement.setString(2, stockVO.getContent());
        preparedStatement.setString(3, stockVO.getTitle());

        preparedStatement.executeUpdate();

    }
}
