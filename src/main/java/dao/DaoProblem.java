package dao;

import entity.Question;

public interface DaoProblem {

	public boolean addProblem(Question question);
	
	public Question getDetailProblem(String question_id);
}
