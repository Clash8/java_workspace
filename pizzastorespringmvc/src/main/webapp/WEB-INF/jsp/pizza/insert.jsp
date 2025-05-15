<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!doctype html>
<html lang="it" class="h-100" >
	 <head>
	 
	 	<!-- Common imports in pages -->
	 	<jsp:include page="../header.jsp" />
	 	 <style>
		    .error_field {
		        color: red; 
		    }
		</style>
	   
	   <title>Inserisci Nuovo Elemento</title>
	 </head>
	   <body class="d-flex flex-column h-100">
	   
	   		<!-- Fixed navbar -->
	   		<jsp:include page="../navbar.jsp"></jsp:include>
	    
			
			<!-- Begin page content -->
			<main class="flex-shrink-0">
			  <div class="container">
			  
			  		<%-- se l'attributo in request ha errori --%>
					<spring:hasBindErrors  name="insert_pizza_attr">
						<%-- alert errori --%>
						<div class="alert alert-danger " role="alert">
							Attenzione!! Sono presenti errori di validazione
						</div>
					</spring:hasBindErrors>
			  
			  		<div class="alert alert-danger alert-dismissible fade show ${errorMessage==null?'d-none':'' }" role="alert">
					  ${errorMessage}
					  <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close" ></button>
					</div>
			  
			  <div class='card'>
				    <div class='card-header'>
				        <h5>Inserisci nuovo elemento</h5> 
				    </div>
				    <div class='card-body'>
		
							<h6 class="card-title">I campi con <span class="text-danger">*</span> sono obbligatori</h6>
		
		
							<form:form modelAttribute="insert_pizza_attr" method="post" action="save" novalidate="novalidate" class="row g-3">
					
							
								<div class="col-md-6">
									<label for="descrizione" class="form-label">Descrizione <span class="text-danger">*</span></label>
									<spring:bind path="descrizione">
									<input type="text" name="descrizione" id="descrizione" class="form-control ${status.error ? 'is-invalid' : ''}" placeholder="Inserire la descrizione" value="${insert_pizza_attr.descrizione }" required>
									</spring:bind>
									<form:errors  path="descrizione" cssClass="error_field" />
								</div>
								
								<div class="col-md-6">
									<label for="ingredienti" class="form-label">Ingredienti </label>
									<spring:bind path="ingredienti">
									<input type="text" name="ingredienti" id="ingredienti" class="form-control ${status.error ? 'is-invalid' : ''}" placeholder="Inserire il ingredienti" value="${insert_pizza_attr.ingredienti }">
									</spring:bind>
									<form:errors  path="ingredienti" cssClass="error_field" />
								</div>
							
								<div class="col-md-6">
									<label for="prezzoBase" class="form-label">Prezzo Base <span class="text-danger">*</span></label>
									<spring:bind path="prezzoBase">
									<input type="number" step="0.5" class="form-control ${status.error ? 'is-invalid' : ''}" name="prezzoBase" id="prezzoBase" placeholder="Inserire il prezzo base" value="${insert_pizza_attr.prezzoBase }">
									</spring:bind>
									<form:errors  path="prezzoBase" cssClass="error_field" />
								</div>

								<div class="col-md-6">
									<label for="attivo" class="form-label">Attivo </label>
									<spring:bind path="attivo">
										<select class="form-select ${status.error ? 'is-invalid' : ''}" id="attivo" name="attivo">
											<option value="" selected> - Selezionare - </option>
											<option value="true" ${insert_pizza_attr.attivo == 'true'?'selected':''} >Vero</option>
											<option value="false" ${insert_pizza_attr.attivo == 'false'?'selected':''} >Falso</option>
										</select>
									</spring:bind>
									<form:errors  path="attivo" cssClass="error_field" />
								</div>
								
							<div class="col-12">
								<button type="submit" name="submit" value="submit" id="submit" class="btn btn-primary">Conferma</button>
							</div>
		
						</form:form>
  
				    
				    
					<!-- end card-body -->			   
				    </div>
				<!-- end card -->
				</div>		
					  
			    
			  <!-- end container -->  
			  </div>
			  
			</main>
			
			<!-- Footer -->
			<jsp:include page="../footer.jsp" />
	  </body>
</html>