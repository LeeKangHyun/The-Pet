<%-- EL을 이용하여 게시물 데이터 출력하기 --%>
<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title> FASHION MAKER </title>

<link rel="stylesheet" type="text/css" href="../css/style.css" />

<link rel="stylesheet" href="http://netdna.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
<link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

</head>

<body>




  <!-- --------------------상품추가 구간-------------------- -->
    <div class="modal fade" id="squareProAddModal" tabindex="-1" role="dialog" aria-labelledby="modalLabel" aria-hidden="true">
      <div class="modal-dialog">
        <div class="modal-content">

          <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal">
              <span aria-hidden="true">×</span><span class="sr-only">Close</span>
            </button>
            <h3 class="modal-title" id="lineModalLabel">상품추가</h3>
          </div>

          <div class="modal-body">
            <section>
              <article>

              </article>
            </section>
          </div>
          
        </div>
      </div>
    </div>
   <!-- --------------------/상품추가 구간-------------------- -->


</body>
</html>
