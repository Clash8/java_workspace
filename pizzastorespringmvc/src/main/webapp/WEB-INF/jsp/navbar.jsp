<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<header>
  <!-- Fixed navbar -->
 <nav class="navbar navbar-expand-lg navbar-dark bg-primary" aria-label="Eighth navbar example">
    <div class="container">
      <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarsExample07" aria-controls="navbarsExample07" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>

      <div class="collapse navbar-collapse" id="navbarsExample07">
        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
          <li class="nav-item">
            <a class="nav-link active" aria-current="page" href="${pageContext.request.contextPath}/home">Home</a>
          </li>
          <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" id="dropdown07" data-bs-toggle="dropdown" aria-expanded="false">Dropdown</a>
            <ul class="dropdown-menu" aria-labelledby="dropdown07">
              <li><a class="dropdown-item" href="${pageContext.request.contextPath}/home">Home</a></li>
              <li><a class="dropdown-item" href="${pageContext.request.contextPath}/cliente/search">Ricerca clienti</a></li>
              <li><a class="dropdown-item" href="${pageContext.request.contextPath}/cliente/insert">Inserisci cliente</a></li>
              <li><a class="dropdown-item" href="${pageContext.request.contextPath}/ordine/search">Ricerca ordini</a></li>
              <li><a class="dropdown-item" href="${pageContext.request.contextPath}/ordine/insert">Inserisci ordine</a></li>
              <li><a class="dropdown-item" href="${pageContext.request.contextPath}/pizza/search">Ricerca pizze</a></li>
              <li><a class="dropdown-item" href="${pageContext.request.contextPath}/pizza/insert">Inserisci pizza</a></li>
            </ul> 
          </li>
          <c:if test="${userInfo.isAdmin() }">
-	      <li class="nav-item dropdown">
-	        <a class="nav-link dropdown-toggle" href="#" id="dropdown01" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Gestione Utenze</a>
-	        <div class="dropdown-menu" aria-labelledby="dropdown01">
              <a class="dropdown-item" href="${pageContext.request.contextPath}/cliente/search">Ricerca clienti</a>
              <a class="dropdown-item" href="${pageContext.request.contextPath}/cliente/insert">Inserisci cliente</a>
              <a class="dropdown-item" href="${pageContext.request.contextPath}/ordine/search">Ricerca ordini</a>
              <a class="dropdown-item" href="${pageContext.request.contextPath}/ordine/insert">Inserisci ordine</a>
              <a class="dropdown-item" href="${pageContext.request.contextPath}/pizza/search">Ricerca pizze</a>
              <a class="dropdown-item" href="${pageContext.request.contextPath}/pizza/insert">Inserisci pizza</a>
-	        </div>
-	      </li>
-	   </c:if>   
        </ul>
      </div>
      <div class="col-md-3 text-end">
        <p class="navbar-text">Utente: ${userInfo.username }(${userInfo.nome } ${userInfo.cognome })
    	 <a href="${pageContext.request.contextPath}/LogoutServlet">Logout</a></p>
      </div>
    </div>
  </nav>

  
  
</header>