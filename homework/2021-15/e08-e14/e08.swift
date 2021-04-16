func repeatName(personName: String, amount: Int) -> String {
	return String(repeating: personName, count: amount)
}

print(repeatName(personName: "teemu", amount: 4))