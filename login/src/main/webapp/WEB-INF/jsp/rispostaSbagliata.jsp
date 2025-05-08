<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Risposta Errata</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 20px;
            background-color: #f5f5f5;
        }
        .container {
            max-width: 600px;
            margin: 0 auto;
            background-color: white;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
            text-align: center;
        }
        h1 {
            color: #f44336;
        }
        p {
            font-size: 18px;
            margin: 20px 0;
        }
        a {
            display: inline-block;
            background-color: #2196F3;
            color: white;
            padding: 10px 15px;
            text-decoration: none;
            border-radius: 4px;
            margin-top: 20px;
        }
        a:hover {
            background-color: #0b7dda;
        }
        .error-icon {
            font-size: 60px;
            color: #f44336;
            margin-bottom: 20px;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="error-icon">✗</div>
    <h1>Mi dispiace!</h1>
    <p>La tua risposta non è corretta.</p>
    <p>Ti preghiamo di riprovare.</p>

    <a href="/">Torna alla domanda</a>
</div>
</body>
</html>