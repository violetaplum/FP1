package payment.biz.card.imp;

import payment.biz.card.vo.CardVO;

import java.util.ArrayList;

public interface CardService {
    public void insertCard(CardVO vo) throws Exception;

    public void deleteCard(CardVO vo) throws Exception;
    public ArrayList<CardVO> getCardList() throws Exception;
    public CardVO getCard(CardVO vo) throws Exception;

}
