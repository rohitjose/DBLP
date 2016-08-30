<%@ page import="comp9321.assignment1.dblp.ParseXMLFile, java.util.*"%>
<!--Content Data-->
<%
		int retrieve_count = 12;

	ArrayList<HashMap<String, String>> article_list = new ArrayList<HashMap<String, String>>();

	article_list = ParseXMLFile.getRandomDocuments(retrieve_count);
	if (article_list.size() > 0) {
		for (HashMap<String, String> article : article_list) {
%>
<!-- Item -->

<%
	String title_value = article.get("title");
	int hashcode = Math.abs(article.hashCode());
%>
<div class="col-md-3">
	<!-- Item -->

	<div class="panel panel-primary">
		<!--Panel Definition-->
		<div class="panel-heading">
			<button id="myBtn_<%=hashcode%>"
				class="btn btn-primary  btn-block btn-sm"
				onclick="modal_open(<%=hashcode%>)">
				<%=title_value%></button>
		</div>
		<!--Panel heading-->
		<div class="panel-body">
			<!--Panel Body-->

			<table class="table table-striped">
				<%
					String type = article.get("type");
					String mdate = article.get(type + "_mdate");
					String mkey = article.get(type + "_key");
					String year = article.get("year");
				%>
				<tr>
					<th>Key</th>
					<td><%=mkey%></td>
				</tr>
				<tr>
					<th>Type</th>
					<td><%=type%></td>
				</tr>
				<tr>
					<th>Modified Date</th>
					<td><%=mdate%></td>
				</tr>
				<tr>
					<th>Year</th>
					<td><%=year%></td>
				</tr>
			</table>
		</div>
		<!--Panel body end-->
	</div>
	<!--Panel Definition end-->
</div>
<!--Item End-->

<!-- The Modal -->
<div id="myModal_<%=hashcode%>" class="modal col-md-4">

	<!-- Modal content -->
	<div class="modal-content">
		<span class="close_<%=hashcode%> close" onclick="close_modal(<%=hashcode%>)">x&nbsp;</span>

		<div class="panel panel-primary">
			<!--Panel Definition-->

			<div class="panel-heading"><%=title_value%></div>
			<!--Panel heading-->

			<div class="panel-body">
				<!--Panel Body-->
				<form name="cart<%=hashcode%>" method="post" action="cart" onsubmit="formSubmit(<%=hashcode%>); return false;">
				<table class="table table-striped">
				<input type="hidden" name="title_<%=hashcode%>" value="<%=title_value%>" id="title_<%=hashcode%>"/>
					<%
						for (String key : article.keySet()) {
									if (!key.equals("title")) {
										String header_value = key;
										String data_value = article.get(key);
					%>
					<tr>
						<th><%=header_value%></th>
						<td><%=data_value%></td>
						<input type="hidden" name="<%=header_value%>_<%=hashcode%>" value="<%=data_value%> id="<%=header_value%>_<%=hashcode%>"/>
					</tr>
					<%
						}}
					%>
				</table>
				<input type="hidden" name="form_action" value="add_cart"/>
				<input class="btn btn-primary btn-xs" type="submit" value="Add to Cart"></input>
				</form>
			</div>
			<!--Panel body end-->
		</div>
		<!--Panel Definition end-->
	</div>
	<!--Item End-->

</div>


<%
	}
	}
%>