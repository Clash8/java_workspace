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
					<spring:hasBindErrors  name="insert_ordine_attr">
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
		
		
							<form:form modelAttribute="insert_ordine_attr" method="post" action="save" novalidate="novalidate" class="row g-3">

								<div class="col-md-6">
									<label for="codice" class="form-label">Codice <span class="text-danger">*</span></label>
									<spring:bind path="codice">
									<input type="text" name="codice" id="codice" class="form-control ${status.error ? 'is-invalid' : ''}" placeholder="Inserire il codice" value="${insert_ordine_attr.codice}" required>
									</spring:bind>
									<form:errors  path="codice" cssClass="error_field" />
								</div>

								<fmt:formatDate pattern='yyyy-MM-dd' var="parsedDate" type='date' value='${insert_ordine_attr.dataOrdine}' />
								<div class="col-md-6">
									<label for="dataOrdine" class="form-label">Data Ordine</label>
                        			<spring:bind path="dataOrdine">
	                        		<input class="form-control ${status.error ? 'is-invalid' : ''}" id="dataOrdine" type="date" placeholder="dd/MM/yy"
	                            		title="formato : gg/mm/aaaa"  name="dataOrdine" required
	                            		value="${parsedDate}" >
		                            </spring:bind>
	                            	<form:errors  path="dataOrdine" cssClass="error_field" />
								</div>

								<div class="col-md-6">
									<label for="cliente.id" class="form-label">Cliente</label>
									<spring:bind path="cliente">
									<select class="form-select" id="cliente.id" name="cliente.id">
										<option value=""> -- Selezionare una voce -- </option>
										<c:forEach items="${clienti_list_attribute}" var="clienteItem">
											<option value="${clienteItem.id}" ${insert_ordine_attr.cliente.id == clienteItem.id ? 'selected' : ''}>${clienteItem.nome} ${clienteItem.cognome}</option>
										</c:forEach>
									</select>
									</spring:bind>
									<form:errors  path="cliente" cssClass="error_field" />
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