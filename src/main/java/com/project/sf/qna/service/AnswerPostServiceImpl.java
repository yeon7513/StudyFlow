package com.project.sf.qna.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.sf.common.pager.AdminQnaPostSearch;
import com.project.sf.qna.AnswerPost;
import com.project.sf.qna.QuestionPost;
import com.project.sf.qna.dao.AnswerPostDao;

@Service
public class AnswerPostServiceImpl implements AnswerPostService {

  @Autowired
  AnswerPostDao answerPostDao;

  @Override
  public void registerAnswerPost(AnswerPost answerPost) {
    answerPostDao.registerAnswerPost(answerPost);
  }

  @Override
  public List<QuestionPost> loadAllPosts(AdminQnaPostSearch pager) {
    pager.setSearch(1);

    int totalCountPost = answerPostDao.totalCountPost(pager);

    pager.setTotal(totalCountPost);

    return answerPostDao.loadAllPosts(pager);
  }

  @Override
  public QuestionPost loadOldestNoAnswerPost() {
    return answerPostDao.loadOldestNoAnswerPost();
  }

}
