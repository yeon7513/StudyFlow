package com.project.sf.qna.dao;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.project.sf.qna.QuestionPost;

@Repository
public class QnaDaoImpl implements QnaDao {

  @Autowired
  SqlSession sql;

  @Override
  public List<QuestionPost> findQnaPosts() {
    return sql.selectList("post.selectAllQnaPosts");
  }

  @Override
  public QuestionPost findQnaPostDetailByNo(Long no) {
    return sql.selectOne("selectQnaDetail", no);
  }

}
