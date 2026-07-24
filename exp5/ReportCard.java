package exp5;

class ReportCard {

    int marks[];
    int totalSubjects;

    void inputMarks(int[] m) {
        marks = m;
        totalSubjects = m.length;
    }

    char calculateGrade() {

        int sum = 0;

        for (int i = 0; i < totalSubjects; i++)
            sum += marks[i];

        double avg = sum / totalSubjects;

        if (avg >= 90)
            return 'A';
        else if (avg >= 75)
            return 'B';
        else if (avg >= 60)
            return 'C';
        else
            return 'D';
    }

    static void generateClassReport(ReportCard[] students) {

        for (int i = 0; i < students.length; i++) {
            System.out.println("Student " + (i+1) + " Grade: " + students[i].calculateGrade());
        }
    }
}
    
