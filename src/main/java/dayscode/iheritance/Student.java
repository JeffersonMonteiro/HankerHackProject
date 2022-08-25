package dayscode.iheritance;


public class Student extends Person {

    private int[] testScores;

    public Student(String firstName, String lastName, int id, int[] testScores) {
        super(firstName, lastName, id);
        this.firstName = firstName;
        this.lastName = lastName;
        this.idNumber = id;
       this.testScores = testScores;
    }

    protected char calculate() {
        char gradeLetter = 0;
        float gradeValue = 0;

        for (int i = 0; i < testScores.length; i++) {
            gradeValue += testScores[i] ;
        }
        gradeValue = gradeValue/testScores.length;
        gradeLetter = getGradeLetter(gradeLetter, gradeValue);

        return gradeLetter;
    }

    private char getGradeLetter(char gradeLetter, float gradeValue) {
        if (gradeValue >= 90 && gradeValue <= 100) {
            gradeLetter = 'O';
        } else if(gradeValue >= 80 && gradeValue < 90){
            gradeLetter = 'E';
        }else if (gradeValue >= 70 && gradeValue < 80) {
            gradeLetter = 'A';
        } else if (gradeValue >= 55 && gradeValue < 70) {
            gradeLetter = 'P';
        } else  if (gradeValue >= 40 && gradeValue < 55) {
            gradeLetter = 'D';
        }else  if (gradeValue < 40) {
            gradeLetter = 'T';
        }
        return gradeLetter;
    }
}
