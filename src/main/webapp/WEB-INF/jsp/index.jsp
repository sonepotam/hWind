<%@ page import="java.util.List" %>
<%@ page import="org.springframework.data.domain.Page" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form" %>

<%@ page session="false" %>
<%@ page language="java" session="false"%>




<html>
<head>
<meta content="text/html; charset=utf-8" http-equiv="content-type">



<!-- jQuery -->
<script src="http://code.jquery.com/jquery-1.10.2.js"></script>


<script src="https://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>


<link href="http://code.jquery.com/ui/1.10.4/themes/ui-lightness/jquery-ui.css" rel="stylesheet">
<script src="http://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>



<!-- Bootstrap -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>


<!-- DataTable -->
<script src="https://cdn.datatables.net/1.10.11/js/jquery.dataTables.min.js"></script>
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.11/css/jquery.dataTables.min.css">

<!-- Noty -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-noty/2.3.7/packaged/jquery.noty.packaged.min.js"></script>
<link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.4.0/animate.min.css">

<!-- hwind -->
<script src="<c:url value="/resources/js/controller.js" />"></script>


</head>
<body>


<div class="navbar navbar-inverse navbar-static-top">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#responsive-menu">
				<span class="sr-only">Открыть навигацию</span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<a class="navbar-brand navbar-right" href="http://www.github.com/sonepotam">GitHub</a>
		</div>

	</div>
</div>

<h2>hWind TEST Application</h2>
<hr>

<div class="jumbotron">
	<div class="container">
		<div class="shadow">
            <!-- panel -->
            <div class="panel panel-primary">
                <div class="panel-heading">
                    <h3 class="panel-title">Редактирование данных о продукте</h3>
                </div>
                <div class="panel-body">
                <!-- panel -->

                <div class="view-box">
				<table class="table table-striped table-bordered" id="datatable">
					<thead>
					    <th>id</th>
						<th>Название</th>
					    <th>Тип</th>
					    <th>Приправа</th>
					    <th></th>
					    <th></th>
                    </thead>
					<tbody>

					  <tr>
						  <td>1</td>
						  <td>Какое-то название</td>
						  <td>Твердый</td>
						  <td>Да</td>
						  <td>Delete</td>
						  <td>Edit</td>
					  </tr>

					</tbody>
				</table>
                </div> <!-- panel body -->
            </div>
			</div> <!-- panel -->
		</div>

		</div>
</div>


 


</body>



</html>
