DELIMITER $$


DROP PROCEDURE IF EXISTS find_employee_by_department;

CREATE PROCEDURE find_employee_by_department(IN p_dept CHAR(20))
BEGIN  
  SELECT * FROM employee WHERE department = p_dept;    
END $$


DELIMITER ;

