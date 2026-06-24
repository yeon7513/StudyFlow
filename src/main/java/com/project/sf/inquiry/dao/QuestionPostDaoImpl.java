package com.project.sf.inquiry.dao;

import com.project.sf.common.pager.Pager;
import com.project.sf.inquiry.model.QuestionPost;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class QuestionPostDaoImpl implements QuestionPostDao {

  @Autowired
  SqlSession sql;

  @Override
  public List<QuestionPost> loadQnaPosts(Pager pager) {
    return sql.selectList("inquiry.loadQnaPosts", pager);
  }

  @Override
  public QuestionPost loadQnaPostDetailByNo(Long no) {
    return sql.selectOne("inquiry.loadQnaDetail", no);
  }

  @Override
  public int checkPassword(Map<String, Object> params) {
    return sql.selectOne("inquiry.checkPassword", params);
  }

  @Override
  public void modifyPost(QuestionPost questionPost) {
    sql.update("inquiry.modifyPost", questionPost);
  }

  @Override
  public void deletePost(Long no) {
    sql.update("inquiry.deletePost", no);
  }

  @Override
  public QuestionPost findQnaPostByNo(Long no) {
    return sql.selectOne("inquiry.findQnaPostByNo", no);
  }

  @Override
  public Long registerPost(QuestionPost questionPost) {
    sql.insert("inquiry.registerPost", questionPost);

    return questionPost.getNo();
  }

  @Override
  public int totalCountPost(Pager pager) {
    return sql.selectOne("inquiry.totalCountPost", pager);
  }

}
