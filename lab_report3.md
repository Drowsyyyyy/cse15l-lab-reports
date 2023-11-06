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


Part2. Researching Commands : Find 

