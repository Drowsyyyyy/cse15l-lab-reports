Part1. A bug of reverseInPlace method in ArrayExamples class. 

1. A failure-inducing input as a JUnit test.
  ```
  @Test
  public void testFailReverseInPlace() {
    int[] input2 = {1, 2, 3};
    ArrayExamples.reverseInPlace(input2);
    assertArrayEquals(new int[]{3, 2, 1}, input2);
  }
  ```
2. An input that does not induce a failure, as a Junit Test.
  ```
  @Test
  public void testNotFailReverseInPlace() {
    int[] input2 = {1, 1};
    ArrayExamples.reverseInPlace(input2);
    assertArrayEquals(new int[]{1, 1}, input2);
  }
  ```
3. The symptom, as the output of running the tests.
  ![Image](arraytest.PNG)

4. The bug, as the before-and-after code
  - Before
    ```
    static void reverseInPlace(int[] arr) {
      for(int i = 0; i < arr.length; i += 1) {
        arr[i] = arr[arr.length - i - 1];
      }
    }
    ```
  - After
    ```
    static void reverseInPlace(int[] arr) {
      int[] keep = new int[arr.length];

      for(int i = 0; i<arr.length; i++) {
        keep[i] = arr[i];
      }

      for(int i = 0; i < arr.length; i += 1) {
        arr[i] = keep[arr.length - i - 1];
      }
    }
    ```
5. Briefly describe why the fix addresses the issue.
  When we try to change the input array to be in reversed order, the previous code has a bug because it is trying to change the input array directly by assigning its value in each index. So, we can make another temporary array which contains exactly same elements with the input array. Since we are only changing the
  elements in the input array, the elements in temporary array remain same. Now, we can change the elements of the input array by using the temporary array.


Part2. Researching Commands : grep

1. grep -E
  ```
  grep -E 'answer|problem' ./technical/biomed/1468-6708-3-3.txt
  The problem
  (MIRACL) trial set out to answer this question.
  The answer?

  grep -E 'Intro|Six' ./technical/biomed/1468-6708-3-1.txt
  Introduction
  Six large controlled population-based studies of
  ```
  -E option allows that the pattern is an extended regular expression. It is useful because we can search multiple patterns at once. If we use grep without -E option, the patteren will recognize 'answer|problem' as a single string itself. 

  citation: https://csiro-data-school.github.io/regex/03-egrep-find/index.html
  
2. grep -i
  ```
  grep -i 'intro' ./technical/biomed/1468-6708-3-1.txt
  Introduction

  grep -i 'six' ./technical/biomed/1468-6708-3-1.txt
  Six large controlled population-based studies of
  examining health status over time, we added a sixth
  ```
  -i option ignores case distinctions. It is useful when we want to ignore case distinctions of the input patterns. 

  citation: grep --help (git bash terminal) 

3. grep -w
  ```
  grep -w 'adult' ./technical/biomed/1468-6708-3-1.txt
  throughout adult life. It may be that a small amount of
  average older adult; however, adjustment for detailed

  grep -w 'adults' ./technical/biomed/1468-6708-3-1.txt
  Older adults are frequently counseled to lose weight,
  non-smoking older adults have investigated the association
  adults drew similar conclusions [ 7 ] .
  Many healthy older adults report gradual weight gain
  In older adults, risk factors may have a greater effect
  years of being healthy, in a cohort of older adults for
  modification interventions in older adults.
  population-based longitudinal study of 5,888 adults aged
  categories could be combined for older adults. Since
  interventions for older adults who were merely overweight
  adults are the subjects. This is particularly important
  33 34 ] . For older adults, the risks associated with
  outcome for a trial of weight loss in older adults
  found for underweight older adults. Clinical trials whose
  older adults, especially for women. Future efforts to
  no excess risk for older adults who would be classified as
  obese or underweight older adults, and discouraging trials
  that address older adults who are merely overweight.
  ```
  -w option selects only those lines containing matches that form whole words. It is useful when we do not want to include the lines containing a word of which the pattern is a substring. 

  citation: https://unix.stackexchange.com/questions/524828/what-does-grep-w-do

4. grep -c
  ```
  grep -c 'adult' ./technical/biomed/1468-6708-3-1.txt
  20

  grep -c 'Intro' ./technical/biomed/1468-6708-3-1.txt
  1
  ```
  -c option prints the number of lines of output context. It is useful when we just want to know how many lines matching with the input pattern there are.

  citation: grep --help (git bash terminal)
