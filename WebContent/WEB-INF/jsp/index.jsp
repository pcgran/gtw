<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<jsp:include page="top.jsp" />
	
	<div class="container">
		<h2>Twitter search</h2>
		<form role="form" action="processSearch">
			<div class="form-group">
				<div class="form-row">
					<input type="checkbox" name="option1" value="option1"/>
					Key words <input type="text" class="form-control form-input" placeholder="Search Twitter..." name="q" />
				</div>
				<div class="form-row">	
					<input type="checkbox" name="option1" value="option1"/>
					Language
					<select>
						<option>en</option>
					</select>
				</div>
				<div class="form-row">	
					<input type="checkbox" name="option1" value="option1"/>
					Region
					<select>
						<option>es</option>
					</select>
				</div>
				<div class="form-row">	
					<input type="checkbox" name="option1" value="option1"/>
					Mood
					<select>
						<option>:)</option>
						<option>:(</option>
					</select>
				</div>
				<div class="form-row">	
					<input type="checkbox" name="option1" value="option1"/>
					Number of results <input type="text" class="form-control form-input" name="number-results" />
				</div>
				<button type="submit" class="btn btn-success form-button">Search</button>
			</div>
		</form>
	</div>
	<jsp:include page="foot.jsp" />
</body>

</html>
