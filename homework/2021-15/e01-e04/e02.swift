let x = 3
let y = 0.14

// Swift is a type-safe language so variable value types need to match when
// making operations. If Swift's type check notices that there are mismatched
// types, an error will be thrown during compiling. Type conversion needs to be
// made if in example an integer and a floating-point number are the operands
// of mathmatical operation
var sum = Double(x) + y

print(sum)