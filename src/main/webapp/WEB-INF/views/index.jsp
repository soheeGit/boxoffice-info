<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>영화 추천</title>
    <style>
        @font-face {
            font-family: 'GmarketSansMedium';
            src: url('https://fastly.jsdelivr.net/gh/projectnoonnu/noonfonts_2001@1.1/GmarketSansMedium.woff') format('woff');
            font-weight: normal;
            font-style: normal;
        }
        body {
            font-family: GmarketSansMedium, serif;
        }
    </style>
</head>
<body>
    <p><%= request.getAttribute("movies") %></p>
    <p><%= request.getAttribute("recommendation") %></p>
</body>
</html>
