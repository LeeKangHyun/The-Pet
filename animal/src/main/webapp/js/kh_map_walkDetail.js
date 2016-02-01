var mapContainer = document.getElementById('map'), // 지도를 표시할 div
mapOption = {
    center: new daum.maps.LatLng(37.566826, 126.9786567), // 지도의 중심좌표
    level: 3 // 지도의 확대 레벨
};
// 지도를 생성합니다
var map = new daum.maps.Map(mapContainer, mapOption);

// 주소-좌표 변환 객체를 생성합니다
var geocoder = new daum.maps.services.Geocoder();
var bounds = new daum.maps.LatLngBounds();
var coord = new daum.maps.LatLng();

var marker = new daum.maps.Marker({
    map: map
});

var overlay = new daum.maps.CustomOverlay({
    map: map,
    yAnchor: 1
});

// 마커를 클릭했을 때 커스텀 오버레이를 표시합니다
daum.maps.event.addListener(marker, 'click', function() {
    overlay.setMap(map);
});

// 커스텀 오버레이를 닫기 위해 호출되는 함수입니다
function closeOverlay() {
    overlay.setMap(null);
}
