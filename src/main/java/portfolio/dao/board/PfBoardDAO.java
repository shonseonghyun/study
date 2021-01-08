package portfolio.dao.board;

import java.util.List;

import portfolio.dto.board.BoardDTO;

public interface PfBoardDAO {
	List<BoardDTO> getAllboard(int page,String f,String p);
	void WriteBoard(BoardDTO board);
	BoardDTO getboard(int id);
	int countboard(String f,String q);
	void addHit(int id);
}
