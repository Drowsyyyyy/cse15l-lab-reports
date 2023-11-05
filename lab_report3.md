A bug of reverseInPlace method in ArrayExamples class. 

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
