function markAsVisited(element) {
    element.parentElement.parentElement.parentElement.parentElement.parentElement.style.backgroundColor = 'grey';
    element.parentElement.parentElement.parentElement.innerHTML += '<b>  VISITED !</b>';
}

// Initialize the map
var mymap = L.map('map').setView([41.6086, 21.7453], 8); // Centered over Macedonia

// Add the OpenStreetMap tile layer
L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
    attribution: '&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors'
}).addTo(mymap);

// Example data from a database
var placesData = [
    { lat: 41.6086, lng: 21.7453, name: 'Macedonia', description: 'Welcome to Macedonia!' },
    // Add more places as needed
];

// Loop through the places data and create markers with popups
placesData.forEach(function(place) {
    var marker = L.marker([place.lat, place.lng]).addTo(mymap);
    marker.bindPopup("<b>" + place.name + "</b><br>" + place.description).openPopup();
});

// Add the geocoder control to the map
L.Control.geocoder().addTo(mymap);