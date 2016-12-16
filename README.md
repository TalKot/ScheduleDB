# ScheduleDB
Schedule application for classes-lectures-courses working with mysql server

trigger that should added to the project using MySQL workbench- after creation and dataenter to tables - 

DELIMITER $$
CREATE TRIGGER course_update_status 
    after delete ON abcd.course
    FOR EACH ROW 
BEGIN
	DELETE FROM takeplace WHERE Course_CourseNumber=old.CourseNumber ;
END$$
DELIMITER ;
