<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" />
    <title>Home</title>
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
</script>
<body>
    <div class="container">

        <h1 class="text-center">Hello Spring</h1>


        <div class="d-flex justify-content-center">
            <p>
                <a href="/select">포인트 조회</a> |
                <a href="/histories">포인트 충전/이용 내역 조회</a> |
                <a href="/charge">포인트 충전</a> |
                <a href="/buy">포인트 사용</a>
            </p><br>
        </div>
        <div class="d-flex justify-content-center">
            <p>
                <a href="/login">로그인</a> |
                <a href="/join">회원가입</a>
            </p>
        </div>

    </div>
</body>
</html>