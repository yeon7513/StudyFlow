package com.project.sf.qna.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.sf.qna.QuestionPost;
import com.project.sf.qna.dao.QnaDao;

@Service
public class QnaServiceImpl implements QnaService {

  @Autowired
  QnaDao qnaDao;

  @Override
  public List<QuestionPost> loadQnaPosts() {
    return qnaDao.loadQnaPosts();
  }

  @Override
  public QuestionPost loadQnaPostDetailByNo(Long no) {
    return qnaDao.loadQnaPostDetailByNo(no);
  }

}
