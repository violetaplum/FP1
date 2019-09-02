package payment.biz.card.vo;
import java.sql.Date;

/*
CREATE TABLE card ( c_number number(20) primary key, c_type varchar2(50) NULL, c_expr date NULL, c_csc number(5) NULL, c_addr varchar2(500) NULL, c_user varchar2(30) NOT NULL );*/

/*
int c_number,String c_type,Date c_expr,
        int c_csc,String c_addr,String c_user
*/

public class CardVO {

    int c_number;
    String c_type;
    String c_expr;
    int c_csc;
    String c_addr;
    String c_user;


    public CardVO(){}
    public CardVO(int c_number,String c_type,String c_expr,int c_csc,String c_addr,String c_user)
    {
        this.c_number = c_number;
        this.c_type = c_type;
        this.c_expr = c_expr;
        this.c_csc = c_csc;
        this.c_addr = c_addr;
        this.c_user = c_user;

    }


    public int getC_number() {
        return c_number;
    }

    public void setC_number(int c_number) {
        this.c_number = c_number;
    }

    public String getC_type() {
        return c_type;
    }

    public void setC_type(String c_type) {
        this.c_type = c_type;
    }

    public String getC_expr() {
        return c_expr;
    }

    public void setC_expr(String c_expr) {
        this.c_expr = c_expr;
    }

    public int getC_csc() {
        return c_csc;
    }

    public void setC_csc(int c_csc) {
        this.c_csc = c_csc;
    }

    public String getC_addr() {
        return c_addr;
    }

    public void setC_addr(String c_addr) {
        this.c_addr = c_addr;
    }

    public String getC_user() {
        return c_user;
    }

    public void setC_user(String c_user) {
        this.c_user = c_user;
    }





}
