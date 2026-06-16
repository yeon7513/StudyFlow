package com.project.sf.inquiry.service;

import com.project.sf.common.pager.Pager;
import com.project.sf.inquiry.QuestionPost;
import com.project.sf.inquiry.dao.QuestionPostDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class QuestionPostServiceImpl implements QuestionPostService {

  @Autowired
  QuestionPostDao questionPostDao;

  @Override
  public List<QuestionPost> loadQnaPosts(Pager pager) {
    int totalCountPost = questionPostDao.totalCountPost(pager);

    pager.setTotal(totalCountPost);

    return questionPostDao.loadQnaPosts(pager);
  }

  @Override
  public QuestionPost loadQnaPostDetailByNo(Long no) {
    return questionPostDao.loadQnaPostDetailByNo(no);
  }

  @Override
  public boolean checkPassword(Long no, String postPw) {
    Map<String, Object> params = new HashMap<>();

    params.put("no", no);
    params.put("postPw", postPw);

    int count = questionPostDao.checkPassword(params);

    return count == 1;
  }

  @Override
  public void modifyPost(QuestionPost questionPost) {
    questionPostDao.modifyPost(questionPost);
  }

  @Override
  public void deletePost(Long no) {
    questionPostDao.deletePost(no);
  }

  @Override
  public QuestionPost findQnaPostByNo(Long no) {
    return questionPostDao.findQnaPostByNo(no);
  }

  @Override
  public Long registerPost(QuestionPost questionPost) {
    return questionPostDao.registerPost(questionPost);
  }

}
