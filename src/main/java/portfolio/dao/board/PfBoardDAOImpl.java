package portfolio.dao.board;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import portfolio.dto.board.BoardDTO;

@Repository
public class PfBoardDAOImpl implements PfBoardDAO {

	@Autowired
	SqlSession sqlSession;
	
	@Override
	public List<BoardDTO> getAllboard(int page,String f,String q) {
		Map<String,Object> map=new HashMap<>();
		map.put("page", page);
		map.put("f",f);
		map.put("q",q);
		return sqlSession.selectList("pfboard.getAllboard",map);
	}

	@Override
	public void WriteBoard(BoardDTO board) {
		sqlSession.insert("pfboard.writeboard", board);
	}

	@Override
	public BoardDTO getboard(int id) {
		return sqlSession.selectOne("pfboard.getboard", id);
	}

	@Override
	public int countboard(String f,String q) {
		Map<String,Object> map=new HashMap<>();
		map.put("f",f);
		map.put("q",q);
		return sqlSession.selectOne("pfboard.countboard",map);
	}

	@Override
	public void addHit(int id) {
		sqlSession.selectOne("pfboard.addHit", id);
	}

}
