DELIMITER $$

CREATE TRIGGER course_update_status1 

  after delete ON abcd.course
  
   FOR EACH ROW 

BEGIN

      DELETE FROM takeplace WHERE Course_CourseNumber=old.CourseNumber ;

END$$

DELIMITER ;

