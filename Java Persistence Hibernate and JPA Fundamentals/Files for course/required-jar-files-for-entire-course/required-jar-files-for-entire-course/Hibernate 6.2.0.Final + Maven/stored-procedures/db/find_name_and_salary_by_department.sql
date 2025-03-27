DELIMITER $$


DROP PROCEDURE IF EXISTS find_name_and_salary_by_department;

CREATE PROCEDURE find_name_and_salary_by_department(IN p_dept CHAR(20))
BEGIN  
  SELECT name, salary FROM employee WHERE department = p_dept;    
END $$


DELIMITER ;

