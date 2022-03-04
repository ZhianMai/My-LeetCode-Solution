package strings

func isPalindrome(x int) bool {
  rev := 0
  curr := x
  
  for curr > 0 {
    rev *= 10
    rev += curr % 10
    curr /= 10
  }
  
  return rev == x
}