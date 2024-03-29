package org.zerock.w2.dao;

import lombok.Cleanup;
import org.zerock.w2.domain.MemberVO;
import org.zerock.w2.domain.StockMemberVO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class StockMemberDAO {

    public StockMemberVO getWithLogin(String sid, String spw) throws Exception {
        String query = "select sid, spw from stock_member where sid = ? and spw = ?";

        StockMemberVO stockMemberVO = null;

        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(query);

        preparedStatement.setString(1, sid);
        preparedStatement.setString(2, spw);

        @Cleanup ResultSet resultSet = preparedStatement.executeQuery();

        resultSet.next();

        stockMemberVO = StockMemberVO.builder()
                .sid(resultSet.getString(1))
                .spw(resultSet.getString(2))
                .build();
        return stockMemberVO;
    }

    public void getWithUpdateUuid (String sid, String uuid) throws Exception {
        String sql = "update stock_member set uuid = ? where sid = ?";

        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1, uuid);
        preparedStatement.setString(2, sid);
        preparedStatement.executeUpdate();
    }

    public StockMemberVO getWithSelectUUID (String uuid) throws Exception {
        String query = "select sid, spw for stock_member where uuid = ?";

        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(query);

        preparedStatement.setString(1, uuid);

        @Cleanup ResultSet resultSet = preparedStatement.executeQuery();

        resultSet.next();

        StockMemberVO stockMemberVO = StockMemberVO.builder()
                .sid(resultSet.getString(1))
                .spw(resultSet.getString(2))
                .uuid(resultSet.getString(3))
                .build();

        return stockMemberVO;
    }
}
