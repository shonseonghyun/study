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
	public List<BoardDTO> getAllboard(int page,String f,String q) {
		return pfboarddao.getAllboard(page,f,q);
	}

	@Override
	public void WriteBoard(BoardDTO board) {
		pfboarddao.WriteBoard(board);
	}

	@Override
	public BoardDTO getboard(int id) {
		return pfboarddao.getboard(id);
	}

	@Override
	public int countboard(String f,String q) {
		return pfboarddao.countboard(f,q);
	}
	
}
