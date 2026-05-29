package com.project.sf.qna.dao;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.project.sf.common.pager.Pager;
import com.project.sf.qna.QuestionPost;

@Repository
public class QnaDaoImpl implements QnaDao {

  @Autowired
  SqlSession sql;

  @Override
  public List<QuestionPost> loadQnaPosts(Pager pager) {
    return sql.selectList("post.loadQnaPosts", pager);
  }

  @Override
  public QuestionPost loadQnaPostDetailByNo(Long no) {
    return sql.selectOne("post.loadQnaDetail", no);
  }

  @Override
  public int checkPassword(Map<String, Object> params) {
    return sql.selectOne("post.checkPassword", params);
  }

  @Override
  public void modifyPost(QuestionPost questionPost) {
    sql.update("post.modifyPost", questionPost);
  }

  @Override
  public void deletePost(Long no) {
    sql.update("post.deletePost", no);
  }

  @Override
  public QuestionPost findQnaPostByNo(Long no) {
    return sql.selectOne("post.findQnaPostByNo", no);
  }

  @Override
  public Long registerPost(QuestionPost questionPost) {
    sql.insert("post.registerPost", questionPost);

    return questionPost.getNo();
  }

  @Override
  public int totalCountPost(Pager pager) {
    return sql.selectOne("post.totalCountPost", pager);
  }

}
