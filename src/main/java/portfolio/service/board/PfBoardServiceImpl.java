package portfolio.service.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import portfolio.dao.board.PfBoardDAO;
import portfolio.dto.board.BoardDTO;

@Service
public class PfBoardServiceImpl  implements PfBoardService{

	@Autowired
	PfBoardDAO pfboarddao;
	
	@Override
	public List<BoardDTO> getAllboard() {
		return pfboarddao.getAllboard();
	}

}
