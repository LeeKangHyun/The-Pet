var mapContainer = document.getElementById('map'), // 지도를 표시할 div
mapOption = {
    center: new daum.maps.LatLng(37.566826, 126.9786567), // 지도의 중심좌표
    level: 3 // 지도의 확대 레벨
};
// 지도를 생성합니다
var map = new daum.maps.Map(mapContainer, mapOption);

navigator.geolocation.getCurrentPosition(function (position) {
  var lat = position.coords.latitude, // 위도
      lon = position.coords.longitude; // 경도
  var locPosition = new daum.maps.LatLng(lat, lon);

  map.setCenter(locPosition);

  $(document).on('click', '#where', function() {
     map.setCenter(locPosition);
  });
});



var dotlng, dotlat;
var circleOverlay;
// 지도에 클릭 이벤트를 등록합니다
// 지도를 클릭하면 선 그리기가 시작됩니다 그려진 선이 있으면 지우고 다시 그립니다
daum.maps.event.addListener(map, 'click', function(mouseEvent) {
    var zb = mouseEvent.latLng.zb;
    var Ab = mouseEvent.latLng.Ab;
    console.log(mouseEvent);
    // 마우스로 클릭한 위치입니다
    var clickPosition = mouseEvent.latLng;
    dotlng = zb;
    dotlat = Ab;
    displayCircleDot(clickPosition);
});


// 지도에 마우스 오른쪽 클릭 이벤트를 등록합니다
// 선을 그리고있는 상태에서 마우스 오른쪽 클릭 이벤트가 발생하면 선 그리기를 종료합니다
daum.maps.event.addListener(map, 'rightclick', function(mouseEvent) {
    $.ajax({
        url: "walk/ajax/add.do",
        dataType: "json",
        type: "post",
        data: {
            lat: dotlat,
            lng: dotlng
        },
        success: function(resultObj) {
            console.log(resultObj);
        }
    });

    deleteCircleDot();
});

// 선이 그려지고 있는 상태일 때 지도를 클릭하면 호출하여
// 클릭 지점에 대한 정보 (동그라미)를 표출하는 함수입니다
function displayCircleDot(position) {

    // 클릭 지점을 표시할 빨간 동그라미 커스텀오버레이를 생성합니다
    circleOverlay = new daum.maps.CustomOverlay({
        content: '<span class="dot"></span>',
        position: position,
        zIndex: 1
    });

    // 지도에 표시합니다
    circleOverlay.setMap(map);
}

// 클릭 지점에 대한 정보 (동그라미)를 지도에서 모두 제거하는 함수입니다
function deleteCircleDot() {
    circleOverlay.setMap(null);
}
