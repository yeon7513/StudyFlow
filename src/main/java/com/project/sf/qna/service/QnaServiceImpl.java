package com.project.sf.qna.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

}
