package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.model.Applications;

public interface ApplicationsDao {
	void insertJobApplication(Applications application) throws SQLException;
	List<Applications> getApplicationsForJob(int jobID) throws SQLException;
}
