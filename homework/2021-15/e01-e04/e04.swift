// Chooses Int64 automatically due to being on a 64-bit platform
let max = Int.max
print(max) // 9223372036854775807 <- signed Int64 max bound

let umax = UInt8.max // 255 <- unsigned Int8 max bound
// Would throw an "overflow" error due to going over bounds
// let overBound = UInt8.max + 1 

let neg: Int = -8
let pos: Int = 8

let distance = neg.distance(to: pos)
print(distance) // 16

let absolute = abs(neg) // abs(_:) is a generic function 
print(absolute) // 8