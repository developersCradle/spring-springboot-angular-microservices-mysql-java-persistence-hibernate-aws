DELIMITER $$


DROP PROCEDURE IF EXISTS count_employee_by_department;

CREATE PROCEDURE count_employee_by_department(IN p_dept CHAR(20), OUT p_count INT)
BEGIN  
  SELECT COUNT(*) INTO p_count FROM employee WHERE department = p_dept;    
END $$


DELIMITER ;

