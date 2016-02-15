var mapContainer = document.getElementById('map'),
mapOption = {
    center: new daum.maps.LatLng(37.566826, 126.9786567),
    level: 3
};
var map = new daum.maps.Map(mapContainer, mapOption);

navigator.geolocation.getCurrentPosition(function (position) {
  var lat = position.coords.latitude,
      lon = position.coords.longitude;
  var locPosition = new daum.maps.LatLng(lat, lon);

  map.setCenter(locPosition);

  $(document).on('click', '#where', function() {
     map.setCenter(locPosition);
  });
});

var dotlng, dotlat;
var circleOverlay;
var i = 0;
daum.maps.event.addListener(map, 'click', function(mouseEvent) {
    if (i === 0) {
        var zb = mouseEvent.latLng.zb;
        var Ab = mouseEvent.latLng.Ab;
        var clickPosition = mouseEvent.latLng;
        dotlng = zb;
        dotlat = Ab;
        displayCircleDot(clickPosition);
        i++;
    } else {
        alert('1곳만 선택할수 있습니다.');
        i = 0;
        deleteCircleDot();
    }
});

daum.maps.event.addListener(map, 'rightclick', function(mouseEvent) {
    i = 0;
    deleteCircleDot();
});

function displayCircleDot(position) {

    circleOverlay = new daum.maps.CustomOverlay({
        content: '<span class="dot"></span>',
        position: position,
        zIndex: 1
    });

    circleOverlay.setMap(map);
}

function deleteCircleDot() {
    circleOverlay.setMap(null);
}
