package exp5;

class StudentAttendance {

    int totalClasses = 0;
    int attended = 0;

    void markAttendance(boolean present) {
        totalClasses++;
        if (present)
            attended++;
    }

    double calculateAttendancePercentage() {
        if (totalClasses == 0)
            return 0;
        return (attended * 100.0) / totalClasses;
    }

    static double calculateClassAttendance(StudentAttendance[] students) {
        double total = 0;

        for (int i = 0; i < students.length; i++) {
            total += students[i].calculateAttendancePercentage();
        }

        return total / students.length;
    }
}