struct Person {
    // initializes computer to Computer() object or nil
    var computer : Computer? = Bool.random() ? Computer() : nil
}

struct Computer {
    var soundCard : SoundCard? = Bool.random() ? SoundCard() : nil
}

struct SoundCard {
    var name : String? = Bool.random() ? "SoundBlaster" : nil
}

let jack = Person()

let name1 = jack.computer!.soundCard!.name!
print(name1)

if let c = jack.computer, let s = c.soundCard, let name2 = s.name {
	print(name2)
}