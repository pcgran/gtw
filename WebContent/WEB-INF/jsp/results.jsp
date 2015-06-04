		<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
		<jsp:include page="top.jsp" />
			<div class="container">
				<c:forEach var="tweet" items="${results}">
					<div class="panel panel-default">
						<div class="panel-body">
							<div class="media">
								<div class="media-left">
									<a href="#"> <img class="media-object profile-img" src="${tweet.getUser().getOriginalProfileImageURL()}" alt="profile-img"></a>
								</div>
								<div class="media-body">
									<h4 class="media-heading"><c:out value="@${tweet.getUser().getScreenName()}" /></h4>
									<c:out value="${tweet.getText()}" />
								</div>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</div> <!-- wrapper close -->
		<jsp:include page="foot.jsp" />
	</body>
</html>