// a)
// print("first argument")
// let x = readLine()!

// print("second argument")
// let y = readLine()!

// let intX = Int(x)!
// let intY = Int(y)!

// print(intX + intY)

// b)
// print("first argument")
// if let x = readLine()
// {
// 	print("second argument")
// 	if let y = readLine()
// 	{
// 		if let intX = Int(x)
// 		{
// 			if let intY = Int(y)
// 			{
// 				print(intX + intY)
// 			}
// 		}
// 	}
// }

// c)
if let x = Int(readLine()!), let y = Int(readLine()!) {
    print(x + y)
}