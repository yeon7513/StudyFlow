package com.project.sf.qna.service;

import com.project.sf.common.pager.AdminQnaPostSearch;
import com.project.sf.qna.AnswerPost;
import com.project.sf.qna.QuestionPost;
import com.project.sf.qna.dao.AnswerPostDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    pager.setSearch("contents");

    int totalCountPost = answerPostDao.totalCountPost(pager);

    pager.setTotal(totalCountPost);

    return answerPostDao.loadAllPosts(pager);
  }

  @Override
  public QuestionPost loadOldestNoAnswerPost() {
    return answerPostDao.loadOldestNoAnswerPost();
  }

}
