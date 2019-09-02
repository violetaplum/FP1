package payment.biz.card.dao;

import org.springframework.stereotype.Repository;
import payment.biz.card.vo.CardVO;
import payment.biz.connect.JDBCConnect;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

@Repository
public class CardDAO {
    private Connection conn2;
    private PreparedStatement stmt2;
    private ResultSet rs2;
/*
    insert into card values(12,'master',DATE '2018-08-08',345,'Seoul','asdf');*/
/*
    CREATE TABLE card ( c_number number(20) primary key, c_type varchar2(50) NULL, c_expr date NULL, c_csc number(5) NULL, c_addr varchar2(500) NULL, c_user varchar2(30) NOT NULL );*/
/*

    SQL> desc card;
    Name					   Null?    Type
 ----------------------------------------- -------- ----------------------------
    C_NUMBER				   NOT NULL NUMBER(20)
    C_TYPE 					    VARCHAR2(50)
    C_EXPR 					    DATE
    C_CSC						    NUMBER(5)
    C_ADDR 					    VARCHAR2(500)
    C_USER 				   NOT NULL VARCHAR2(30)

*/


    public void insertCard(CardVO vo) throws Exception{
        conn2= JDBCConnect.getConnection();
        stmt2 = conn2.prepareStatement("insert into card(c_numer,c_type,c_expr,c_csc,c_addr,c_user) values(?,?,date ?,?,?,?)");
        stmt2.setInt(1,vo.getC_number());
        stmt2.setString(2,vo.getC_type());
        stmt2.setDate(3, Date.valueOf(vo.getC_expr()));
        stmt2.setInt(4,vo.getC_csc());
        stmt2.setString(5,vo.getC_addr());
        stmt2.setString(6,vo.getC_user());
        stmt2.executeUpdate();
        JDBCConnect.close(stmt2,conn2);
    }
    public void deleteCard(CardVO vo) throws Exception{
        conn2 = JDBCConnect.getConnection();
        stmt2 = conn2.prepareStatement("delete card where c_number=?");
        stmt2.setInt(1,vo.getC_number());
        stmt2.executeUpdate();
        JDBCConnect.close(stmt2,conn2);

    }

    public ArrayList<CardVO> getCardList(CardVO vo) throws Exception{
        conn2 = JDBCConnect.getConnection();
        stmt2 = conn2.prepareStatement("select * from card");
        rs2 = stmt2.executeQuery();
        ArrayList<CardVO> av = new ArrayList<CardVO>();
        while(rs2.next())
        {
            vo.setC_number(rs2.getInt("c_number"));
            vo.setC_type(rs2.getString("c_type"));
            vo.setC_expr(String.valueOf(rs2.getDate("c_expr")));
            vo.setC_csc(rs2.getInt("c_csc"));
            vo.setC_addr(rs2.getString("c_addr"));
            vo.setC_user(rs2.getString("c_user"));
            av.add(vo);
        }
        JDBCConnect.close(stmt2,conn2);
        return av;
    }

    public ArrayList<CardVO> getCardList() throws Exception{
        conn2 = JDBCConnect.getConnection();
        stmt2 = conn2.prepareStatement("select * from card");
        rs2 = stmt2.executeQuery();
        ArrayList<CardVO> av = new ArrayList<CardVO>();

        CardVO card = null;
        while(rs2.next())
        {
            card.setC_number(rs2.getInt("c_number"));
            card.setC_type(rs2.getString("c_type"));
            card.setC_expr(String.valueOf(rs2.getDate("c_expr")));
            card.setC_csc(rs2.getInt("c_csc"));
            card.setC_addr(rs2.getString("c_addr"));
            card.setC_user(rs2.getString("c_user"));
            av.add(card);
        }
        JDBCConnect.close(rs2,stmt2,conn2);
        return av;
    }

    public CardVO getCard(CardVO vo) throws Exception{
        conn2 = JDBCConnect.getConnection();
        stmt2 = conn2.prepareStatement("select * from card where c_number=?");
        stmt2.setInt(1,vo.getC_number());
        rs2 = stmt2.executeQuery();
        CardVO vo2 = null;
        if(rs2.next())
        {
            vo.setC_number(rs2.getInt("c_number"));
            vo.setC_type(rs2.getString("c_type"));
            vo.setC_expr(String.valueOf(rs2.getDate("c_expr")));
            vo.setC_csc(rs2.getInt("c_csc"));
            vo.setC_addr(rs2.getString("c_addr"));
            vo.setC_user(rs2.getString("c_user"));
        }
        JDBCConnect.close(rs2,stmt2,conn2);
        return vo;
    }
}
