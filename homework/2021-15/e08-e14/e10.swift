import Foundation

func getPersonInformation() -> (String, Date) {
	let name = "Pekka Virtanen"

	let dateFormatter = ISO8601DateFormatter()
	let dateString = "1980-07-10T22:00:00+00:00"
	let birthday = dateFormatter.date(from: dateString)!
	
	let person: (String, Date) = (name, birthday)
	return person
}	

print(getPersonInformation().0)
print(getPersonInformation().1)