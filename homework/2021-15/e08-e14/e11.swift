func findInArray(
	array arrayToBeSearchedFrom: [Int], 
	value valueToBeSearched: Int = 0
) -> Int? {
	return arrayToBeSearchedFrom.firstIndex(of: valueToBeSearched)
}

let value1 = findInArray(array: [1,2,3,4])
let value2 = findInArray(array: [0,2,3,4], value: 4)
print(value1!)  // 1
print(value2!)  // 3