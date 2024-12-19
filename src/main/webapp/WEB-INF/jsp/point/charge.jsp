<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" />
    <title>charge</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <script src="https://code.jquery.com/jquery-3.6.4.min.js" integrity="sha256-oP6HI9z1XaZNBrJURtCoUT5SUnxFr8s3BzRl+cbzUq8=" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">

    <link rel="stylesheet" href="/static/css/style.css" type="text/css">
</head>
<style>
    .container{
        width:1000px;

        margin:auto;
    }
</style>
<script>
    //한글, 영어, 특수문자 제거 (포인트)
    function filterInput(input) {
        setTimeout(function() {
            input.value = input.value.replace(/[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]/g, '')  // 한글 제거
                                    .replace(/[a-zA-Z]/g, '')// 영어제거
                                    .replace(/[~!@#$%^&*()_+|<>?:{}.,\/]/g, '');  // 특수문자 제거
        }, 0); // 입력이 완료된 후에 한글, 영어, 특수문자 제거
    }

</script>
<body>
    <div class="container">

        <h1 class="text-center">포인트 충전</h1>

        <div class="d-flex justify-content-center">

            <div>ㅇㅇㅇ 님</div>
            <div>현재 포인트 : 포인트</div><br>

        </div><br>
        <div class="d-flex justify-content-center">
              <input type="text" oninput="filterInput(this)" id="pointInput" value="" class="form-control col-3">
              <div class="mt-2"> 포인트  </div>
              <button id="chargeBtn" class="btn btn-sm btn-primary">충전하기</button>
        </div>


        <br>
        <a href="/">홈으로</a>
    </div>
</body>
</html>