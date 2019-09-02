package payment.biz.card.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import payment.biz.card.imp.CardService;
import payment.biz.card.vo.CardVO;

import java.util.ArrayList;

@Service("cardService")
public class CardServiceImpl implements CardService {

    @Autowired
    private CardDAO cardDAO;
    public void insertCard(CardVO vo) throws Exception {
        cardDAO.insertCard(vo);
    }



    public void deleteCard(CardVO vo) throws Exception {
        cardDAO.deleteCard(vo);
    }

    public ArrayList<CardVO> getCardList() throws Exception {
        return cardDAO.getCardList();
    }

    public CardVO getCard(CardVO vo) throws Exception {
        return cardDAO.getCard(vo);
    }
}
