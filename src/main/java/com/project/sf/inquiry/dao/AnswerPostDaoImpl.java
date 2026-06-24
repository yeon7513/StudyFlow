package com.project.sf.inquiry.dao;

import com.project.sf.common.pager.AdminInquiryPostSearch;
import com.project.sf.inquiry.model.AnswerPost;
import com.project.sf.inquiry.model.QuestionPost;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AnswerPostDaoImpl implements AnswerPostDao {

  @Autowired
  SqlSession sql;

  @Override
  public void registerAnswerPost(AnswerPost answerPost) {
    sql.insert("adminInquiry.registerAnswerPost", answerPost);
  }

  @Override
  public List<QuestionPost> loadAllPosts(AdminInquiryPostSearch pager) {
    return sql.selectList("adminInquiry.loadAllPosts", pager);
  }

  @Override
  public int totalCountPost(AdminInquiryPostSearch pager) {
    return sql.selectOne("adminInquiry.totalCountPost", pager);
  }

  @Override
  public QuestionPost loadOldestNoAnswerPost(AdminInquiryPostSearch pager) {
    return sql.selectOne("adminInquiry.loadOldestNoAnswerPost", pager);
  }

  @Override
  public void updateAnswerState(Long postNo) {
    sql.update("adminInquiry.updateAnswerState", postNo);
  }

}
