package arrays

func twoSum(nums []int, target int) []int {
  hashMap := make(map[int] int)
  
  for idx, val := range nums {
    if preIdx, exists := hashMap[target - val]; exists {
      return []int{preIdx, idx}
    }
    
    hashMap[val] = idx
  }
  
  return []int{}
}