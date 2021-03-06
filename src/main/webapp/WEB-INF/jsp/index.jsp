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


<div class="navbar navbar-inverse navbar-fixed-top">
	<div class="container">
		<div class="navbar-header navbar-brand">hWind TEST Application</div>
		<div class="navbar-collapse collapse">
			<ul class="nav navbar-nav navbar-right">
				<li>
					<a class="navbar-brand navbar-right" href="http://www.github.com/sonepotam">GitHub</a>
				</li>
			</ul>
		</div>
	</div>
</div>


<h2>hWind TEST Application</h2>
<hr>

<div class="jumbotron">
	<div class="container">
		<div class="shadow">
			<div class="panel panel-primary">
				<div class="panel-heading">
			       <h3 class="panel-title">Редактирование списка продуктов</h3>
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
					    	<th>Удалить</th>
					    	<th>Редактировать</th>
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
                	</div> <!-- view box -->
            	</div> <!-- panel-body -->

				<div class="panel-footer">

					<nav class="navbar navbar-default">
						<div class="container-fluid">
							<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">

								<form class="navbar-form navbar-left" >
									<div class="form-group">
										<!--
										<a href="#" class="btn btn-success dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Язык названия <span class="caret"></span></a>
										<ul id= "lang-support" class="dropdown-menu">
											<li value="en_en"><a href="#">Английский</a></li>
											<li value="ru_ru"><a href="#">Русский</a></li>
										</ul>
										-->
											<select id= "lang-support" class="form-control" onchange="setlang(this)">
												<option value="ru_ru" selected>Русский</option>
												<option value="en_en">Английский</option>
											</select>

										<a id="addRow"   class="btn btn-success" data-toggle="modal" data-target="#editRow">Добавить продукт</a>

									</div>
								</form>
							</div><!-- /.navbar-collapse -->
						</div>
					</nav>
						<!--
					<div class="btn-group">
						<p>
							<a id="addRow"   class="btn btn-success" data-toggle="modal" data-target="#editRow">Добавить продукт</a>

						</p>
				       </div>
				-->
				</div>
			</div> <!-- panel -->
		</div>
	</div>
</div>

<!-- окно для  продукта -->
<div class="modal fade" id="editRow">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
				<h2 class="modal-title">Редактирование продукта</h2>
			</div>
			<div class="modal-body">
				<form class="form-horizontal" method="post" id="detailsForm">
					<input id="prod-id" name="prod-id" hidden>
					<div class="form-group">
						<label for="prod-name" class="control-label col-sm-2">Продукт</label>
						<div class="col-sm-10">
							<input class="form-control" id="prod-name" name="prod-name" placeholder="Наименование продукта">
						</div>
					</div>

					<div class="form-group">
						<label for="prod-type" class="col-sm-2 control-label">Вид</label>
						<div class="col-sm-10">
							<select id= "prod-type" class="form-control">
								<option value="SOLID" >Твердый</option>
								<option value="LIQUID">Жидкий</option>
							</select>
						</div>
					</div>

					<div class="form-group">
						<label for="prod-spice" class="col-sm-2 control-label">Приправа</label>
						<div class="col-sm-10">
							<select id= "prod-spice" class="form-control">
								<option value="Y">Да</option>
								<option value="N">Нет</option>
							</select>
						</div>
					</div>

					<div class="form-group">
						<div class="col-xs-offset-3 col-sm-10">
							<button type="submit" class="btn btn-primary">Сохранить</button>
						</div>
					</div>

				</form>
			</div>
		</div>
	</div>
</div>
 


</body>



</html>
