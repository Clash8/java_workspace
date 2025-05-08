<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!doctype html>
<script>
	document.addEventListener('DOMContentLoaded', function () {
		const exampleModal = document.getElementById('exampleModal');
		exampleModal.addEventListener('show.bs.modal', function (event) {
			const button = event.relatedTarget;
			const empId = button.getAttribute('data-emp-id');

			// Set the ID in the modal text
			document.getElementById('modal-employee-id').textContent = empId;

			// Set the delete link
			const deleteBtn = document.getElementById('confirm-delete-btn');

			console.log(empId);
			deleteBtn.href = "${pageContext.request.contextPath}/satellite/delete/" + empId;
		});
	});
</script>
<html lang="it" class="h-100" >
	 <head>
	 
	 	<!-- Common imports in pages -->
	 	<jsp:include page="../header.jsp" />
	   
	   <title>Pagina dei Risultati</title>
	 </head>
	 
	<body class="d-flex flex-column h-100">
	 
		<!-- Fixed navbar -->
		<jsp:include page="../navbar.jsp"></jsp:include>
	 
	
		<!-- Begin page content -->
		<main class="flex-shrink-0">
		  <div class="container">
		  
		  		<div class="alert alert-success alert-dismissible fade show  ${successMessage==null?'d-none':'' }" role="alert">
				  ${successMessage}
				  <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close" ></button>
				</div>
				<div class="alert alert-danger alert-dismissible fade show d-none" role="alert">
				  Esempio di operazione fallita!
				  <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close" ></button>
				</div>
				<div class="alert alert-info alert-dismissible fade show d-none" role="alert">
				  Aggiungere d-none nelle class per non far apparire
				   <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close" ></button>
				</div>
		  
		  
		  
		  		<div class='card'>
				    <div class='card-header'>
				        <h5>Lista dei risultati ${listName}</h5>
				    </div>
				    <div class='card-body'>
				    	<a class="btn btn-primary " href="${pageContext.request.contextPath}/satellite/insert">Add New</a>
				    
				        <div class='table-responsive'>
				            <table class='table table-striped ' >
				                <thead>
				                    <tr>
			                         	<th>Denominazione</th>
				                        <th>Codice</th>
				                        <th>Data di Lancio</th>
				                        <th>Data di Rientro</th>
				                        <th>Stato</th>
				                        <th>Azioni</th>
				                    </tr>
				                </thead>
				                <tbody>
				                	<c:forEach items="${satellite_list_attribute }" var="satelliteItem">
										<tr>
											<td>${satelliteItem.denominazione }</td>
											<td>${satelliteItem.codice }</td>
											<td>
												<fmt:parseDate value="${satelliteItem.dataLancio}" pattern="yyyy-MM-dd" var="localDateToBeParsed" type="date"/>
												<fmt:formatDate pattern="dd/MM/yyyy" value="${localDateToBeParsed}" />
											</td>
											<td>
												<fmt:parseDate value="${satelliteItem.dataRientro}" pattern="yyyy-MM-dd" var="localDateToBeParsed" type="date"/>
												<fmt:formatDate pattern="dd/MM/yyyy" value="${localDateToBeParsed}" />
											</td>
											<td>${satelliteItem.stato }</td>
											<td>
												<a class="btn  btn-sm btn-outline-secondary" href="${pageContext.request.contextPath}/satellite/show/${satelliteItem.id}">Visualizza</a>
												<a class="btn  btn-sm btn-outline-primary ml-2 mr-2" href="${pageContext.request.contextPath}/satellite/edit/${satelliteItem.id}">Edit</a>
												<a class="btn btn-outline-danger btn-sm" data-bs-toggle="modal" data-bs-target="#exampleModal" data-emp-id="${satelliteItem.id}">Delete</a>
											</td>
										</tr>
									</c:forEach>
				                </tbody>
				            </table>
				        </div>
				        
				        <div class="col-12">
							<a href="${pageContext.request.contextPath}/satellite/search" class='btn btn-outline-secondary' style='width:80px'>
					            <i class='fa fa-chevron-left'></i> Back 
					        </a>
						</div>
				   
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



<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel">
					Sei sicuro di voler eliminare il satellite con id: <span id="modal-employee-id"></span>?
				</h5>
				<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Chiudi</button>
				<a id="confirm-delete-btn" href="#" class="btn btn-danger">Elimina</a>
			</div>
		</div>
	</div>
</div>