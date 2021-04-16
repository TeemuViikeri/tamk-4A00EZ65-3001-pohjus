func findInArray(
	array arrayToBeSearchedFrom: [Int],
	value valueToBeSearched: Int, 
	success: (Int) -> Void, 
	fails: (String) -> Void
) -> Void {
	let found = arrayToBeSearchedFrom.firstIndex(of: valueToBeSearched)
	
	found != nil 
		? success(found!) 
		: fails("Could not find value \(valueToBeSearched)")
}

func printSuccess(index: Int) {
	print(index)
}

func printFail(message: String) {
	print(message)
}

// findInArray(array: [0,2,3,4], value: -2, success: printSuccess, fails: printfail)
findInArray(array: [0,2,3,4], value: -2, success: printSuccess) { print($0) }