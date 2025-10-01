<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>LifeCycleTest</title>
</head>
<body>
<h1>라이프 사이클 테스트
</h1>
<br/>
<a href="xml-lifecycle">XML 설정</a>
<a href="annotation-lifecycle">Annotation 설정</a>

<h1>Service 메소드의 역할</h1>
<h2>a 태그</h2>
<a href="request-service">서비스 메소드 요청</a>
<h2>form 태그 (get)</h2>
<form action="request-service" method="get">
    <input type="submit" name="q" value="get 방식 요청">
</form>
<h2>form 태그 (post)</h2>
<form action="request-service" method="post">
    <input type="submit" value="post 방식 요청">
</form>


<h1>Request Parameter</h1>
<h2>GET 방식의 요청</h2>
<h3>form 태그를 이용한 get 방식 요청</h3>
<form action="querystring" method="get">
    <label>이름 : </label><input type="text" name="name">
    <br>
    <label>나이 : </label><input type="number" name="age">
    <br>
    <label>생일 : </label><input type="date" name="birthday">
    <br>
    <label>성별 : </label>
    <input type="radio" name="gender" id="male" value="M"><label for="male">남자</label>
    <input type="radio" name="gender" id="female" value="F"><label for="female">여자</label>
    <br>
    <label>국적 : </label>
    <select name="national">
        <option value="ko">한국</option>
        <option value="ch">중국</option>
        <option value="jp">일본</option>
        <option value="etc">기타</option>
    </select>
    <br>
    <label>취미 : </label>
    <input type="checkbox" name="hobbies" id="movie" value="movie"><label for="movie">영화</label>
    <input type="checkbox" name="hobbies" id="music" value="music"><label for="music">음악</label>
    <input type="checkbox" name="hobbies" id="sleep" value="sleep"><label for="sleep">취침</label>
    <br>

    <input type="submit" value="GET 요청">

</form>
<h2>POST 방식의 요청</h2>
<h3>form 태그를 이용한 post 방식 요청</h3>
<form action="formdata" method="post">
    <label>이름 : </label><input type="text" name="name">
    <br>
    <label>나이 : </label><input type="number" name="age">
    <br>
    <label>생일 : </label><input type="date" name="birthday">
    <br>
    <label>성별 : </label>
    <input type="radio" name="gender" id="male2" value="M"><label for="male2">남자</label>
    <input type="radio" name="gender" id="female2" value="F"><label for="female2">여자</label>
    <br>
    <label>국적 : </label>
    <select name="national">
        <option value="ko">한국</option>
        <option value="ch">중국</option>
        <option value="jp">일본</option>
        <option value="etc">기타</option>
    </select>
    <br>
    <label>취미 : </label>
    <input type="checkbox" name="hobbies" id="movie2" value="movie"><label for="movie2">영화</label>
    <input type="checkbox" name="hobbies" id="music2" value="music"><label for="music2">음악</label>
    <input type="checkbox" name="hobbies" id="sleep2" value="sleep"><label for="sleep2">취침</label>
    <br>

    <input type="submit" value="POST 요청">

</form>

<h1>Request Header 값 확인</h1>
<a href="headers">클릭</a>

<h1>응답 확인 테스트</h1>
<ul>
    <li><a href="response">응답 확인하기</a></li>
    <li><a href="headers-res">응답 헤더 변경 테스트</a></li>
    <li><a href="show404Error">404 Error</a></li>
    <li><a href="show500Error">500 Error</a></li>
</ul>

<h1>forward</h1>
<form action="forward" method="post">
    <table>
        <tr>
            <td>아이디 : </td>
            <td><input type="text" name="userId"></td>
        </tr>
        <tr>
            <td>비밀번호 : </td>
            <td><input type="password" name="password"></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="로그인"></td>
        </tr>
    </table>
    <h1>redirect</h1>
    <ul>
        <li><a href="othersite">네이버로 이동</a></li>
        <li><a href="otherservlet">다른 서블릿으로 재요청</a></li>
    </ul>
</form>
</body>
</html>