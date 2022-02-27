/*
Method to calculate the capacity of storing water,
Given array would denote the height of each block
at different steps
*/
package main

import (
	"fmt"
	"math"
)

func main() {

	arr := []int{3, 1, 2, 4, 0, 2, 3, 2}
	fmt.Println(waterTrappingCapacity(arr))
}

func waterTrappingCapacity(heights []int) int {
	size := len(heights)
	left := make([]int, size)
	right := make([]int, size)
	left[0] = heights[0]
	right[size-1] = heights[size-1]
	capacity := 0
	for i := 1; i < size; i++ {
		max := math.Max(float64(left[i-1]), float64(heights[i]))
		left[i] = int(max)
	}
	for i := size - 2; i > 0; i-- {
		max := math.Max(float64(left[i+1]), float64(heights[i]))
		right[i] = int(max)
	}
	for i := 0; i < size; i++ {
		min := math.Min(float64(left[i]), float64(right[i]))
		capacity += int(min) - heights[i]
	}
	return capacity
}
