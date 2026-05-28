package com.project.sf.qna.service;

import java.util.List;
import com.project.sf.qna.QuestionPost;

public interface QnaService {

  List<QuestionPost> loadQnaPosts();

  QuestionPost loadQnaPostDetailByNo(Long no);

  boolean checkPassword(Long no, String postPw);

}
