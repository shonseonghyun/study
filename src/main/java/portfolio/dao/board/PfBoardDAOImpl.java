package portfolio.dao.board;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import portfolio.dto.board.BoardDTO;

@Repository
public class PfBoardDAOImpl implements PfBoardDAO {

	@Autowired
	SqlSession sqlSession;
	
	@Override
	public List<BoardDTO> getAllboard() {
		return sqlSession.selectList("pfboard.getAllboard");
	}

}
