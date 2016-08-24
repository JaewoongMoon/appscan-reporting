
package com.jwmoon.framework.project;

import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectMapper {
	
	List<Project> selectProjects();
	
	Project getProjectDetail(Project project);
}
