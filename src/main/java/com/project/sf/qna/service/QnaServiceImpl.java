package com.project.sf.qna.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.sf.common.pager.Pager;
import com.project.sf.qna.QuestionPost;
import com.project.sf.qna.dao.QnaDao;

@Service
public class QnaServiceImpl implements QnaService {

  @Autowired
  QnaDao qnaDao;

  @Override
  public List<QuestionPost> loadQnaPosts(Pager pager) {
    int totalCountPost = qnaDao.totalCountPost(pager);

    pager.setTotal(totalCountPost);

    return qnaDao.loadQnaPosts(pager);
  }

  @Override
  public QuestionPost loadQnaPostDetailByNo(Long no) {
    return qnaDao.loadQnaPostDetailByNo(no);
  }

  @Override
  public boolean checkPassword(Long no, String postPw) {
    Map<String, Object> params = new HashMap<>();

    params.put("no", no);
    params.put("postPw", postPw);

    int count = qnaDao.checkPassword(params);

    if (count == 1) {
      return true;
    }

    return false;
  }

  @Override
  public void modifyPost(QuestionPost questionPost) {
    qnaDao.modifyPost(questionPost);
  }

  @Override
  public void deletePost(Long no) {
    qnaDao.deletePost(no);
  }

  @Override
  public QuestionPost findQnaPostByNo(Long no) {
    return qnaDao.findQnaPostByNo(no);
  }

  @Override
  public Long registerPost(QuestionPost questionPost) {
    return qnaDao.registerPost(questionPost);
  }

}
