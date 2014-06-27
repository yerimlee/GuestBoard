package practice.guestboard.dao;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import practice.guestboard.domain.Document;

@Repository
public class DocumentDAOImpl implements DocumentDAO {
	private SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession){
		this.sqlSession = sqlSession;
	}
	
	public List<Document> SelectAllDocument(){
		return (List<Document>) sqlSession.selectList("Document.selectdocument");
	}
}
