package practice.guestboard.dao;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Repository;

import practice.guestboard.domain.Document;

@Repository
public class DocumentDAOImpl implements DocumentDAO {
	private SqlSession sqlSession;
	private SqlSessionFactory sqlSessionFactory;

	public void setSqlSession(SqlSession sqlSession){
		this.sqlSession = sqlSession;
	}
	
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }
    
	
	public List<Document> selectAllDocument(){
		List<Document> documents = null;
		sqlSession = sqlSessionFactory.openSession();
		documents = (List<Document>) sqlSession.selectList("Document.selectdocument");
		sqlSession.close();
		
		// 엔터 치환
		for(Document d : documents){
			String content = d.getContent();
			d.setContent(content.replaceAll("\n","<br/>"));
		}
		return documents;
	}
	
	public void insertDocument(Document document){
		sqlSession = sqlSessionFactory.openSession();
		sqlSession.insert("Document.insertdocument", document);
		sqlSession.commit();
		sqlSession.close();
	}
	
	public Document getDocument(Long id){
		Document document = null;
		sqlSession = sqlSessionFactory.openSession();
		document = (Document) sqlSession.selectOne("Document.getdocument", id);
		return document;
	};
	
	public void updateDocument(Document document){
		sqlSession = sqlSessionFactory.openSession();
		sqlSession.update("Document.updatedocument", document);
		sqlSession.commit();
		sqlSession.close();
	}
}
