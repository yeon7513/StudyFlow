package com.project.sf.qna.dao;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.project.sf.qna.QuestionPost;

@Repository
public class QnaDaoImpl implements QnaDao {

  @Autowired
  SqlSession sql;

  @Override
  public List<QuestionPost> loadQnaPosts() {
    return sql.selectList("post.loadQnaPosts");
  }

  @Override
  public QuestionPost loadQnaPostDetailByNo(Long no) {
    return sql.selectOne("post.loadQnaDetail", no);
  }

  @Override
  public int checkPassword(Map<String, Object> params) {
    return sql.selectOne("post.checkPassword", params);
  }

}
