package com.project.sf.qna.dao;

import java.util.List;
import java.util.Map;
import com.project.sf.qna.QuestionPost;

public interface QnaDao {

  List<QuestionPost> loadQnaPosts();

  QuestionPost loadQnaPostDetailByNo(Long no);

  int checkPassword(Map<String, Object> params);

}
