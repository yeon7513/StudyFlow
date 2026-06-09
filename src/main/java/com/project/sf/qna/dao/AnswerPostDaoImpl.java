package com.project.sf.qna.dao;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.project.sf.common.pager.Pager;
import com.project.sf.qna.AnswerPost;
import com.project.sf.qna.QuestionPost;

@Repository
public class AnswerPostDaoImpl implements AnswerPostDao {

  @Autowired
  SqlSession sql;

  @Override
  public void registerAnswerPost(AnswerPost answerPost) {
    sql.insert("adminPost.registerAnswerPost", answerPost);
  }

  @Override
  public List<QuestionPost> loadNotAnsweredPost(Pager pager) {
    return sql.selectList("adminPost.loadNotAnsweredPost", pager);
  }

}
