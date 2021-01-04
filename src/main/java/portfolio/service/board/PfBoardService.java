package portfolio.service.board;

import java.util.List;

import portfolio.dto.board.BoardDTO;

public interface PfBoardService {
	List<BoardDTO> getAllboard(int page,String f,String p);
	void WriteBoard(BoardDTO board);
	BoardDTO getboard(int id);
	int countboard(String f,String q);
}
