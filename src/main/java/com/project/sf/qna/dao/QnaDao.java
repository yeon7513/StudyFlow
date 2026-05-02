package com.project.sf.qna.dao;

import java.util.List;
import com.project.sf.qna.QuestionPost;

public interface QnaDao {

  List<QuestionPost> findQnaPosts();

  QuestionPost findQnaPostDetailByNo(Long no);

}
