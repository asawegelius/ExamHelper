package dao;

import java.io.Serializable;
import java.util.ArrayList;

public interface IChoiceDao<T extends Serializable, ID> extends
		IExamHelperDao<T, ID> {
	
	ArrayList<T> getChoicesForQuestion(ID id);
}
