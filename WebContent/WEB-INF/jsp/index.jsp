<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<jsp:include page="top.jsp" />
	
	<div class="container">
		<h2>Twitter search</h2>
		<form role="form" action="processSearch">
			<div class="form-group">
				<div class="form-row">
					<div class="checkcolumn"><input type="checkbox" id="option1" checked/></div>
					<div class="firstcolumn">Keywords</div> 
					<div class="secondcolumn"><input type="text" id="keywords-text" class="form-control form-input" placeholder="Search Twitter..." name="q" /></div>
				</div>
				<div class="form-row">	
					<div class="checkcolumn"><input type="checkbox" id="option2"/></div>
					<div class="firstcolumn">Language</div>
					<div class="secondcolumn">
						<select id="lang" disabled>
							<option value="en">en</option>
						</select>
					</div>
				</div>
				<div class="form-row">	
					<div class="checkcolumn"><input type="checkbox" id="option3"/></div>
					<div class="firstcolumn">Region</div>
					<div class="secondcolumn">
						<select id="region" disabled>
							<option value="es">es</option>
						</select>
					</div>
				</div>
				<div class="form-row">	
					<div class="checkcolumn"><input type="checkbox" id="option4"/></div>
					<div class="firstcolumn">Mood</div>
					<div class="secondcolumn">
						<select id="mood" disabled>
							<option value="happy">:)</option>
							<option value="sad">:(</option>
						</select>
					</div>
				</div>
				<div class="form-row">	
					<div class="checkcolumn"><input type="checkbox" id="option5"/></div>
					<div class="firstcolumn">Number of results</div>
					<div class="secondcolumn"><input type="text" id="number-results" class="form-control form-input" name="number-results" disabled/></div>
				</div>
				<button type="submit" class="btn btn-success form-button">Search</button>
			</div>
		</form>
	</div>
	<jsp:include page="foot.jsp" />
</body>

</html>
