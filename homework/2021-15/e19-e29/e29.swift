class ViewController : LocationManagerDelegate {
    var manager : LocationManager = LocationManager()

    init() {
        manager.delegate = self
    }

    func viewDidLoad() {
        manager.startUpdatingLocation()
    }

    func receivedLocation(latitude: Double, longitude: Double) {
        print("\(latitude), \(longitude)")
    }
}

class LocationManager {
    var delegate: LocationManagerDelegate?

    func startUpdatingLocation() {
        let lat = Double.random(in: 0.0...100.0)
        let lon = Double.random(in: 0.0...100.0)

        delegate?.receivedLocation(latitude: lat, longitude: lon)
    }
}

protocol LocationManagerDelegate {
    func receivedLocation(latitude: Double, longitude: Double)
}

let x = ViewController()
x.viewDidLoad()