package portfolio.service.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	@Transactional
	public BoardDTO getboard(int id) {
		pfboarddao.addHit(id);
		return pfboarddao.getboard(id);
	}

	@Override
	public int countboard(String f,String q) {
		return pfboarddao.countboard(f,q);
	}

	@Override
	public void deleteboard(int id) {
		pfboarddao.deleteboard(id);
	}
	
}
