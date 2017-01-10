<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<title>Harvest Manager | Home</title>
<link href="/static/css/bootstrap.min.css" rel="stylesheet"
	type="text/css" />
</head>
<body>
<div role="navigation">
		<div class="navbar navbar-inverse">
			<a href="/" class="navbar-brand">Home</a>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li><a href="new-harvest">New Harvest</a></li>
					<li><a href="all-harvests">All Harvest</a></li>

				</ul>
			</div>
		</div>
	</div>
	<c:choose>
		<c:when test="${mode=='MODE_HOME'}">
			<div class="container" id="homeDiv">
				<div class="jumbotron text-center">
					<h1>Welcome to Harvest Manager</h1>
				</div>
			</div>
		</c:when>
		<c:when test="${mode=='MODE_HARVESTS'}">
			<div class="container text-center" id="harvestsDiv">
				<h3>My harvests</h3>
				<hr />
				<div class="table-responsive">
					<table class="table table-striped table-bordered text-left">
						<thead>
							<tr>
								<th>Id</th>
								<th>Site</th>
								<th>Site Code</th>
								<th>Station</th>
								<th>Sample Date</th>
								<th>Variable</th>
								<th></th>
								<th></th>
							</tr>
						</thead>
						
						<tbody>
							<c:forEach var="harvest" items="${harvests}">
									<tr>
										<td>${harvest.id}</td>
										<td>${harvest.site}</td>
										<td>${harvest.siteCode}</td>
										<td>${harvest.station}</td>
										<td>${harvest.sampleDate}</td>
										<td>${harvest.variable}</td>
										
										
										<td>
											<a href="update-harvest?id=${harvest.id}">
												<span class="glyphicon glyphicon-pencil"></span>
											</a>
										</td>
										<td>
											<a href="delete-harvest?id=${harvest.id}">
												<span class="glyphicon glyphicon-trash"></span>
											</a>
										</td>
									</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</c:when>
		
		<c:when test="${mode=='MODE_NEW' || mode=='MODE_UPDATE'}">
			<div class="container text-center">
				<h3>Manage Harvest</h3>
				<hr />
				<form class="form-horizontal" method="POST" action="save-harvest">
					<input type="hidden" name="id" value="${harvest.id}"/>
					
						<div class="form-group">
							<label class="control-label col-sm-3">Site:</label>
							<div class="col-sm-7">
								<input type="text" class="form-control" name="site" value="${harvest.site}" />
							</div>
						</div>
						
						<div class="form-group">
							<label class="control-label col-sm-3">Site Code:</label>
							<div class="col-sm-7">
								<input type="text" class="form-control" name="siteCode" value="${harvest.siteCode }" />
							</div>
						</div>
						
						<div class="form-group">
							<label class="control-label col-sm-3">Station:</label>
							<div class="col-sm-7">
								<input type="text" class="form-control" name="station" value="${harvest.station }" />
							</div>
						</div>
										<div class="form-group">
							<label class="control-label col-sm-3">Sample Date:</label>
							<div class="col-sm-7">
								<input type="text" class="form-control" name="sampleDate" value="${harvest.sampleDate }" />
							</div>
						</div>
						
						<div class="form-group">
							<label class="control-label col-sm-3">Variable:</label>
							<div class="col-sm-7">
								<input type="text" class="form-control" name="variable" value="${harvest.variable }" />
							</div>
						</div>
						

						
						<div class="form-group">
							<input type="submit" class="btn btn-primary" value="Save" />
						</div>
						
				</form>
			</div>
		
		</c:when>
		
		
		
	</c:choose>
	<script type="text/javascript" src="/static/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="/static/js/jquery-3.1.1.min.js"></script>
	
</body>
</html>