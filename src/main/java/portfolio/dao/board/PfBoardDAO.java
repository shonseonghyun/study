package portfolio.dao.board;

import java.util.List;

import portfolio.dto.board.BoardDTO;

public interface PfBoardDAO {

	//��ü �Խù� ����
	List<BoardDTO> getAllboard(int page,String f,String p);

	//�Խù� �ۼ�
	void WriteBoard(BoardDTO board);

	//�Խù� ����
	BoardDTO getboard(int id);
	
	//�Խù� �� ���� ����
	int countboard(String f,String q);
	
	//��ȸ�� �ø���
	void addHit(int id);
	
	//����
	void deleteboard(int id);
	
	//����
	void modifyboard(BoardDTO board);
}
