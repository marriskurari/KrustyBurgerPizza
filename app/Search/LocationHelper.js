
/*

@Stupid
google maps api virkar ekki nema initMap er i globalScope
thad tharf ad hafa eitthvad callback or sum

*/
let form
let map

const geocodeAddress = (geocoder, gglMap) => {
  const address = form.querySelector("#address").value
  geocoder.geocode({'address': address}, (results, status) => {
    if(status === 'OK') {
      gglMap.setCenter(results[0].geometry.location)
      const marker = new google.maps.Marker({
        map: gglMap,
        position: results[0].geometry.location
      })
    } else {
      alert("Something went wrong: " + status)
    }
  })
}

//binds a google selection map to element
const initMap = () => {
  const gglMap = new google.map.Map(map , {
    zoom: 8,
    center: {lat: 64.128, lng: 21.827}
  })

  const geocoder = new google.maps.Geocoder()
  element.querySelector('#submit').addEventListener('click', () => {
    geocodeAddress(geocoder, map)
  })
}

const LocationApi = (_form, _map) => {
  form = _form
  map = _map
  initMap()
  return {
    initMap
  }
}

export default LocationApi
