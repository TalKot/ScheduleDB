package com.finalproject;

public class ClassInformationQuery {
		private int classNumber,LectureID,CourseNumber;


		public int getClassNumber() {
			return classNumber;
		}

		public void setClassNumber(int classNumber) {
			this.classNumber = classNumber;
		}

		public int getLectureID() {
			return LectureID;
		}

		public void setLectureID(int lectureID) {
			LectureID = lectureID;
		}

		public int getCourseNumber() {
			return CourseNumber;
		}

		public void setCourseNumber(int courseNumber) {
			CourseNumber = courseNumber;
		}
		
		@Override
		public String toString() {
			return "Class=" + classNumber + ", Lecture=" + LectureID + ", CourseNumber=" + CourseNumber ;
		}

}
