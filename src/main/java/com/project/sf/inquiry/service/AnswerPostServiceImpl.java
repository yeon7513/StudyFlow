package com.project.sf.inquiry.service;

import com.project.sf.common.pager.AdminInquiryPostSearch;
import com.project.sf.inquiry.AnswerPost;
import com.project.sf.inquiry.QuestionPost;
import com.project.sf.inquiry.dao.AnswerPostDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AnswerPostServiceImpl implements AnswerPostService {

  @Autowired
  AnswerPostDao answerPostDao;

  @Override
  public List<QuestionPost> loadAllPosts(AdminInquiryPostSearch pager) {

    int totalCountPost = answerPostDao.totalCountPost(pager);

    pager.setTotal(totalCountPost);

    return answerPostDao.loadAllPosts(pager);
  }

  @Override
  public QuestionPost loadOldestNoAnswerPost(AdminInquiryPostSearch pager) {

    return answerPostDao.loadOldestNoAnswerPost(pager);
  }

  @Override
  @Transactional
  public void registerAnswerPost(AnswerPost answerPost) {
    answerPostDao.registerAnswerPost(answerPost);
    answerPostDao.updateAnswerState(answerPost.getPostNo());
  }

}
