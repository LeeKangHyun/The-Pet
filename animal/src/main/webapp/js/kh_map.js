// 마커를 담을 배열입니다
  var markers = [];

var mapContainer = document.getElementById('map'), // 지도를 표시할 div
    mapOption = {
      center: new daum.maps.LatLng(37.566826, 126.9786567), // 지도의 중심좌표
      level: 3 // 지도의 확대 레벨
    };

// 지도를 생성합니다
var map = new daum.maps.Map(mapContainer, mapOption);

// 장소 검색 객체를 생성합니다
var ps = new daum.maps.services.Places();

// 검색 결과 목록이나 마커를 클릭했을 때 장소명을 표출할 인포윈도우를 생성합니다
var infowindow = new daum.maps.InfoWindow({
  zIndex: 1
});
var sub = '';

$(document).on('click', "#ali", function() {
  $('#keyword').val('');
  sub='';
  $('#ali').css('background-color', '#d06a79')
  $('#hospital').css('background-color', '#2d335e')
  $('#object').css('background-color', '#2d335e')
  $('#cafe').css('background-color', '#2d335e')
});

$(document).on('click', "#hospital", function() {
    $('#keyword').val('');
    sub=$('#hospital').val();
  $('#ali').css('background-color', '#2d335e')
  $('#hospital').css('background-color', '#d06a79')
  $('#object').css('background-color', '#2d335e')
  $('#cafe').css('background-color', '#2d335e')
});

$(document).on('click', "#object", function() {
    $('#keyword').val('');
    sub=$('#object').val();
  $('#ali').css('background-color', '#2d335e')
  $('#hospital').css('background-color', '#2d335e')
  $('#object').css('background-color', '#d06a79')
  $('#cafe').css('background-color', '#2d335e')
});

$(document).on('click', "#cafe", function() {
    $('#keyword').val('');
    sub=$('#cafe').val();
  $('#ali').css('background-color', '#2d335e')
  $('#hospital').css('background-color', '#2d335e')
  $('#object').css('background-color', '#2d335e')
  $('#cafe').css('background-color', '#d06a79')
});

// 키워드 검색을 요청하는 함수입니다
$(document).on("click", "#finder", function () {

  var keyword = document.getElementById('keyword').value;

  if (!keyword.replace(/^\s+|\s+$/g, '')) {
    alert('키워드를 입력해주세요!');
    return false;
  }

  // 장소검색 객체를 통해 키워드로 장소검색을 요청합니다
  ps.keywordSearch({
    keyword: keyword + sub,
    callback: placesSearchCB,
    radius: 1000
  });
});

navigator.geolocation.getCurrentPosition(function (position) {
  var lat = position.coords.latitude, // 위도
      lon = position.coords.longitude; // 경도
  var locPosition = new daum.maps.LatLng(lat, lon)
  console.log(locPosition);
  $(document).on("click", ".pet", function (event) {
    if ($('#keyword').val() === '') {
        ps.keywordSearch({
            keyword: event.target.value,
            callback: placesSearchCB,
            radius: 1000,
            location: locPosition
        });
    } else {
        return false;
    }
  });
});

// $(document).on("click", "#pet", function(event) {
//   ps.keywordSearch({
//     keyword: event.target.value,
//     callback: placesSearchCB,
//     radius: 1000,
//     location: new daum.maps.LatLng(37.566826, 126.9786567)
//   })
// });

// // 키워드 검색을 요청하는 함수입니다
// function searchPlaces() {
//
//   var keyword = document.getElementById('keyword').value;
//
//   if (!keyword.replace(/^\s+|\s+$/g, '')) {
//     alert('키워드를 입력해주세요!');
//     return false;
//   }
//
//   // 장소검색 객체를 통해 키워드로 장소검색을 요청합니다
//   ps.keywordSearch({
//     keyword: keyword,
//     callback: placesSearchCB,
//     radius: 1000,
//     location: new daum.maps.LatLng(37.566826, 126.9786567)
//   });
// }

// 장소검색이 완료됐을 때 호출되는 콜백함수 입니다
function placesSearchCB(status, data, pagination) {
  if (status === daum.maps.services.Status.OK) {
    // 정상적으로 검색이 완료됐으면
    // 검색 목록과 마커를 표출합니다
    displayPlaces(data.places);

  } else if (status === daum.maps.services.Status.ZERO_RESULT) {

    alert('검색 결과가 존재하지 않습니다.');
    return;

  } else if (status === daum.maps.services.Status.ERROR) {

    alert('검색 결과 중 오류가 발생했습니다.');
    return;

  }
}

// 검색 결과 목록과 마커를 표출하는 함수입니다
function displayPlaces(places) {

  var listEl = document.getElementById('placesList'),
      menuEl = document.getElementById('menu_wrap'),
      fragment = document.createDocumentFragment(),
      bounds = new daum.maps.LatLngBounds(),
      listStr = '';

  // 검색 결과 목록에 추가된 항목들을 제거합니다
  removeAllChildNods(listEl);

  // 지도에 표시되고 있는 마커를 제거합니다
  removeMarker();

  for (var i = 0; i < places.length; i++) {

    // 마커를 생성하고 지도에 표시합니다
    var placePosition = new daum.maps.LatLng(places[i].latitude, places[i].longitude),
        marker = addMarker(placePosition, i),
        itemEl = getListItem(i, places[i], marker); // 검색 결과 항목 Element를 생성합니다

    // 검색된 장소 위치를 기준으로 지도 범위를 재설정하기위해
    // LatLngBounds 객체에 좌표를 추가합니다
    bounds.extend(placePosition);

    // 마커와 검색결과 항목에 mouseover 했을때
    // 해당 장소에 인포윈도우에 장소명을 표시합니다
    // mouseout 했을 때는 인포윈도우를 닫습니다
    (function (marker, title) {
      daum.maps.event.addListener(marker, 'mouseover', function () {
        displayInfowindow(marker, title);
      });

      daum.maps.event.addListener(marker, 'mouseout', function () {
        infowindow.close();
      });

      itemEl.onmouseover = function () {
        displayInfowindow(marker, title);
      };

      itemEl.onmouseout = function () {
        infowindow.close();
      };
    })(marker, places[i].title);

    fragment.appendChild(itemEl);
  }

  // 검색결과 항목들을 검색결과 목록 Elemnet에 추가합니다
  listEl.appendChild(fragment);
  menuEl.scrollTop = 0;

  // 검색된 장소 위치를 기준으로 지도 범위를 재설정합니다
  map.setBounds(bounds);
}

// 검색결과 항목을 Element로 반환하는 함수입니다
function getListItem(index, places) {
  console.log(places)
  var el = document.createElement('li'),
      itemStr = '<span class="markerbg marker_' + (index + 1) + '"></span>' +
      '<div class="info">' +
      '   <h5>' + places.title + '</h5>';

  if (places.newAddress) {
    itemStr += '    <span>' + places.newAddress + '</span>' +
      '   <span class="jibun gray">' + places.address + '</span>';
  } else {
    itemStr += '    <span>' + places.address + '</span>';
  }

  itemStr += '  <span class="tel">' + places.phone + '</span>' +
    '</div>';

  el.innerHTML = itemStr;
  el.className = 'item';

  return el;
}

// 마커를 생성하고 지도 위에 마커를 표시하는 함수입니다
function addMarker(position, idx, title) {
  var imageSrc =
      'http://i1.daumcdn.net/localimg/localimages/07/mapapidoc/marker_number_blue.png', // 마커 이미지 url, 스프라이트 이미지를 씁니다
      imageSize = new daum.maps.Size(36, 37), // 마커 이미지의 크기
      imgOptions = {
        spriteSize: new daum.maps.Size(36, 691), // 스프라이트 이미지의 크기
        spriteOrigin: new daum.maps.Point(0, (idx * 46) + 10), // 스프라이트 이미지 중 사용할 영역의 좌상단 좌표
        offset: new daum.maps.Point(13, 37) // 마커 좌표에 일치시킬 이미지 내에서의 좌표
      },
      markerImage = new daum.maps.MarkerImage(imageSrc, imageSize, imgOptions),
      marker = new daum.maps.Marker({
        position: position, // 마커의 위치
        image: markerImage
      });

  marker.setMap(map); // 지도 위에 마커를 표출합니다
  markers.push(marker); // 배열에 생성된 마커를 추가합니다

  return marker;
}

// 지도 위에 표시되고 있는 마커를 모두 제거합니다
function removeMarker() {
  for (var i = 0; i < markers.length; i++) {
    markers[i].setMap(null);
  }
  markers = [];
}

// 검색결과 목록 또는 마커를 클릭했을 때 호출되는 함수입니다
// 인포윈도우에 장소명을 표시합니다
function displayInfowindow(marker, title) {
  var content = '<div style="padding:5px;z-index:1;">' + title + '</div>';

  infowindow.setContent(content);
  infowindow.open(map, marker);
}

// 검색결과 목록의 자식 Element를 제거하는 함수입니다
function removeAllChildNods(el) {
  while (el.hasChildNodes()) {
    el.removeChild(el.lastChild);
  }
}
