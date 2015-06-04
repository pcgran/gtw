<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<jsp:include page="top.jsp" />
	
	<div class="container">
		<h2>Twitter search</h2>
		<form role="form" action="processSearch">
			<div class="form-group">
				<div class="form-row">
					<div class="checkcolumn"><input type="checkbox" name="option1" value="option1"/></div>
					<div class="firstcolumn">Key words</div> 
					<div class="secondcolumn"><input type="text" class="form-control form-input" placeholder="Search Twitter..." name="q" /></div>
				</div>
				<div class="form-row">	
					<div class="checkcolumn"><input type="checkbox" name="option1" value="option1"/></div>
					<div class="firstcolumn">Language</div>
					<div class="secondcolumn">
						<select>
							<option>en</option>
						</select>
					</div>
				</div>
				<div class="form-row">	
					<div class="checkcolumn"><input type="checkbox" name="option1" value="option1"/></div>
					<div class="firstcolumn">Region</div>
					<div class="secondcolumn">
						<select>
							<option>es</option>
						</select>
					</div>
				</div>
				<div class="form-row">	
					<div class="checkcolumn"><input type="checkbox" name="option1" value="option1"/></div>
					<div class="firstcolumn">Mood</div>
					<div class="secondcolumn">
						<select>
							<option>:)</option>
							<option>:(</option>
						</select>
					</div>
				</div>
				<div class="form-row">	
					<div class="checkcolumn"><input type="checkbox" name="option1" value="option1"/></div>
					<div class="firstcolumn">Number of results</div>
					<div class="secondcolumn"><input type="text" class="form-control form-input" name="number-results" /></div>
				</div>
				<button type="submit" class="btn btn-success form-button">Search</button>
			</div>
		</form>
	</div>
	<jsp:include page="foot.jsp" />
</body>

</html>
