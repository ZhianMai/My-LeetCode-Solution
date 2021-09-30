/**
* Problem #1700
* Simplify to time O(n), space O(1)
*/
class EatingLunch {
  public int countStudents(int[] students, int[] sandwiches) {
    int wantSquare = 0; // student 1

    for (int i : students) {
      wantSquare += i;
    }

    int wantCircular = students.length - wantSquare; // student 0

    for (int i : sandwiches) {
      if (i == 0 && wantCircular != 0) {  // Current is 0, and someone wants 0, go grab it!
        wantCircular--;
      } else if (i == 0 && wantCircular == 0) {  // Current is 0, but no one wants 0, over!
        return wantSquare;
      } else if (i == 1 && wantSquare != 0) { // Current is 1, and someone wants 1...
        wantSquare--;
      } else { // Current is 1, and no one wants 1...
        return wantCircular;
      }
    }

    return 0;
  }
  
  // This is the second solutions. It's very short, and I wrote it just for fun.
  // Not recommend this one, since not readable, maintainable, or scalable!
  public int countStudentsB(int[] students, int[] sandwiches) {
    int[] wants = new int[2];

    for (int i : students) {
      wants[i]++;
    }

    for (int i : sandwiches) {
      if (wants[i]-- == 0) {
        return wants[(i + 1) % 2];
      }
    }

    return 0;
  }
}
