import payment.biz.card.dao.CardDAO;
import payment.biz.card.vo.CardVO;
import payment.biz.connect.JDBCConnect;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class main {
    public static void main(String[] args) throws Exception{
        /*CardVO vo = new CardVO(1,"master card","2018-08-08",123,"Seoul","Jang");
        CardDAO dao = new CardDAO();
        dao.insertCard(vo);
        ArrayList<CardVO> al = dao.getCardList();
        for(int i=0;i<al.size();i++)
        {
            System.out.print(al.get(i));
            System.out.println();
        }*/

         Connection conn2;
         PreparedStatement stmt2;
         ResultSet rs2;
        CardVO vo = new CardVO(1,"master card","2018-08-08",123,"Seoul","Jang");
        conn2= JDBCConnect.getConnection();
        stmt2 = conn2.prepareStatement("insert into card(c_number,c_type,c_expr,c_csc,c_addr,c_user) values(?,?,?,?,?,?)");
        stmt2.setInt(1,vo.getC_number());
        stmt2.setString(2,vo.getC_type());
        stmt2.setDate(3, Date.valueOf(vo.getC_expr()));
        stmt2.setInt(4,vo.getC_csc());
        stmt2.setString(5,vo.getC_addr());
        stmt2.setString(6,vo.getC_user());
        stmt2.executeUpdate();
        JDBCConnect.close(stmt2,conn2);
    }
}
